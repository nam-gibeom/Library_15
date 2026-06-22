package la.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.Bean.DiscardInfoBean;
import la.Bean.OverdueBean;
import la.Bean.RentBean;
import la.Bean.RentInfoBean;
import la.Bean.catalogListBean;

public class BookDAO {
	String url = "jdbc:postgresql:library_15";
	String user = "postgres";
	String pass = "himitu";

	public BookDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("ドライバ起動に失敗しました。");
		}
	}

//	ISBNまたは資料名で資料目録情報を獲得
	public List<catalogListBean> getCatalogListInfo(String type, String value) throws DAOException {
		String sql;

		if (type.equals("isbn")) {
			sql = "select * from cataloglist where isbn = ?";
		} else {
			sql = "select * from cataloglist where title like ?";
		}

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			List<catalogListBean> list = new ArrayList<catalogListBean>();
			if (type.equals("isbn")) {
				st.setString(1, value);
			} else {
				st.setString(1, "%" + value + "%");
			}
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				int category_code = rs.getInt("category_code");
				String category_name = getCategoryName(category_code);
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String publish_date = rs.getString("publish_date");

				catalogListBean bean = new catalogListBean(isbn, title, category_name, author, publisher, publish_date);
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			throw new DAOException("レコードの取得に失敗しました");
		}
	}

//	本の数をISBNで確認するためのメソッド
	public List<Integer> getBookIdByIsbn(String isbn) throws DAOException{
		String sql = "select book_id from stocklist where isbn = ?";
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			List<Integer> list = new ArrayList<Integer>();
			st.setString(1, isbn);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				list.add(book_id);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} 
	
	}
	
	// 本の数を資料名で確認するためのメソッド
	public List<Integer> getBookIdByTitle(String title) throws DAOException {
		String sql = "select s.book_id from stocklist s join cataloglist c on s.isbn = c.isbn where c.title like ?";
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			List<Integer> list = new ArrayList<Integer>();
			st.setString(1, "%" + title + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				list.add(book_id);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}
		
	}
	
	// 貸出中の資料情報（ID, Title）を獲得
	public List<RentInfoBean> getRentedBookIdTitlebyMember(int id) throws DAOException {
		String sql = "select r.book_id, c.title from rentlist r join stocklist s on r.book_id = s.book_id join cataloglist c on s.isbn = c.isbn where r.return_date is null and r.member_id = ?";
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			List<RentInfoBean> list = new ArrayList<RentInfoBean>();
			
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				
				RentInfoBean bean = new RentInfoBean(book_id, title);
				list.add(bean);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} 
	}
	
	
	public void updateRemarksDelay() throws DAOException {
		String sql = "update rentlist set remarks = '延滞' where current_date - return_deadline > 0 and return_date is null";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} 
	}
	
	public List<OverdueBean> getRemarksAsOverdue() throws DAOException {
		String sql = "select * from rentlist where remarks = '延滞'";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery()) {
			
			List<OverdueBean> list =new ArrayList<OverdueBean>();
			while (rs.next()) {
				int member_id = rs.getInt("member_id");
				int book_id = rs.getInt("book_id");
				String return_deadline = rs.getString("return_deadline");
				OverdueBean bean = new OverdueBean(member_id, book_id, return_deadline);
				list.add(bean);
				
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} 
	}
	
	public catalogListBean getInfoByBookId(int book_id) throws DAOException {
		String sql = "select s.isbn, c.title, c.category_code, c.author, c.publisher, c.publish_date from stocklist s join cataloglist c on s.isbn = c.isbn where s.book_id = ?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
			) {
			st.setInt(1, book_id);	
			ResultSet rs = st.executeQuery();
			
			catalogListBean bean = new catalogListBean();
			
			while (rs.next()) {
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				int category_code = rs.getInt("category_code");
				String category_name = getCategoryName(category_code);
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String publish_date = rs.getString("publish_date");
				
				bean = new catalogListBean(book_id, isbn, title, category_name, author, publisher, publish_date);
			}
			return bean;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} 
	}
	
	public catalogListBean getInfoByIsbn(String isbn) throws DAOException {
		String sql = "select s.book_id, s.isbn, c.title, c.category_code, c.author, c.publisher, c.publish_date from stocklist s join cataloglist c on s.isbn = c.isbn where s.isbn = ? limit 1";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
			) {
			st.setString(1, isbn);	
			ResultSet rs = st.executeQuery();
			
			catalogListBean bean = new catalogListBean();
			
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				int category_code = rs.getInt("category_code");
				String category_name = getCategoryName(category_code);
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String publish_date = rs.getString("publish_date");
				
				bean = new catalogListBean(book_id, isbn, title, category_name, author, publisher, publish_date);
				
			}
			return bean;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		} 
	}
	 //在庫台帳に追加するメソッド
    public void addStockList(String isbn, String arrival_date) throws DAOException {
        // SQL文の作成
        String sql = "INSERT INTO stocklist(isbn,arrival_date) VALUES(?, ?)";
		
        try (// データベースへの接続
             Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);){
			 // SQLの実行
        		st.setString(1, isbn);
    			st.setDate(2, Date.valueOf(arrival_date));
    			
    			st.executeUpdate();

        } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
        } 
    }
    
    //資料目録の追加するメソッド
    public void addCatalogList(String isbn,String title, String category_name,String author,String publisher,String publish_date) throws DAOException {
        // SQL文の作成
    	int category_code = getCategoryID(category_name); 
        String sql = "INSERT INTO cataloglist(isbn,title,category_code,author,publisher,publish_date) VALUES(?,?,?,?,?,?)";
		
        try (// データベースへの接続
             Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);){
			 // SQLの実行
        		st.setString(1, isbn);
        		st.setString(2, title);
        		st.setInt(3, category_code);
        		st.setString(4, author);
        		st.setString(5, publisher);
        		st.setDate(6, Date.valueOf(publish_date));
        		
        		st.executeUpdate();

        } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
        } 
    }
    
    //資料IDで在庫台帳を調べるメソッド
    public DiscardInfoBean getStockListByBookId(int book_id) throws DAOException {
        // SQL文の作成
        String sql = "SELECT s.book_id, s.isbn, c.title, s.arrival_date FROM stocklist s JOIN cataloglist c ON s.isbn = c.isbn WHERE s.book_id = ?";
		
        try (// データベースへの接続
             Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);){
			 // SQLの実行
        		st.setInt(1, book_id);
    			
        		try (// SQLの実行
       				 ResultSet rs = st.executeQuery();) {
       				// 結果の取得
       				DiscardInfoBean bean = null;
       				while (rs.next()) {
       					int book_id1 = rs.getInt("book_id");
       					String isbn = rs.getString("isbn");
       					String title = rs.getString("title");
       					String arrival_date = rs.getString("arrival_date");
       					bean = new DiscardInfoBean(book_id1, isbn, title, arrival_date);
       				}
       				// 商品一覧をListとして返す
       				return bean;
       			} catch (SQLException e) {
       				e.printStackTrace();
       				throw new DAOException("レコードの操作に失敗しました。");
       			}	
        } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
        } 
    }
    
    
    //在庫台帳で廃棄年月日を記入するメソッド
    public void updateStockListDiscard(int book_id,String discard_date,String remarks) throws DAOException {
        // SQL文の作成
        String sql = "update stocklist set discard_date = ?, remarks = ? where book_id = ?";
        try (// データベースへの接続
             Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);){
			 // SQLの実行
        		st.setDate(1, Date.valueOf(discard_date));
        		st.setString(2, remarks);
        		st.setInt(3, book_id);
        		
        		st.executeUpdate();

        } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
        } 
    }
    
    
    //貸出台帳に返却年月日を記入するメソッド
    public void updateReturnDate(int member_id, int book_id) throws DAOException {
        // SQL文の作成
        String sql = "update rentlist set return_date = current_date, remarks = null where member_id = ? and book_id = ?";
		
        try (// データベースへの接続
             Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);){
			 // SQLの実行
        		st.setInt(1, member_id);
        		st.setInt(2, book_id);
        		
        		st.executeUpdate();

        } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
        } 
    }
    

    //貸出履歴に記録を追加し、情報を取るメソッド
    public RentBean addRentListAndGetInfo(int member_id,int book_id, String return_deadline)throws DAOException {
        // SQL文の作成
        String sql1 = "insert into rentlist(member_id, book_id, rent_date, return_deadline) values(?, ?, current_date, ?)";
        String sql2 = "select * from rentlist where member_id = ? and book_id = ? and rent_date = current_date";

		
        try (// データベースへの接続
             Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql1);) {
			// カテゴリの設定
			st.setInt(1, member_id);
			st.setInt(2, book_id);
			st.setDate(3, Date.valueOf(return_deadline));
			
			st.executeUpdate();
        } catch (SQLException e) {
		    e.printStackTrace();
		    throw new DAOException("レコードの取得に失敗しました。");
        }
        try (// データベースへの接続
                Connection con1 = DriverManager.getConnection(url, user, pass);
   			 // PreparedStatementオブジェクトの取得
   			 PreparedStatement st1 = con1.prepareStatement(sql2);){
   			 // SQLの実行
           		st1.setInt(1, member_id);
           		st1.setInt(2, book_id);
       			
           		try (// SQLの実行
          				 ResultSet rs = st1.executeQuery();) {
          				// 結果の取得
          				RentBean bean = null;
          				while (rs.next()) {
          					int rent_id = rs.getInt("rent_id");
          					int member_id1 = rs.getInt("member_id");
          					int book_id1 = rs.getInt("book_id");
          					String rent_date = rs.getString("rent_date");
          					String return_deadline1 = rs.getString("return_deadline");
          					String return_date = rs.getString("return_date");
          					bean = new RentBean(rent_id, member_id1, book_id1, rent_date, return_deadline1, return_date);
          				
          				}
          				// 商品一覧をListとして返す
          				return bean;
          			} catch (SQLException e) {
          				e.printStackTrace();
          				throw new DAOException("レコードの操作に失敗しました。");
          			}
        } catch (SQLException e1) {
			e1.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} 
    }

    
    //資料IDでISBN番号を取るメソッド
    public String getIsbnByBook(int book_id) throws DAOException {
        // SQL文の作成
        String sql = "select isbn from stocklist where book_id = ?";
		
        try (// データベースへの接続
             Connection con = DriverManager.getConnection(url, user, pass);
			 // PreparedStatementオブジェクトの取得
			 PreparedStatement st = con.prepareStatement(sql);){
			 // SQLの実行
        		st.setInt(1, book_id);
        		String isbn = null;
        		ResultSet rs = st.executeQuery();
        		while (rs.next()) {
					isbn = rs.getString("isbn");
				}
        		return isbn;
        		
        } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
        } 
    }
    
    
    // クラス定義書に追加
    public String getCategoryName(int category_code) throws DAOException {
    	String sql = "select category_name from categorylist where category_code = ?";
    	
    	try (// データベースへの接続
                Connection con = DriverManager.getConnection(url, user, pass);
   			 // PreparedStatementオブジェクトの取得
   			 PreparedStatement st = con.prepareStatement(sql);){
   			 // SQLの実行
           		st.setInt(1, category_code);
           		String category_name = null;
           		ResultSet rs = st.executeQuery();
           		while (rs.next()) {
           			category_name = rs.getString("category_name");
   				}
           		return category_name;
           		
           } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}
    	
    }
    // クラス定義書に追加
    public int getCategoryID(String category_name) throws DAOException {
    	String sql = "select category_code from categorylist where category_name = ?";
    	
    	try (// データベースへの接続
                Connection con = DriverManager.getConnection(url, user, pass);
   			 // PreparedStatementオブジェクトの取得
   			 PreparedStatement st = con.prepareStatement(sql);){
   			 // SQLの実行
           		st.setString(1, category_name);
           		int category_code = 0;
           		ResultSet rs = st.executeQuery();
           		while (rs.next()) {
           			category_code = rs.getInt("category_code");
   				}
           		return category_code;
           		
           } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}
    	
    }
	
    
    public int getRentedBookCountByIsbn(String isbn) throws DAOException {
    	String sql = "select count(*) from rentlist r join stocklist s on r.book_id = s.book_id where isbn = ? and return_date is null";
    	
    	try (// データベースへの接続
                Connection con = DriverManager.getConnection(url, user, pass);
   			 // PreparedStatementオブジェクトの取得
   			 PreparedStatement st = con.prepareStatement(sql);){
   			 // SQLの実行
           		st.setString(1, isbn);
           		int count = 0;
           		ResultSet rs = st.executeQuery();
           		while (rs.next()) {
           			count = rs.getInt("count");
   				}
           		return count;
           		
           } catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}
    	
    }
    
}

