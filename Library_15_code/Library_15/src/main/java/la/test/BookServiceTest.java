package la.test;

import java.util.List;

import la.Bean.catalogListBean;
import la.Dao.BookDAO;
import la.Dao.DAOException;
import la.Service.BookService;

public class BookServiceTest {

	public static void main(String[] args) throws DAOException {
		BookDAO dao = new BookDAO();
		BookService service = new BookService();
		
		String type = "title";
		String value = "存在";
		
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
		for (catalogListBean bean : list ) {
			int canRentDay;
			String current_date = service.getCurrentDate();
			int period = service.CalculatePeriod(bean.getPublish_date(), current_date);
			if (period <= 3) {
				canRentDay = 10;
			} else {
				canRentDay = 15;
			}
		
			
			String title = bean.getTitle();
			
			String category_name = dao.getCategoryName(bean.getCategory_code());
			String publish_date = bean.getPublish_date();
			
			int count_book = dao.getBookIdByIsbn(bean.getIsbn()).size();

			int count_rented_book = dao.getRentedBookCountByIsbn(bean.getIsbn());
			System.out.println(count_rented_book);
			
			String rentAvailable = (count_book - count_rented_book) + "/" + count_book;
			System.out.println(rentAvailable);
			
			// canRentDay
			
			
		}	
			
			
			 
		}
		
	}

