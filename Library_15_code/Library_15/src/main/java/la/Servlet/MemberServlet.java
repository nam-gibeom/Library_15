package la.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.Bean.MemberBean;
import la.Dao.DAOException;
import la.Service.MemberService;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		if(action.equals("searchupdate")) {
		int member_id = Integer.parseInt(request.getParameter("memberid"));
		MemberService service = new MemberService();
		MemberBean bean = service.SearchAndMove(member_id);
		request.setAttribute("info", bean);
		gotoPage(request, response,"/memberUpdate.jsp" );
			
		}else if(action.equals("searchcancel")) {
			int member_id = Integer.parseInt(request.getParameter("memberid"));
			
			
			MemberService service = new MemberService();
			MemberBean bean = service.SearchAndMove(member_id);
			request.setAttribute("info", bean);
			gotoPage(request, response,"/memberCancel.jsp" );
			
		}else if(action.equals("regist")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String mail = request.getParameter("mail");
			
			String birthy = request.getParameter("birthy");
			String birthm = request.getParameter("birthm");
			String birthd = request.getParameter("birthd");
			
			String birth = birthy +"-"+ birthm +"-"+ birthd;
			
			MemberService service = new MemberService();
			MemberBean bean = service.addMemberService(name, address, tel, mail, birth);
			request.setAttribute("info", bean);
			gotoPage(request, response, "/registResult.jsp");
			
		}else if(action.equals("update")) {
			int id =Integer.parseInt(request.getParameter("memberid"));
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String mail = request.getParameter("mail");
			
			String birthy = request.getParameter("birthy");
			String birthm = request.getParameter("birthm");
			String birthd = request.getParameter("birthd");
			
			String birth = birthy +"-"+ birthm +"-"+ birthd;
			
			
			MemberService service = new MemberService();
			service.updateMemberService(id, name, address, tel, mail, birth);
			gotoPage(request, response, "/memberUpdate.jsp");
			
		}else if(action.equals("cancel")) {
			int id =Integer.parseInt(request.getParameter("id"));
			MemberService service = new MemberService();
			service.cancelMemberService(id);
			
			gotoPage(request, response, "/memberCancel.jsp");
			
		}else if(action.equals("confirm")) {
	
			gotoPage(request, response, "/memberRegist.jsp");
		}
		
		
		}catch (ServletException | DAOException e) {
            e.printStackTrace();
            request.setAttribute("message", "内部エラーが発生しました。");
            gotoPage(request, response, "/memberError.jsp");
        }
	}


	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
