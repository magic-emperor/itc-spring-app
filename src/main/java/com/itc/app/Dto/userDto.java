package com.itc.app.Dto;

import jakarta.persistence.Column;

public class userDto {
	
	private long userId;
	private String userName;
	private String userPassword;
	private String userPhone;
	private String userLocation;
	private String userRole;
	public userDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public userDto(long userId, String userName, String userPassword, String userPhone, String userLocation, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userLocation = userLocation;
		this.userRole = userRole;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
}
