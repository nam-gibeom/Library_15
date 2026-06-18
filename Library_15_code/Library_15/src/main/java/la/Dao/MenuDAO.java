package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuDAO {
	
    private String url = "jdbc:postgresql:library_15";
    private String user = "postgres";
    private String pass = "himitu";

    public MenuDAO() throws DAOException {
        try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
        }
    }
    
    public String getName(String id) throws DAOException {
        // SQL文の作成
        String sql = "SELECT staff_name FROM adminlist WHERE staff_id = ?";
		
        
        try (// データベースへの接続
             Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);) {
			// 商品番号の設定
			st.setString(1, id);
			
			try (// SQLの実行
			     ResultSet rs = st.executeQuery();) {
			    // 結果の取得および表示
			    if (rs.next()) {
			        String name = rs.getString("staff_name");
			        
			        return name; // 主キーに該当するレコードを返す
                } else {
			        return null; // 主キーに該当するレコードなし
                }
            } catch (SQLException e) {
			    e.printStackTrace();
			    throw new DAOException("レコードの取得に失敗しました。");
			}
        } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
        }
    }
    
    public String getPass(String id) throws DAOException {
        // SQL文の作成
        String sql = "SELECT staff_password FROM adminlist WHERE Staff_id = ?";
        
		
        try (// データベースへの接続
             Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);) {
			// 商品番号の設定
			st.setString(1, id);
			
			try (// SQLの実行
			     ResultSet rs = st.executeQuery();) {
			    // 結果の取得および表示
			    if (rs.next()) {
			        String pass = rs.getString("staff_password");
			        
			        return pass; // 主キーに該当するレコードを返す
                } else {
			        return null; // 主キーに該当するレコードなし
                }
            } catch (SQLException e) {
			    e.printStackTrace();
			    throw new DAOException("レコードの取得に失敗しました。");
			}
        } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
        }
    }
    
    
    
    
    
    
    
    
    

}
