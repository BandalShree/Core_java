package com.java.app;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class StockTradingService implements Serializable{
	private String stockId, stockName, companyName;
	private Double price;
	private LocalDate closingDate;
	private Integer quantity;
	
	public StockTradingService(String stockId, String stockName, String companyName, Double price,
			LocalDate closingDate, Integer quantity) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.companyName = companyName;
		this.price = price;
		this.closingDate = closingDate;
		this.quantity = quantity;
	}

	public String getStockId() {
		return stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public Double getPrice() {
		return price;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "StockTradingService [stockId=" + stockId + ", stockName=" + stockName + ", companyName=" + companyName
				+ ", price=" + price + ", closingDate=" + closingDate + ", quantity=" + quantity + "]";
	}
	
	
}
