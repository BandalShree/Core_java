package com.java.product;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Product implements Serializable {
	private Integer productId;
	private String productName;
	private Double productPrice;

	public enum Category {
		CONSUMER, COMMODITIES, PREMIUM
	}

	private Category productCategory;
	private LocalDate productManfDate;

	public Product(Integer productId, String productName, Double productPrice, Category productCategory,
			LocalDate productManfDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productManfDate = productManfDate;
	}

	public Double getProductPrice() {
		return productPrice;
	}


	public LocalDate getProductManfDate() {
		return productManfDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCategory=" + productCategory + ", productManfDate=" + productManfDate + "]";
	}

}
