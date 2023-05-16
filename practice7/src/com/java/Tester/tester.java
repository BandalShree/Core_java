package com.java.Tester;

import static com.java.app.CollectionUtils.populateStocks;
import static com.java.app.ValidateStock.validateStock;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.java.app.StockTradingService;

public class tester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
						"/home/shreeyansh/Documents/workspace-spring-tool-suite-4-4.18.0.RELEASE/practice7/src/com/java/app/stocks.ser"))) {
			Boolean isFalse = false;
			Map<Integer, StockTradingService> stocks = populateStocks();
			while (!isFalse) {
				try {
					System.out.print("1. Add New stock in the market\n" + "2. View Available stocks by Company\n"
							+ "3. Purchase stocks\n" + "4. Sell Stocks\n" + "5. Save n Exit\n"
							+ "Please Select one Option : ");
					switch (sc.nextShort()) {
					case 1:
						System.out.println("Enter stock id, stock name, company name, price, closing date, quantity");
						StockTradingService stock = new StockTradingService(sc.next(), sc.next().toUpperCase(), sc.next().toUpperCase(),
								sc.nextDouble(), LocalDate.parse(sc.next()), sc.nextInt());
						validateStock(stocks, stock);
						stocks.put(Integer.parseInt(stock.getStockId()), stock);
						break;
					case 2:
						System.out.print("Enter Company Name : ");
						String name = sc.next().toUpperCase();
						stocks.values().stream().filter(stk -> stk.getCompanyName().equals(name))
								.forEach(System.out::println);
						break;
					case 3:
						System.out.print("Enter stock id, quantity : ");
						validateStock(stocks, sc.nextInt(), sc.nextInt(), false);
						break;
					case 4:
						System.out.print("Enter stock id, quantity : ");
						validateStock(stocks, sc.nextInt(), sc.nextInt(), true);
						break;
					case 5:
						stocks.values().forEach(obj->{
							try {
								oos.writeObject(obj);
							} catch (IOException e) {
								e.printStackTrace();
							}
						});
						isFalse = true;
						break;
					default:
						System.out.println("Please Select Valid Option");
						break;
					}
				}
				catch (InputMismatchException exc) {
					System.out.println(exc.getMessage());
					sc.next();
				}
				catch (Exception exc) {
					System.out.println(exc.getMessage());
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
