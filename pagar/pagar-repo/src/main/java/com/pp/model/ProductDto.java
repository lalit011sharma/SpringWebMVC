package com.pp.model;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT_DETAIL")
public class ProductDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private int ProductId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRICE")
	private int price;
	
	@Column(name = "PRODUCT_CODE")
	private String productCode;
	
	@Column(name = "EXPIRE_DATE")
	private String expireDate;

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return ProductId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		ProductId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the expireDate
	 */
	public String getExpireDate() {
		return expireDate;
	}

	/**
	 * @param expireDate the expireDate to set
	 */
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	
}
