package la.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.Bean.DiscardInfoBean;
import la.Bean.OverdueBean;
import la.Bean.RentInfoBean;
import la.Bean.SearchBean;
import la.Bean.catalogListBean;
import la.Dao.DAOException;
import la.Service.BookService;


@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public BookServlet()  {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		try {
	        BookService service = new BookService();
	        if (action==null || action.equals("") || action.equals("overdue")){ // 延滞
	        	List<OverdueBean> result_list = service.searchOverdueBooks(request);
	        	request.setAttribute("overdues", result_list);
				gotoPage(request, response, "/top.jsp");
				
	        } else if (action.equals("booksearch")) {  // 検索
				String type = request.getParameter("type");
				String value = request.getParameter("value");
				List<SearchBean> result = service.searchBooks(type, value);
				if (result.isEmpty()) {
					request.setAttribute("error", "資料が存在しません");
					gotoPage(request, response, "/bookSearch.jsp");
				} else {
					request.setAttribute("result", result);
					request.setAttribute("show", true);
					gotoPage(request, response, "/bookSearch.jsp");
				}

				
				
			} else if (action.equals("addsearch")) { // 資料登録
				String isbn = request.getParameter("isbn");
				if (isbn.equals("")) {
					request.setAttribute("error", "ISBN番号を入力してください");
					gotoPage(request, response, "/bookAdd.jsp");
				}
				
				
				if (service.isIsbnExist(isbn)) {
					catalogListBean result_bean = service.getStockInfoByIsbn(isbn);
					request.setAttribute("exist", result_bean);
					request.setAttribute("exist_true", true);
					gotoPage(request, response, "/bookAdd.jsp");
				} else {
					request.setAttribute("isbn", isbn);
					request.setAttribute("exist_false", true);
					gotoPage(request, response, "/bookAdd.jsp");
				}
				
			} else if (action.equals("add1")) { // 既存の目録にあったものを在庫に登録
				String isbn = request.getParameter("isbn");
				System.out.println(isbn);
				service.addStock(isbn);
				gotoPage(request, response, "/bookAdd.jsp");
				
			} else if (action.equals("add2")) { // 既存の目録にないものを登録
				String isbn = request.getParameter("isbn");
				String title = request.getParameter("title");
				String category_name = request.getParameter("category_name");
				String author = request.getParameter("author");
				String publisher = request.getParameter("publisher");
				String publish_date = request.getParameter("publish_date");
				System.out.println(isbn);
				System.out.println(title);
				service.addCatalog(isbn, title, category_name, author, publisher, publish_date);
				service.addStock(isbn);
				gotoPage(request, response, "/bookAdd.jsp");
			
			} else if (action.equals("rentsearch")) { // 貸出・返却を探す
				try {
					int member_id = Integer.parseInt(request.getParameter("member_id"));
					List<RentInfoBean> Result_list = service.showCurrentrentList(member_id);
					request.setAttribute("member_id", member_id);
					request.setAttribute("rent_list", Result_list);
					request.setAttribute("show", true);
					gotoPage(request, response, "/bookRr.jsp");
				} catch (NumberFormatException e) {
					request.setAttribute("error", "会員IDは数字で入力してください。");
					gotoPage(request, response, "/bookRr.jsp");
				}

				
			} else if (action.equals("return")) { // 返却ボタン
				int book_id = Integer.parseInt(request.getParameter("book_id"));
				int member_id = Integer.parseInt(request.getParameter("member_id"));
				service.returnBook(member_id, book_id);
				
				List<RentInfoBean> Result_list = service.showCurrentrentList(member_id);
				request.setAttribute("member_id", member_id);
				request.setAttribute("rent_list", Result_list);
				request.setAttribute("show", true);
				gotoPage(request, response, "/bookRr.jsp");
				
			} else if (action.equals("rent")) { // 貸出ボタン
				List<Integer> book_id_list = new ArrayList<Integer>();
				int member_id = Integer.parseInt(request.getParameter("member_id"));
				for (int i = 1; i < 6; i++) {
					try {
						String book_id = request.getParameter("book_id" + i);
						if (book_id == null || book_id.equals("")) {
							continue;
						} else {
							int num = Integer.parseInt(book_id);
							book_id_list.add(num);
						}
					} catch (NumberFormatException e) {
						e.printStackTrace();
						List<RentInfoBean> Result_list = service.showCurrentrentList(member_id);
						request.setAttribute("member_id", member_id);
						request.setAttribute("rent_list", Result_list);
						request.setAttribute("show", true);
						request.setAttribute("error1", "資料IDは数字で入力してください");
						gotoPage(request, response, "/bookRr.jsp");
					}

					}
				List<RentInfoBean> already_rented_list = service.checkRentedBook(book_id_list);
				if (already_rented_list.isEmpty()) {
					List<RentInfoBean> result_list =  service.rentBooksById(member_id, book_id_list);
					request.setAttribute("rent_result", result_list);
					gotoPage(request, response, "/bookConfirm.jsp");
				} else {
					List<RentInfoBean> Result_list = service.showCurrentrentList(member_id);
					request.setAttribute("member_id", member_id);
					request.setAttribute("rent_list", Result_list);
					request.setAttribute("show", true);
					request.setAttribute("rented_list", already_rented_list);
					gotoPage(request, response, "/bookRr.jsp");
				}
				

					


			} else if (action.equals("rentconfirm")) {
				gotoPage(request, response, "/bookRr.jsp");
				
			} else if (action.equals("searchDiscard")) {
				try {
					int book_id = Integer.parseInt(request.getParameter("book_id"));
					
					DiscardInfoBean result = service.searchDiscard(book_id);
					
					if (result != null) {
						request.setAttribute("result", result);
						String current_date = service.getCurrentDate(); // 20260622
						request.setAttribute("current_date", current_date);
						request.setAttribute("show", true);
						gotoPage(request, response, "/bookDiscard.jsp");
					} else {
						request.setAttribute("error", "資料が存在しません。もう一度確認してください");
						gotoPage(request, response, "/bookDiscard.jsp");
					}

				} catch (NumberFormatException e) {
					request.setAttribute("error", "会員IDは数字で入力してください。");
					gotoPage(request, response, "/bookDiscard.jsp");
				}
				
				
			} else if(action.equals("discard")) {
				
				int book_id = Integer.parseInt(request.getParameter("book_id"));
				String discard_date = request.getParameter("discard_date");
				String remarks = request.getParameter("remarks");
				String other = request.getParameter("other");
				if(remarks.equals("others")) {
					service.discardBook(book_id,discard_date,other);
				}else {
					service.discardBook(book_id,discard_date,remarks);
				}
				gotoPage(request, response, "/bookDiscard.jsp");
			}
				
				
			
			

		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void gotoPage(HttpServletRequest request,
            HttpServletResponse response, String page) throws ServletException,
            IOException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

}
