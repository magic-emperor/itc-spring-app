package com.itc.app.Dto;

import jakarta.persistence.Column;

public class orderdDto {
	private long orderId;
	private long userId;
	private String orderedDate;
	private String orderedTime;
	private String orderedProductName;
	private int orderedProductQuantity;
	private String oderedUserName;
	private int orderedProductPrice;
	private String orderdProductImageURL;
	private long oderedProductId;
	private int orderedProductUnitPrice;
	private String orderedProductNumber;
	public orderdDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderdDto(long orderId, long userId, String orderedDate, String orderedTime, String orderedProductName,
			int orderedProductQuantity, String oderedUserName, int orderedProductPrice, String orderdProductImageURL,
			long oderedProductId, int orderedProductUnitPrice, String orderedProductNumber) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderedDate = orderedDate;
		this.orderedTime = orderedTime;
		this.orderedProductName = orderedProductName;
		this.orderedProductQuantity = orderedProductQuantity;
		this.oderedUserName = oderedUserName;
		this.orderedProductPrice = orderedProductPrice;
		this.orderdProductImageURL = orderdProductImageURL;
		this.oderedProductId = oderedProductId;
		this.orderedProductUnitPrice = orderedProductUnitPrice;
		this.orderedProductNumber = orderedProductNumber;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}
	public String getOrderedTime() {
		return orderedTime;
	}
	public void setOrderedTime(String orderedTime) {
		this.orderedTime = orderedTime;
	}
	public String getOrderedProductName() {
		return orderedProductName;
	}
	public void setOrderedProductName(String orderedProductName) {
		this.orderedProductName = orderedProductName;
	}
	public int getOrderedProductQuantity() {
		return orderedProductQuantity;
	}
	public void setOrderedProductQuantity(int orderedProductQuantity) {
		this.orderedProductQuantity = orderedProductQuantity;
	}
	public String getOderedUserName() {
		return oderedUserName;
	}
	public void setOderedUserName(String oderedUserName) {
		this.oderedUserName = oderedUserName;
	}
	public int getOrderedProductPrice() {
		return orderedProductPrice;
	}
	public void setOrderedProductPrice(int orderedProductPrice) {
		this.orderedProductPrice = orderedProductPrice;
	}
	public String getOrderdProductImageURL() {
		return orderdProductImageURL;
	}
	public void setOrderdProductImageURL(String orderdProductImageURL) {
		this.orderdProductImageURL = orderdProductImageURL;
	}
	public long getOderedProductId() {
		return oderedProductId;
	}
	public void setOderedProductId(long oderedProductId) {
		this.oderedProductId = oderedProductId;
	}
	public int getOrderedProductUnitPrice() {
		return orderedProductUnitPrice;
	}
	public void setOrderedProductUnitPrice(int orderedProductUnitPrice) {
		this.orderedProductUnitPrice = orderedProductUnitPrice;
	}
	public String getOrderedProductNumber() {
		return orderedProductNumber;
	}
	public void setOrderedProductNumber(String orderedProductNumber) {
		this.orderedProductNumber = orderedProductNumber;
	}
	
	
}
