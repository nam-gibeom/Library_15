package la.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import la.Bean.DiscardInfoBean;
import la.Bean.OverdueBean;
import la.Bean.RentBean;
import la.Bean.RentInfoBean;
import la.Bean.SearchBean;
import la.Bean.catalogListBean;
import la.Dao.BookDAO;
import la.Dao.DAOException;
import la.Dao.MemberDAO;

public class BookService {
	BookDAO dao;
	
	public BookService() throws DAOException {
		dao = new BookDAO();
	}
	
	public List<RentInfoBean> rentBooksById(int member_id, List<Integer> book_ids) throws DAOException {
		
		String current_date = getCurrentDate(); // yyyy-mm-dd 型
		
		List<RentInfoBean> list = new ArrayList<RentInfoBean>();
		
		// 入力してもらったIDごとに処理を行う
		for (int book_id : book_ids) {
			
			catalogListBean bean =  dao.getInfoByBookId(book_id); // 資料IDを用いて目録の情報を取得
			String publish_date = bean.getPublish_date(); // そのうち、出版日をyyyy-mm-ddとして取得
			
		
			int canRentDay = CalculatePeriod(publish_date, current_date);
			String return_deadline = CalculateReturnDeadline(current_date, canRentDay); // "yyyy-mm-dd"
			
			RentBean rent_info = dao.addRentListAndGetInfo(member_id, book_id, return_deadline); // 貸出台帳に登録後、その全ての行の情報を取得する
			String title = bean.getTitle(); // 資料目録から資料名を取得
			
			RentInfoBean result_bean = new RentInfoBean(rent_info.getBook_id(), title, rent_info.getReturn_deadline()); // 資料ID、資料名、返却期日をBeanにいれる
			list.add(result_bean);
			
		}
		return list;
		
	}
	
	public boolean isIsbnExist(String isbn) throws DAOException {
		catalogListBean bean =  dao.getInfoByIsbn(isbn); // 目録内のISBNを検索
		if (bean.getIsbn() == null) { // 存在しない場合、false
			return false;
		} else { // 存在する場合、True
			return true;
		}
	}
	
	public catalogListBean getStockInfoByIsbn(String isbn) throws DAOException {
		catalogListBean bean =  dao.getInfoByIsbn(isbn); // 目録内のISBNを検索
		return bean;
	}
	
	public List<OverdueBean> searchOverdueBooks(HttpServletRequest request) throws DAOException {
		 if (request.getAttribute("finalEditDate") == null) { // 最終更新日がない場合、登録
				request.setAttribute("finalEditDate", "2026-06-19");
		 }
		 String finalEditDate = (String) request.getAttribute("finalEditDate"); // 最終更新日を呼び出す。
		 String current_date = getCurrentDate();
		 
		 if (!current_date.equals(finalEditDate)) { // 最終更新日と当日の日付が一致しない場合
			 dao.updateRemarksDelay();
			 List<OverdueBean> overdue_list = dao.getRemarksAsOverdue();
			 
			 
			 
			 request.setAttribute("finalEditDate", current_date);
			 // メール
			 List<String> email_list = new ArrayList<String>();
			 for (OverdueBean bean : overdue_list) { // 延滞になった人の
				 int member_id = bean.getMember_id();
				 MemberDAO memberdao = new MemberDAO();
				 String mail_address = memberdao.findAll(member_id).getMember_mail();
				 email_list.add(mail_address);
			 }
			 Set<String> unique_mail_list = new HashSet<String>(email_list); // 重複削除
			 email_list = new ArrayList<String>(unique_mail_list); // またリストに戻す
			 
			 
			 return overdue_list;
		 } else {
			 throw new DAOException("失敗");	 
		 }
	}
	
	
	// 資料検索結果
	public List<SearchBean> searchBooks(String type, String value) throws NumberFormatException, DAOException {
		String type1 = null;
		String value1 = null;
		
		if (type.equals("book_id")) {
			type1 = "isbn";
			value1 = dao.getIsbnByBook((Integer.parseInt(value)));
		} else if (type.equals("isbn")) {
			type1 = "isbn";
			value1 = value;
		} else if (type.equals("title")) {
			type1 = "title";
			value1 = value;
		}
		
		List<catalogListBean> list = dao.getCatalogListInfo(type1, value1);
		List<SearchBean> Result_List = new ArrayList<SearchBean>();
		for (catalogListBean bean : list ) {
			int canRentDay;
			String current_date = getCurrentDate();
			int period = CalculatePeriod(bean.getPublish_date(), current_date);
			if (period <= 3) {
				canRentDay = 10;
			} else {
				canRentDay = 15;
			}
			canRentDay = CalculatePeriod(bean.getPublish_date(), current_date);
			
			String title = bean.getTitle();
			String category_name = bean.getCategory_name();
			String publish_date = bean.getPublish_date();
			int count_book = dao.getBookIdByIsbn(bean.getIsbn()).size();
			int count_rented_book = dao.getRentedBookCountByIsbn(bean.getIsbn());
			String rentAvailable = (count_book - count_rented_book) + "/" + count_book;
			
			SearchBean result_bean = new SearchBean(title, category_name, publish_date, canRentDay, rentAvailable);
			Result_List.add(result_bean);
			
		}
		return Result_List;
	}
	
	public List<RentInfoBean> showCurrentrentList(int member_id) {
		try {
			
			List<RentInfoBean> list = dao.getRentedBookIdTitlebyMember(member_id);
			return list;
		
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}
	
	//返却処理をする
	public void returnBook(int member_id, int book_id) {
		try {
		
			dao.updateReturnDate(member_id, book_id);
			
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
	    }
	}
	
	//在庫台帳に追加する
	public void addStock(String isbn) {
		try {
			String arrival_date = getCurrentDate();
			dao.addStockList(isbn, arrival_date);
			
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
	    }
	}
	
	//資料目録に追加する
	public void addCatalog (String isbn, String title, String category_name, String author, String publisher, String publish_date) {
 
		try {
			// 20260304
			String publish_date1 = publish_date.substring(0, 4) + "-" + publish_date.substring(4, 6) + "-" +publish_date.substring(6, 8);
			dao.addCatalogList(isbn,title,category_name,author,publisher,publish_date1);
			
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
	    }
	}
	
	//資料IDで廃棄する資料の情報を検索する
	public DiscardInfoBean searchDiscard (int book_id){
         try {
			DiscardInfoBean bean = dao.getStockListByBookId(book_id);
			return bean;
		
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}
	
	//資料の廃棄処理をする
	public void discardBook (int book_id, String discard_date, String remarks) {
		 try {
				
			 dao.updateStockListDiscard(book_id,discard_date,remarks);
				
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
		    }
	}
	
	
	// 現在の日付を'YYYY-MM-DD'として取得するメソッド
		public String getCurrentDate() {
			LocalDateTime nowDate = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formatedDate = format.format(nowDate);
			return formatedDate;
		}
		
		// 出版日から当日の日付まで何か月経ったのかを取得
		public int CalculatePeriod(String publish_date, String current_date) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate Publish = LocalDate.parse(publish_date, format);
			LocalDate Current = LocalDate.parse(current_date, format);
			
			if ((Period.between(Publish, Current).getYears() >= 1) || (Period.between(Publish, Current).getYears() == 0) && Period.between(Publish, Current).getMonths() >= 3) {
				return 15;
			} else {
				return 10;
			}

		}
		
		// 当日の日付に貸出可能な日数を計算して文字列で返還（"2026-06-19", 15） -> ("2026-07-04") 
		public String CalculateReturnDeadline(String current_date, int canRentDay) {
			Calendar cal = Calendar.getInstance();
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate Current = LocalDate.parse(current_date, format);
			java.util.Date a = Date.from(Current.atStartOfDay(ZoneId.systemDefault()).toInstant());
			cal.setTime(a);
			cal.add(Calendar.DAY_OF_MONTH, 15);
			java.util.Date bb =  cal.getTime();
			String return_deadline = format.format(bb.toInstant().atZone(ZoneId.systemDefault()));
			return return_deadline;
		}
}
