package la.Bean;

public class OverdueBean {
	int member_id;
	int book_id;
	String title;
	String return_deadline;
	String overdue_date;
	
	public OverdueBean() {
		super();
	}

	public OverdueBean(int member_id, int book_id, String return_deadline) {
		super();
		this.member_id = member_id;
		this.book_id = book_id;
		this.return_deadline = return_deadline;
	}

	public OverdueBean(int member_id, int book_id, String title, String return_deadline, String overdue_date) {
		super();
		this.member_id = member_id;
		this.book_id = book_id;
		this.title = title;
		this.return_deadline = return_deadline;
		this.overdue_date = overdue_date;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReturn_deadline() {
		return return_deadline;
	}

	public void setReturn_deadline(String return_deadline) {
		this.return_deadline = return_deadline;
	}

	public String getOverdue_date() {
		return overdue_date;
	}

	public void setOverdue_date(String overdue_date) {
		this.overdue_date = overdue_date;
	}
	
	
	
	

}
