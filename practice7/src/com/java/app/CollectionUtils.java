package com.java.app;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public interface CollectionUtils {
	static Map<Integer, StockTradingService> populateStocks() {
		Map<Integer, StockTradingService> stocks = new HashMap<>();
		stocks.put(2819,
				new StockTradingService("2819", "TCS", "TATA", 3300.23, LocalDate.parse("2024-12-10"), 3000));
		stocks.put(8371,
				new StockTradingService("8371", "LT", "LNT", 5100.83, LocalDate.parse("2023-10-17"), 1600));
		stocks.put(9323,
				new StockTradingService("9323", "KPIT", "KPITTECH", 2437.37, LocalDate.parse("2024-02-21"), 3700));
		stocks.put(1380,
				new StockTradingService("1380", "TITAN", "TATA", 3182.53, LocalDate.parse("2024-03-14"), 3300));
		stocks.put(9128,
				new StockTradingService("9128", "DMART", "DMART", 3279.73, LocalDate.parse("2023-08-10"), 3738));
		return stocks;
	}
}
