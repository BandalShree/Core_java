package com.java.tester;

import static com.java.app.CollectionModule.populateItems;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.java.app.Item;

public class Tester {
	public static void main(String[] args) {
		String str = "/home/shreeyansh/Documents/workspace-spring-tool-suite-4-4.18.0.RELEASE/practice6/src/com/java/app/";
		try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(str+"items_code1.ser"));
				ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(str+"items_code2.ser"));){
			List<Item> items = populateItems();
			System.out.println("Sorting as per Item Code...");
			items.stream().sorted((i1,i2)->i1.getItemCode().compareTo(i2.getItemCode())).forEach(item->{
				System.out.println(item);
			});
			items.forEach(item->{
				try {
					oos1.writeObject(item);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			System.out.println("Sorting as per Item Price...");
			items.stream().sorted((i1,i2)->i1.getPrice().compareTo(i2.getPrice())).forEach(item->{
				System.out.println(item);
			});
			items.forEach(item->{
				try {
					oos2.writeObject(item);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
