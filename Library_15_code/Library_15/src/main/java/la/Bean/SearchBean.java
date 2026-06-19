package la.Bean;

public class SearchBean {
	String title;
	String category_name;
	String publish_date;
	int canRentDay;
	String rentAvailable;
	
	public SearchBean(String title, String category_name, String publish_date, int canRentDay, String rentAvailable) {
		super();
		this.title = title;
		this.category_name = category_name;
		this.publish_date = publish_date;
		this.canRentDay = canRentDay;
		this.rentAvailable = rentAvailable;
	}

	public SearchBean() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public int getCanRentDay() {
		return canRentDay;
	}

	public void setCanRentDay(int canRentDay) {
		this.canRentDay = canRentDay;
	}

	public String getRentAvailable() {
		return rentAvailable;
	}

	public void setRentAvailable(String rentAvailable) {
		this.rentAvailable = rentAvailable;
	}
	
	
}
