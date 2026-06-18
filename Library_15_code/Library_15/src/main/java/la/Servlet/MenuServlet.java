package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.service.MenuService;
import la.service.ServiceException;


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
                String name = service.Login(id,pass);
                
                if(name.equals(null)) {
                	request.setAttribute("message", "ログインできませんでした。");
                	gotoPage(request, response, "/errInternal.jsp");
                }else {
                	request.setAttribute("names", name);
                	gotoPage(request, response, "/menu.jsp");
                	
                }
                
                
			}else if (action.equals("logout")) {
				
				gotoPage(request, response, "/login.jsp");
				
			}else if (action.equals("regist")) {
				
				gotoPage(request, response, "/memberRegist.jsp");
				
			}else if (action.equals("update")) {
				
				gotoPage(request, response, "/memberUpdate.jsp");
				
			}else if (action.equals("cancel")) {
				
				gotoPage(request, response, "/memberCancel.jsp");
				
			}
                
                
        } catch (ServiceException e) {
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
