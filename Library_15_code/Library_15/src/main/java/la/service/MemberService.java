package la.service;

import java.util.List;

import la.bean.MemberBean;
import la.dao.DAOException;
import la.dao.MemberDAO;


public class MemberService {
	
	public class SearchMove {
	    public  MemberBean bean;
	    public String URL;

	    public SearchMove(MemberBean bean, String url) {
	        this.bean = bean;
	        this.URL = url;
	    }
	}


	public List<MemberBean> addMemberService(String member_name, String member_address, 
			String member_tel, String member_mail, String member_birth){
		
		String currentdate = "current_date";
		
		try {
			MemberDAO dao = new MemberDAO();
			dao.addMember(member_name, member_address, member_tel, member_mail, member_birth, currentdate);
			List<MemberBean> list = dao.getIdName();
			
			return list;
		
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		return null;
		}
		
	

	}
	public List<MemberBean> SearchAndMove(int member_id, String action){
		
		
		if(action.equals("cancel")) {
		try {
			MemberDAO dao = new MemberDAO();
			
			List<MemberBean> list = dao.findAll(member_id);
			SearchMove sm = new SearchMove((MemberBean) list,"cancel.jsp");
			
			
			
		
		
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		return null;
		}
		}else if(action.equals("update")) {
			try {
				MemberDAO dao = new MemberDAO();
				List<MemberBean> list = dao.findAll(member_id);
				
				
			
			
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			return null;
		}
		
	}
	
	}
	
	
	

	}


	

