package com.java.tester;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.Scanner;

import com.java.product.Product;
import com.java.product.Product.Category;

import static com.java.utils.IOUtils.*;

public class Tester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String fileName = "/home/shreeyansh/Documents/workspace-spring-tool-suite-4-4.18.0.RELEASE/Day7/src/text.ser";
			
			
//			HashMap<Integer, Product> mapEmp = new HashMap<>();
//			mapEmp.put(1, new Product(1,"chips",10.0,Category.valueOf("COMMODITIES"),LocalDate.of(2022, 12, 12)));
//			mapEmp.put(2, new Product(2,"brush",30.0,Category.valueOf("COMMODITIES"),LocalDate.of(2023, 10, 18)));
//			mapEmp.put(3, new Product(3,"chair",500.0,Category.valueOf("CONSUMER"),LocalDate.of(2017, 12, 16)));
//			mapEmp.put(4, new Product(4,"mobile",20000.0,Category.valueOf("PREMIUM"),LocalDate.of(2022, 03, 26)));
//			mapEmp.put(5, new Product(5,"table",3000.0,Category.valueOf("CONSUMER"),LocalDate.of(2023, 10, 29)));
//			mapEmp.put(6, new Product(6,"laptop",70000.0,Category.valueOf("PREMIUM"),LocalDate.of(2022, 02, 02)));
//			writeData(mapEmp,fileName);
			
			
			HashMap<Integer, Product> mapEmp = readData(fileName);
			Thread sortByDate = new Thread(() -> {
				mapEmp.values().stream()
						.sorted((hm1, hm2) -> hm1.getProductManfDate().compareTo(hm2.getProductManfDate()));
				writeData(mapEmp,
						"/home/shreeyansh/Documents/workspace-spring-tool-suite-4-4.18.0.RELEASE/Day7/src/sortByDate.ser");
			});
			Thread sortByPrice = new Thread(() -> {
				mapEmp.values().stream().sorted((hm1, hm2) -> hm1.getProductPrice().compareTo(hm2.getProductPrice()));
				writeData(mapEmp,
						"/home/shreeyansh/Documents/workspace-spring-tool-suite-4-4.18.0.RELEASE/Day7/src/sortByPrice.ser");
			});
			sortByDate.start();
			sortByPrice.start();
			sortByDate.join();
			sortByPrice.join();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
