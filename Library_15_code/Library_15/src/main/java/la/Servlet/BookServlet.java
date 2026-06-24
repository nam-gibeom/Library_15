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
import la.Service.MemberService;


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
				if (type.equals("book_id")) { // 資料IDで検索する際に、数字じゃなく文字列であればエラー発生
					try {
						Integer.parseInt(value);
					} catch (NumberFormatException e) {
						request.setAttribute("error", "資料IDは数字で入力してください");
						gotoPage(request, response, "/bookSearch.jsp");
					}
					return;
				}
				
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
				
				try { // 出版日が数字じゃない場合
					Integer.parseInt(publish_date);
				} catch (NumberFormatException e) {
					request.setAttribute("isbn", isbn);
					request.setAttribute("exist_false", true);
					request.setAttribute("error", "出版日は数字で入力してください");
					gotoPage(request, response, "/bookAdd.jsp");
					return;
				}
				
				if (publish_date.length() != 8) {
					request.setAttribute("isbn", isbn);
					request.setAttribute("exist_false", true);
					request.setAttribute("error", "出版日は8桁 (例：20260624)で入力してください");
					gotoPage(request, response, "/bookAdd.jsp");
				}
				
				service.addCatalog(isbn, title, category_name, author, publisher, publish_date);
				service.addStock(isbn);
				gotoPage(request, response, "/bookAdd.jsp");
			
			} else if (action.equals("rentsearch")) { // 貸出・返却を探す
				try {
					int member_id = Integer.parseInt(request.getParameter("member_id"));
					
					MemberService member_service = new MemberService();
					if (member_service.isMemberExist(member_id)) { // 会員が存在する場合
						List<RentInfoBean> Result_list = service.showCurrentrentList(member_id);
						request.setAttribute("member_id", member_id);
						request.setAttribute("rent_list", Result_list);
						request.setAttribute("show", true);
						gotoPage(request, response, "/bookRr.jsp");
					} else { // 会員が存在しない場合
						request.setAttribute("error", "会員を見つけられません。もう一度確認してください。");
						gotoPage(request, response, "/bookRr.jsp");
					}
					
	
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
					} catch (NumberFormatException e) { // 貸出に文字列を記入したらエラー発生
						e.printStackTrace();
						List<RentInfoBean> Result_list = service.showCurrentrentList(member_id);
						request.setAttribute("member_id", member_id);
						request.setAttribute("rent_list", Result_list);
						request.setAttribute("show", true);
						request.setAttribute("error", "資料IDは数字で入力してください");
						gotoPage(request, response, "/bookRr.jsp");
					}

				}
				// 資料が存在かどうかを確認
				List<Integer> current_bookid_list = service.getExistBookId();
				List<Integer> cant_Borrow_List = new ArrayList<Integer>();
				
				for (int bookid : book_id_list) {
					if (current_bookid_list.contains(bookid)) { // 存在する場合
						continue;
					} else {
						cant_Borrow_List.add(bookid);
					}
				}
				if (!cant_Borrow_List.isEmpty()) { // 存在しない資料を見つけた時、エラーreturn
					List<RentInfoBean> Result_list = service.showCurrentrentList(member_id);
					request.setAttribute("member_id", member_id);
					request.setAttribute("rent_list", Result_list);
					request.setAttribute("show", true);
					request.setAttribute("already_exists", cant_Borrow_List);
					gotoPage(request, response, "/bookRr.jsp");
				} 
				
				List<RentInfoBean> already_rented_list = service.checkRentedBook(book_id_list);
				if (already_rented_list.isEmpty()) { // 誰も借りてない状態だと、確認画面へ進
					List<RentInfoBean> result_list =  service.rentBooksById(member_id, book_id_list);
					request.setAttribute("rent_result", result_list);
					gotoPage(request, response, "/bookConfirm.jsp");
					
				} else { // すでに借りている資料なら遷移せず、できないことを表示
					List<RentInfoBean> Result_list = service.showCurrentrentList(member_id);
					request.setAttribute("member_id", member_id);
					request.setAttribute("rent_list", Result_list);
					request.setAttribute("show", true);
					request.setAttribute("error", "すでに資料を借りている会員が存在します。");
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
				if (remarks == null || remarks.equals("")) { // 理由を選択しなかった場合、エラー処理
					DiscardInfoBean result = service.searchDiscard(book_id);
					request.setAttribute("result", result);
					String current_date = service.getCurrentDate(); // 20260622
					request.setAttribute("current_date", current_date);
					request.setAttribute("show", true);
					request.setAttribute("error", "廃棄理由を選択してください。");
					gotoPage(request, response, "/bookDiscard.jsp");
					return;
				} 
				
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
