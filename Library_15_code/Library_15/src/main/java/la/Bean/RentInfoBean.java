package la.Bean;

public class RentInfoBean {
	int book_id;
	String title;
	String return_deadline;
	
	public RentInfoBean(int book_id, String title) {
		super();
		this.book_id = book_id;
		this.title = title;
	}
	
	

	public String getReturn_deadline() {
		return return_deadline;
	}



	public void setReturn_deadline(String return_deadline) {
		this.return_deadline = return_deadline;
	}



	public RentInfoBean(int book_id, String title, String return_deadline) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.return_deadline = return_deadline;
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
