package com.itc.app.productEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Products")
public class productEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	@Column(name="productCategory")
	private String productCategory;
	@Column(name="productName")
	private String productName;
	@Column(name="productUnitPrice")
	private int productUnitPrice;
	@Column(name="productPrice")
	private int productPrice;
	@Column(name="productUrl")
	private String productURL;
	@Column(name="productyQuantity")
	private int productQuantity;
	@Column(name="productDescription")
	private String productDescription;
	public productEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public productEntity(long productId, String productCategory, String productName, int productUnitPrice, int productPrice, String productURL,
			int productQuantity, String productDescription) {
		super();
		this.productId = productId;
		this.productCategory = productCategory;
		this.productName = productName;
		this.productUnitPrice = productUnitPrice;
		this.productPrice = productPrice;
		this.productURL = productURL;
		this.productQuantity = productQuantity;
		this.productDescription = productDescription;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getproductCategory() {
		return productName;
	}
	public void setproductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(int productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductURL() {
		return productURL;
	}
	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
	
}
