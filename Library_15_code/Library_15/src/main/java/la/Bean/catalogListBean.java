package la.Bean;

public class catalogListBean {
	int book_code;
	String isbn;
	String title;
	String category_name;
	String author;
	String publisher;
	String publish_date;
	
	public catalogListBean(int book_code, String isbn, String title, String category_name, String author, String publisher,
			String publish_date) {
		super();
		this.book_code = book_code;
		this.isbn = isbn;
		this.title = title;
		this.category_name = category_name;
		this.author = author;
		this.publisher = publisher;
		this.publish_date = publish_date;
	}

	public catalogListBean(String isbn, String title, String category_name, String author, String publisher,
			String publish_date) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.category_name = category_name;
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

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
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
