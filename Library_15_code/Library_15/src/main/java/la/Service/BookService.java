package la.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import la.Bean.RentBean;
import la.Bean.RentInfoBean;
import la.Bean.catalogListBean;
import la.Dao.BookDAO;
import la.Dao.DAOException;

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
			
			int period =  CalculatePeriod(publish_date, current_date); // 出版日から当日の日付まで何か月経ったのかを取得
		
			int canRentDay;
			if (period <= 3) {
				canRentDay = 10;
			} else {
				canRentDay = 15;
			}
			String return_deadline = CalculateReturnDeadline(current_date, canRentDay); // "yyyy-mm-dd"
			
			RentBean rent_info = dao.addRentListAndGetInfo(member_id, book_id, return_deadline); // 貸出台帳に登録後、その全ての行の情報を取得する
			String title = bean.getTitle(); // 資料目録から資料名を取得
			
			RentInfoBean result_bean = new RentInfoBean(rent_info.getBook_id(), title, rent_info.getReturn_deadline()); // 資料ID、資料名、返却期日をBeanにいれる
			list.add(result_bean);
			
		}
		return list;
		
	}
	
	public boolean isIsbnExist(String isbn) throws DAOException {
		dao.getInfoByIsbn(isbn);
		
		return true;
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
		int period = Period.between(Publish, Current).getMonths();
		return period;
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
