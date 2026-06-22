package la.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.Bean.DiscardInfoBean;
import la.Dao.DAOException;
import la.Service.BookService;

/**
 * Servlet implementation class BookServlet1
 */
@WebServlet("/BookServlet1")
public class BookServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");
		try {
	        BookService service = new BookService();
			if (action.equals("searchDiscard")) {
				
				int book_id = Integer.parseInt(request.getParameter("book_id"));
				
				DiscardInfoBean result = service.searchDiscard(book_id);
				request.setAttribute("result", result);
				String current_date = service.getCurrentDate(); // 20260622
				request.setAttribute("current_date", current_date);
				gotoPage(request, response, "/bookDiscard.jsp");
			}else if(action.equals("discard")) {
				
				int book_id = Integer.parseInt(request.getParameter("book_id"));
				String discard_date = request.getParameter("discard_date");
				String remarks = request.getParameter("remarks");
				
				service.discardBook(book_id,discard_date,remarks);
				gotoPage(request, response, "/bookDiscard.jsp");
			}
			

		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
