package la.Service;

import java.util.List;

import la.Bean.DiscardInfoBean;
import la.Bean.RentInfoBean;
import la.Dao.BookDAO;
import la.Dao.DAOException;

public class BookService1 {
	BookDAO dao;
	
	public BookService1() throws DAOException {
		dao = new BookDAO();
	}
	
	//会員IDの今の貸出中の資料情報を取る
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
	public void addStock(String isbn,String arrival_date) {
		try {
			
			dao.addStockList(isbn,arrival_date);
			
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
	    }
	}
	
	//資料目録に追加する
	public void addCatalog (String isbn, String title, int category_code, String author, String publisher, String publish_date) {
         try {
			
			dao.addCatalogList(isbn,title,category_code,author,publisher,publish_date);
			
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
	
	
	
	
}
