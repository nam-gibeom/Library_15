package la.test;

import la.Dao.DAOException;

public class BookServiceTest {

	public static void main(String[] args) throws DAOException {
		int[] b = {1,2,3,4,5};
		
		
		try {
		 for (int i = 0; i < 7; i++) {
			int j = b[i];
			System.out.println(j);
		 	}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}