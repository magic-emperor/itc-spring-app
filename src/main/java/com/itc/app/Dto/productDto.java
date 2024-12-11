package com.itc.app.Dto;

import jakarta.persistence.Column;

public class productDto {
	private long ProductId;
	private String ProductCategory;
	private String ProductName;
	private int ProductUnitPrice;
	private int ProductPrice;
	private String ProductURL;
	private int ProductQuantity;
	private String ProductDescription;
	public productDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public productDto(long productId, String productCategory, String productName, int productUnitPrice,
			int productPrice, String productURL, int productQuantity, String productDescription) {
		super();
		ProductId = productId;
		ProductCategory = productCategory;
		ProductName = productName;
		ProductUnitPrice = productUnitPrice;
		ProductPrice = productPrice;
		ProductURL = productURL;
		ProductQuantity = productQuantity;
		ProductDescription = productDescription;
	}
	public long getProductId() {
		return ProductId;
	}
	public void setProductId(long productId) {
		ProductId = productId;
	}
	public String getProductCategory() {
		return ProductCategory;
	}
	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProductUnitPrice() {
		return ProductUnitPrice;
	}
	public void setProductUnitPrice(int productUnitPrice) {
		ProductUnitPrice = productUnitPrice;
	}
	public int getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}
	public String getProductURL() {
		return ProductURL;
	}
	public void setProductURL(String productURL) {
		ProductURL = productURL;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	
	
}
