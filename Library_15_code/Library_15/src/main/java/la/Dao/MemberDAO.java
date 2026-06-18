package la.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.Bean.MemberBean;

public class MemberDAO {
	private String url = "jdbc:postgresql:library_15";
    private String user = "postgres";
    private String pass = "himitu";

    public MemberDAO() throws DAOException {
        try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
        }
    }
    public MemberBean getIdName() throws DAOException {
        // SQL文の作成
        String sql = "select member_id, member_name from memberlist order by member_id desc limit 1";
		
        try (// データベースへの接続
             Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);
			 // SQLの実行
			 ResultSet rs = st.executeQuery();) {
            // 結果の取得および表示
        	MemberBean bean = null;;
			while (rs.next()) {
			    int id = rs.getInt("id");
			    String name = rs.getString("name");
			    bean = new MemberBean(id, name);
			   
			    }
			return bean;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
			}
        }

    public MemberBean findAll(int member_id) throws DAOException {
        // SQL文の作成
        String sql = "Select * from memberlist where member_id = ?";
		
        
        try (// データベースへの接続
             Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);
			 // SQLの実行
			 ) {
        	st.setInt(1, member_id);
        	ResultSet rs = st.executeQuery();
            // 結果の取得および表示
			MemberBean bean = null;
			while (rs.next()) {
			    int id = rs.getInt("member_id");
			    String name = rs.getString("member_name");
			    String address = rs.getString("member_address");
			    String tel = rs.getString("member_tel");
			    String mail = rs.getString("member_mail");
			    String[] birth = rs.getString("member_birth").split("-");
			    
			    String birth_year = birth[0];
			    String birth_month = birth[1];
			    String birth_day = birth[2];
			    
			    String registdate = rs.getString("member_registdate");
			    String canceldate = rs.getString("member_canceldate");
			    
			    bean = new MemberBean(id, name,address,tel,mail,birth_year, birth_month, birth_day,registdate,canceldate);
			 
			}
			return bean;
			
			}catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}
    }

    public void addMember(String member_name, String member_address, String member_tel, String member_mail, String member_birth, String current_date) 
    		throws DAOException {
		// SQL文の作成
		String sql = "insert into memberlist(member_name, member_address, member_tel, member_mail, member_birth, member_registdate) values(?, ?, ?, ?, ?, ?)";
		
		try (// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);) {
			// 商品名と値段の指定
			st.setString(1, member_name);
			st.setString(2, member_address);
			st.setString(3, member_tel);
			st.setString(4, member_mail);
			st.setString(5, member_birth);
			st.setString(6, current_date);
			// SQLの実行
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} 
	
	}
    
    public void updateCancelDate(int member_id, String current_date) throws DAOException {
		// SQL文の作成
		String sql = "update memberlist set member_canceldate = ? where member_id = ?";
		
		try (// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);) {
			// 商品名と値段の指定
			st.setString(1, current_date);
			st.setInt(2, member_id);
			// SQLの実行
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} 
	
	}
    public void updateAll(int member_id, String member_name, String member_address, 
    		String member_tel, String member_mail, String member_birth) throws DAOException{
String sql = "update memberlist set member_name = ?, member_address = ?, member_tel = ?, member_mail = ?, member_birth = ? where member_id = ?";
		
		try (// データベースへの接続
			 Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);) {
			// 商品名と値段の指定
			st.setString(1, member_name);
			st.setString(2, member_address);
			st.setString(3, member_tel);
			st.setString(4, member_mail);
			st.setDate(5, Date.valueOf(member_birth));
			st.setInt(6, member_id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} 
    	
    	
    }
    
    
}

    

