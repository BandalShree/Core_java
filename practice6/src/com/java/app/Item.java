package com.java.app;

import java.time.LocalDate;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable {
	private String itemCode,desc;
	private Double price;
	private LocalDate shipDate;
	
	
	public Item(String itemCode, String desc, Double price, LocalDate shipDate) {
		super();
		this.itemCode = itemCode;
		this.desc = desc;
		this.price = price;
		this.shipDate = shipDate;
	}


	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", desc=" + desc + ", price=" + price + ", shipDate=" + shipDate + "]";
	}


	public String getItemCode() {
		return itemCode;
	}


	public Double getPrice() {
		return price;
	}
	
	
}
