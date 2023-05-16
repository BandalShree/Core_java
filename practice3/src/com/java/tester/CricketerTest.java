package com.java.tester;

import java.util.Map;
import java.util.Scanner;

import static com.java.app.CollectionMod.*;
import com.java.app.Cricketer;

public class CricketerTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<Short, Cricketer> map = populate();
			Boolean isFalse = false;
			while (!isFalse) {
				System.out.print("\n1. Accept minimum 5 Cricketers in the collection.\n"
						+ "2. Modify Cricketer's rating\n"
						+ "3. Search Cricketer by name\n"
						+ "4. Display all Cricketers added in collection.\n"
						+ "5. Display All Cricketers in sorted form by rating.\n"
						+ "6. exit\n"
						+ "Choose One Option : ");
				switch (sc.nextShort()) {
				case 1:
					map.putAll(populate());
					break;
				case 2:
					map.values().forEach(i -> {
						System.out.print("Modify for " + i.getCricketerId()+": ");
						i.setRating(sc.nextShort());
					});
					break;
				case 3:
					System.out.print("Enter Name to Search : ");
					String name = sc.next();
					map.values().stream().filter(i -> i.getName().equals(name)).forEach(System.out::println);
					break;
				case 4:
					map.values().forEach(System.out::println);
					break;
				case 5:
					map.values().stream().sorted((obj1,obj2)->obj1.getRating().compareTo(obj2.getRating())).forEach(System.out::println);
					break;
				case 6:
					isFalse = true;
					break;
				default:
					System.out.println("Please Select Valid Option");
					break;
				}
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
