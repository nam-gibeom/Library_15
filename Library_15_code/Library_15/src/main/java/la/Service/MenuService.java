package la.service;

import la.dao.DAOException;
import la.dao.MenuDAO;



public class MenuService {

	
	
	public String Login(String id, String pass) throws ServiceException {
        
		try {
			
		
		MenuDAO dao = new MenuDAO();
		
		String password = dao.getPass(id);
		
		if(pass.equals(password)) {
			
			String name = dao.getName(id);
			return name;
			
			
			
		}else {
			System.out.println("パスワードが一致しません");
			return "";
			
		}
		
		} catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
		
	
	
	
}
