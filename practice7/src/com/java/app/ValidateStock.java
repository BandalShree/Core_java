package com.java.app;

import java.time.LocalDate;
import java.util.Map;

public interface ValidateStock {
	static void validateStock(Map<Integer, StockTradingService> stocks, StockTradingService stock)
			throws CustomException {
		if (stocks.containsKey(Integer.parseInt(stock.getStockId()))
				|| stock.getClosingDate().compareTo(LocalDate.now()) <= 0) 
			throw new CustomException("centralized manner in StockTradingService");

	}

	static void validateStock(Map<Integer, StockTradingService> stocks, Integer id, Integer quantity, Boolean isSell)
			throws CustomException {
		if (!stocks.containsKey(id)) {
			throw new CustomException("Invalid stock Id");
		} else {
			StockTradingService stock = stocks.get(id);
			Integer qty = stock.getQuantity();
			if (isSell) {
				stock.setQuantity(qty + quantity);
				stocks.put(id, stock);
			} else {
				if (qty < quantity)
					throw new CustomException("Quantity of stocks doesn't present");
				stock.setQuantity(qty - quantity);
				stocks.put(id, stock);
			}
		}
	}
}
