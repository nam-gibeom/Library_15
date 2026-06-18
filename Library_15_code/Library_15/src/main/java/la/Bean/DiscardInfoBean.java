package la.Bean;

import java.io.Serializable;


public class DiscardInfoBean implements Serializable {
    private int book_id;
    private String isbn;
    private String title;
    private String arrival_date;
    
	public DiscardInfoBean(int book_id, String isbn, String title, String arrival_date) {
		super();
		this.book_id = book_id;
		this.isbn = isbn;
		this.title = title;
		this.arrival_date = arrival_date;
	}

	public DiscardInfoBean() {
		super();
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(String arrival_date) {
		this.arrival_date = arrival_date;
	}

    
}