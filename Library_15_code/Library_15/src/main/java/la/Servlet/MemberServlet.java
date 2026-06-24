package la.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.Bean.MemberBean;
import la.Bean.RentInfoBean;
import la.Dao.DAOException;
import la.Service.BookService;
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
			try {
				int member_id = Integer.parseInt(request.getParameter("memberid"));
				MemberService service = new MemberService();
				MemberBean bean = service.SearchAndMove(member_id);
				if (bean != null) {
					request.setAttribute("info", bean);
					request.setAttribute("show", true);
					gotoPage(request, response,"/memberUpdate.jsp" );
				} else {
					request.setAttribute("error", "存在しない会員IDです。もう一度確認してください");
					gotoPage(request, response,"/memberUpdate.jsp" );
				}
				
			} catch (NumberFormatException e) {
				request.setAttribute("error", "会員IDは数字で入力してください。");
				gotoPage(request, response,"/memberUpdate.jsp" );
			}
		
			
		}else if(action.equals("searchcancel")) {
			try {
				int member_id = Integer.parseInt(request.getParameter("memberid"));
				
				MemberService service = new MemberService();
				BookService service_book = new BookService();
			
				List<RentInfoBean> book_bean = service_book.showCurrentrentList(member_id);
				MemberBean bean = service.SearchAndMove(member_id);
				if (bean != null) {
					request.setAttribute("rent_list", book_bean);
					request.setAttribute("show", true);
					request.setAttribute("info", bean);
					gotoPage(request, response,"/memberCancel.jsp" );
				} else {
					request.setAttribute("error", "存在しない会員IDです。もう一度確認してください");
					gotoPage(request, response,"/memberCancel.jsp" );
				}

			} catch (NumberFormatException e) {
				request.setAttribute("error", "会員IDは数字で入力してください。");
				gotoPage(request, response,"/memberCancel.jsp" );
			}
		
			
		}else if(action.equals("regist")) {
			
			String name = request.getParameter("name");
			if (name == null || name.equals("")) { // 名前が空欄の場合
				request.setAttribute("error", "名前を入力してください。");
				gotoPage(request, response, "/memberRegist.jsp");
				return;
			} 
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String mail = request.getParameter("mail");
			int birthy = 0;
			int birthm = 0;
			int birthd = 0;
			
			try { // 数字が文字列かを確認
				birthy = Integer.parseInt(request.getParameter("birthy"));
				birthm = Integer.parseInt(request.getParameter("birthm"));
				birthd = Integer.parseInt(request.getParameter("birthd"));
			} catch (NumberFormatException e) {
				request.setAttribute("error", "生年月日は数字で入力してください。");
				gotoPage(request, response, "/memberRegist.jsp");
				return;
			}
			
			String birth = "";
			if ((String.valueOf(birthy).length() == 4) && (birthm <= 12 && birthm >= 1) && (birthd >= 1 && birthd <= 31)) { // 生年月日は範囲内の数字で記入されてもらったかを確認
				birth = birthy +"-"+ birthm +"-"+ birthd;
				MemberService service = new MemberService();
				MemberBean bean = service.addMemberService(name, address, tel, mail, birth);
				request.setAttribute("info", bean);
				gotoPage(request, response, "/registResult.jsp");
			} else {
				request.setAttribute("name", name);
				request.setAttribute("address", address);
				request.setAttribute("tel", tel);
				request.setAttribute("mail", mail);
				request.setAttribute("error", "正しい生年月日を入力してください。");
				gotoPage(request, response, "/memberRegist.jsp");
			}

			
			
		
			


			
			
		}else if(action.equals("update")) {
			MemberService service = new MemberService();
			int member_id =Integer.parseInt(request.getParameter("memberid"));
			MemberBean bean = service.SearchAndMove(member_id);
			
			String name = request.getParameter("name");
			if (name == null || name.equals("")) { // 名前が空欄の場合
				request.setAttribute("error", "更新に失敗しました。名前を入力してください。");
				request.setAttribute("info", bean);
				request.setAttribute("show", true);
				gotoPage(request, response, "/memberUpdate.jsp");
				return;
			} 
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String mail = request.getParameter("mail");
			int birthy = 0;
			int birthm = 0;
			int birthd = 0;
			
			try { // 数字が文字列かを確認
				birthy = Integer.parseInt(request.getParameter("birthy"));
				birthm = Integer.parseInt(request.getParameter("birthm"));
				birthd = Integer.parseInt(request.getParameter("birthd"));
			} catch (NumberFormatException e) {
				request.setAttribute("error", "更新に失敗しました。生年月日は数字で入力してください。");
				request.setAttribute("info", bean);
				request.setAttribute("show", true);
				gotoPage(request, response, "/memberUpdate.jsp");
				return;
			}
			
			String birth = "";
			if ((String.valueOf(birthy).length() == 4) && (birthm <= 12 && birthm >= 1) && (birthd >= 1 && birthd <= 31)) { // 生年月日は範囲内の数字で記入されてもらったかを確認
				birth = birthy +"-"+ birthm +"-"+ birthd;
				service.updateMemberService(member_id, name, address, tel, mail, birth);
				gotoPage(request, response, "/memberUpdate.jsp");
			} else {
				request.setAttribute("error", "更新に失敗しました。正しい生年月日を入力してください。");
				request.setAttribute("info", bean);
				request.setAttribute("show", true);
				gotoPage(request, response, "/memberUpdate.jsp");
			}
//			String address = request.getParameter("address");
//			String tel = request.getParameter("tel");
//			String mail = request.getParameter("mail");
//			
//			String birthy = request.getParameter("birthy");
//			String birthm = request.getParameter("birthm");
//			String birthd = request.getParameter("birthd");
//			
//			String birth = birthy +"-"+ birthm +"-"+ birthd;
//			
//			
//			MemberService service = new MemberService();
//			service.updateMemberService(id, name, address, tel, mail, birth);
//			gotoPage(request, response, "/memberUpdate.jsp");
			
		}else if(action.equals("cancel")) {
			int id =Integer.parseInt(request.getParameter("id"));
			MemberService service = new MemberService();
			service.cancelMemberService(id);
			
			gotoPage(request, response, "/memberCancel.jsp");
			
		}else if(action.equals("confirm")) {
	
			gotoPage(request, response, "/memberRegist.jsp");
		
		} else if (action.equals("return")) {

			int book_id = Integer.parseInt(request.getParameter("book_id"));
			int member_id = Integer.parseInt(request.getParameter("member_id"));
			
			BookService book_service = new BookService();
			MemberService service = new MemberService();
			
			book_service.returnBook(member_id, book_id);
			List<RentInfoBean> book_bean = book_service.showCurrentrentList(member_id);
			MemberBean bean = service.SearchAndMove(member_id);
			
			request.setAttribute("rent_list", book_bean);
			request.setAttribute("show", true);
			request.setAttribute("info", bean);
			gotoPage(request, response,"/memberCancel.jsp" );
			
			
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
