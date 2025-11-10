package com.ui.pojo;

public class User {
	private String emailaddress;
	private String password;
	public User(String emailaddress, String password) {
		super();
		this.emailaddress = emailaddress;
		this.password = password;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [emailaddress=" + emailaddress + ", password=" + password + "]";
	}
	

}
