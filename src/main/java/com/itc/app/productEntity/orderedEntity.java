package com.itc.app.productEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderTable")
public class orderedEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	@Column(name="userId")
	private long userId;
	@Column(name="orderedDate")
	private String orderedDate;
	@Column(name = "orderedTime")
	private String orderedTime;
	@Column(name="orderedProductName")
	private String orderedProductName;
	@Column(name = "orderedProductQuantity")
	private int orderedProductQuantity;
	@Column(name="orderedUserName")
	private String oderedUserName;
	@Column(name = "orderedProductPrice")
	private int orderedProductPrice;
	@Column(name="orderdProductImageURL")
	private String orderdProductImageURL;
	@Column(name="oderedProductId")
	private long oderedProductId;
	@Column(name="orderedProductUnitPrice")
	private int orderedProductUnitPrice;
	@Column(name = "orderedUserNumber")
	private String orderedUserNumber;
	public orderedEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderedEntity(long orderId, long userId, String orderedDate, String orderedTime, String orderedProductName,
			int orderedProductQuantity, String oderedUserName, int orderedProductPrice, String orderdProductImageURL,
			long oderedProductId, int orderedProductUnitPrice,String orderedUserNumber) {
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
		this.orderedUserNumber = orderedUserNumber;
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
	public String getOrderedUserNumber() {
		return orderedUserNumber;
	}
	public void setOrderedUserNumber(String orderedUserNumber) {
		this.orderedUserNumber = orderedUserNumber;
	}
	
	
}
