package la.Dao;

public class DAOException extends Exception {

	public DAOException(String message) {
		super(message);
		System.out.println(message);
	}
}