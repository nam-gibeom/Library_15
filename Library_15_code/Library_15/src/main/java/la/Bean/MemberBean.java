package la.bean;

import java.io.Serializable;

public class MemberBean implements Serializable {
	private int member_id;
	private String member_name;
	private String member_address;
	private String member_tel;
	private String member_mail;
	private String member_birth_year;
	private String member_birth_month;
	private String member_birth_day;
	private String member_registdate;
	private String current_date;
	
	public MemberBean(int member_id, String member_name, String member_address, String member_tel, String member_mail,
			String member_birth_year, String member_birth_month, String member_birth_day, String member_registdate,
			String current_date) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
		this.member_address = member_address;
		this.member_tel = member_tel;
		this.member_mail = member_mail;
		this.member_birth_year = member_birth_year;
		this.member_birth_month = member_birth_month;
		this.member_birth_day = member_birth_day;
		this.member_registdate = member_registdate;
		this.current_date = current_date;
	}
	
	

	public MemberBean(int member_id, String member_name) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
	}



	public MemberBean() {
		super();
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public String getMember_tel() {
		return member_tel;
	}

	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}

	public String getMember_mail() {
		return member_mail;
	}

	public void setMember_mail(String member_mail) {
		this.member_mail = member_mail;
	}

	public String getMember_birth_year() {
		return member_birth_year;
	}

	public void setMember_birth_year(String member_birth_year) {
		this.member_birth_year = member_birth_year;
	}

	public String getMember_birth_month() {
		return member_birth_month;
	}

	public void setMember_birth_month(String member_birth_month) {
		this.member_birth_month = member_birth_month;
	}

	public String getMember_birth_day() {
		return member_birth_day;
	}

	public void setMember_birth_day(String member_birth_day) {
		this.member_birth_day = member_birth_day;
	}

	public String getMember_registdate() {
		return member_registdate;
	}

	public void setMember_registdate(String member_registdate) {
		this.member_registdate = member_registdate;
	}

	public String getCurrent_date() {
		return current_date;
	}

	public void setCurrent_date(String current_date) {
		this.current_date = current_date;
	}
	
	
	





	
}
    
    

