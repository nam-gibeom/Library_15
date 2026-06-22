package la.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.Bean.OverdueBean;
import la.Dao.DAOException;
import la.Service.BookService;
import la.Service.MenuService;
import la.Service.ServiceException;


/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String action = request.getParameter("action");
			
			if(action.equals("login")) {
			
				
				String id = request.getParameter("staffid");
				String pass = request.getParameter("password");
            
                MenuService service = new MenuService();
                BookService service1 = new BookService();
                String name = service.Login(id,pass);
                
                if(!name.equals("")) {
                	request.setAttribute("names", name);
                	List<OverdueBean> result_list = service1.searchOverdueBooks(request);
    	        	request.setAttribute("overdues", result_list);
                	gotoPage(request, response, "/top.jsp");
                	
                }else {
                	
                	gotoPage(request, response, "/errInternal.jsp");
                	
                }
                
                
			}else if (action.equals("logout")) {
				
				gotoPage(request, response, "/login.jsp");
				
			}else if (action.equals("regist")) {
				
				gotoPage(request, response, "/memberRegist.jsp");
				
			}else if (action.equals("update")) {
				
				gotoPage(request, response, "/memberUpdate.jsp");
				
			}else if (action.equals("cancel")) {
				
				gotoPage(request, response, "/memberCancel.jsp");
				
			}else if (action.equals("back")) {
				
				gotoPage(request, response, "/login.jsp");
				
			}else if (action.equals("bookSearch")) {
				
				gotoPage(request, response, "/bookSearch.jsp");
			
			}else if (action.equals("rentSearch")) {
				
				gotoPage(request, response, "/bookRr.jsp");
			
			}else if (action.equals("delay")) {
				BookService service1 = new BookService();
				List<OverdueBean> result_list = service1.searchOverdueBooks(request);
	        	request.setAttribute("overdues", result_list);
				gotoPage(request, response, "/top.jsp");
			
			}else if (action.equals("addSearch")) {
				
				gotoPage(request, response, "/bookAdd.jsp");
			
			}else if (action.equals("discardSearch")) {
				
				gotoPage(request, response, "/bookDiscard.jsp");
			
			}
                
                
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            request.setAttribute("message", "内部エラーが発生しました。");
        }
	}

	
	private void gotoPage(HttpServletRequest request,
            HttpServletResponse response, String page) throws ServletException,
            IOException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
