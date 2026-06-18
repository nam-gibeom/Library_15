package la.Bean;

public class RentInfoBean {
	int book_id;
	String title;
	
	public RentInfoBean(int book_id, String title) {
		super();
		this.book_id = book_id;
		this.title = title;
	}

	public RentInfoBean() {
		super();
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
