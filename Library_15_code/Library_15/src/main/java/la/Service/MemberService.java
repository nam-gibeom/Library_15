package la.Service;

import la.Bean.MemberBean;
import la.Dao.DAOException;
import la.Dao.MemberDAO;


public class MemberService {
	
	
	public MemberBean addMemberService(String member_name, String member_address, 
			String member_tel, String member_mail, String member_birth){
	
		try {
			MemberDAO dao = new MemberDAO();
			dao.addMember(member_name, member_address, member_tel, member_mail, member_birth);
			MemberBean bean = dao.getIdName();
			
			return bean;
		
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		return null;
		}
		
	

	}
	public MemberBean SearchAndMove(int member_id) throws DAOException{
		try {
			MemberDAO dao = new MemberDAO();
			
			MemberBean bean = dao.findAll(member_id);
			
			return bean;
			
		} catch (DAOException e) {
			e.printStackTrace();
			throw new DAOException("error");
		}
	
	}
	
	public void updateMemberService(int member_id, String member_name, String member_address, String member_tel,
			String member_mail, String member_birth) {
		try {
			MemberDAO dao = new MemberDAO();
			dao.updateAll(member_id, member_name, member_address, member_tel, member_mail, member_birth);
			
		
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
	}
	}
	
	public void cancelMemberService(int member_id) {
		try {
			MemberDAO dao = new MemberDAO();
			dao.updateCancelDate(member_id);
			
		
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
	}
	}
	
	public boolean isMemberExist(int member_id) throws DAOException {
		MemberDAO dao = new MemberDAO();
		MemberBean bean = dao.findAll(member_id);
		if (bean == null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	

}


	

