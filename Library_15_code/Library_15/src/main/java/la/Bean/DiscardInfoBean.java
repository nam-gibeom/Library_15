package la.Bean;

import java.io.Serializable;


public class DiscardInfoBean implements Serializable {
    private int book_id;
    private String isbn;
    private String title;
    private String arrival_date;
    private String discard_date;
    private String remarks;
	
    public DiscardInfoBean(int book_id, String isbn, String title, String arrival_date, String discard_date,
			String remarks) {
		super();
		this.book_id = book_id;
		this.isbn = isbn;
		this.title = title;
		this.arrival_date = arrival_date;
		this.discard_date = discard_date;
		this.remarks = remarks;
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

	public String getDiscard_date() {
		return discard_date;
	}

	public void setDiscard_date(String discard_date) {
		this.discard_date = discard_date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    
	
    
}