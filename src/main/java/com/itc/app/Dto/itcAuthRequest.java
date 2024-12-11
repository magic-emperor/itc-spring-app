package com.itc.app.Dto;

public class itcAuthRequest {
	private long userId;
	private String userPhone;
	private String userPassword;
	private String userRole;
	public itcAuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public itcAuthRequest(String userPhone, String userPassword, String userRole) {
		super();
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
}
