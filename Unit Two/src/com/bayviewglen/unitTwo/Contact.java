package com.bayviewglen.unitTwo;

public class Contact {

	private String lname;
	private String fname;
	private String phone;
	
	public Contact() {
		lname = null;
		fname = null;
		phone = null;
	}
	
	public Contact(String x, String y, String z) {
		lname = x;
		fname = y;
		phone = z;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
