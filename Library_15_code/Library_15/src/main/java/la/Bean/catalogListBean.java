package la.Bean;

public class catalogListBean {
	String isbn;
	String title;
	int category_code;
	String author;
	String publisher;
	String publish_date;
	
	public catalogListBean(String isbn, String title, int category_code, String author, String publisher,
			String publish_date) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.category_code = category_code;
		this.author = author;
		this.publisher = publisher;
		this.publish_date = publish_date;
	}

	public catalogListBean() {
		super();
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

	public int getCategory_code() {
		return category_code;
	}

	public void setCategory_code(int category_code) {
		this.category_code = category_code;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	
	
}
