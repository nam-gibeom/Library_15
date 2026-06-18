package la.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.Bean.OverdueBean;
import la.Dao.DAOException;

public class BookDAOTEST {

	public static void main(String[] args) throws SQLException, DAOException {
		String url = "jdbc:postgresql:library_15";
		String user = "postgres";
		String pass = "himitu";
	
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 延滞確認
		String sql = "select * from rentlist where remarks = '延滞'";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery()) {
			
			List<OverdueBean> list =new ArrayList<OverdueBean>();
			while (rs.next()) {
				int member_id = rs.getInt("member_id");
				int book_id = rs.getInt("book_id");
				String return_deadline = rs.getString("return_deadline");
				
				System.out.println(member_id + book_id + return_deadline);
				OverdueBean bean = new OverdueBean(member_id, book_id, return_deadline);
				list.add(bean);
				
			}
	}
	
	
	}
}
