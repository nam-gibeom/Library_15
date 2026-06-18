package la.Bean;

import java.io.Serializable;


public class RentBean implements Serializable {
    private int rent_id;
    private int member_id;
    private int book_id;
    private String rent_date;
    private String return_deadline;
    private String return_date;
	
    public RentBean(int rent_id, int member_id, int book_id, String rent_date, String return_deadline,
			String return_date) {
		super();
		this.rent_id = rent_id;
		this.member_id = member_id;
		this.book_id = book_id;
		this.rent_date = rent_date;
		this.return_deadline = return_deadline;
		this.return_date = return_date;
	}

	public RentBean() {
		super();
	}

	public int getRent_id() {
		return rent_id;
	}

	public void setRent_id(int rent_id) {
		this.rent_id = rent_id;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getRent_date() {
		return rent_date;
	}

	public void setRent_date(String rent_date) {
		this.rent_date = rent_date;
	}

	public String getReturn_deadline() {
		return return_deadline;
	}

	public void setReturn_deadline(String return_deadline) {
		this.return_deadline = return_deadline;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	
}

