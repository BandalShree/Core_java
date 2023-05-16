package com.java.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.java.app.ValidateItem.*;

public interface CollectionModule {
	static List<Item> populateItems() throws Exception {
		List<Item> items = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter item code, descibtion, price, shipment date");
			Item item = new Item(sc.next(), sc.next(), sc.nextDouble(), LocalDate.parse(sc.next()));
			validateItem(items,item);
			items.add(item);
		}
		sc.close();
		return items;
	}
}
