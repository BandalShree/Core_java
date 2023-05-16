package com.java.tester;

import static com.java.app.customModule.populateOrders;
import static com.java.app.customModule.populatePets;
import static com.java.app.customModule.populateUsers;

import java.util.List;
import java.util.Scanner;

import com.java.app.CustomException;
import com.java.app.Order;
import com.java.app.Order.Status;
import com.java.app.Pet;
import com.java.app.Pet.Category;
import com.java.app.Users;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Users> users = populateUsers();
			List<Pet> pets = populatePets();
			List<Order> orders = populateOrders();
			Boolean isFalse = false;
			String user = null;
			while (!isFalse) {
				try {
					System.out.print("1. Login\n" + "2. Add new Pet (Admin only functionality)\n"
							+ "3. Update Pet details (Admin only functionality)\n" + "4. Display all available pets\n"
							+ "5. Order a Pet\n" + "6. Check order status by Order Id\n"
							+ "7. Update order status (Admin only functionality)\n" + "8. Exit\n" + "Select One : ");
					switch (sc.nextShort()) {
					case 1:
						System.out.println("Enter loginId and password");
						if ((user = users.get(users.indexOf(new Users(sc.next(), sc.next()))).getLoginId()) != null)
							System.out.println("Login Successful");
						break;
					case 2:
						if (user == "admin") {
							System.out.println("Enter unitPrice,stocks,name,category");
							pets.add(new Pet(sc.nextInt(), sc.nextInt(), sc.next(), Category.valueOf(sc.next().toUpperCase())));
						} else
							throw new CustomException("Admin only functionality");
						break;
					case 3:
						if (user == "admin") {
							System.out.print("Enter pet Id to update :");
							Integer val = sc.nextInt();
							if (pets.contains(new Pet(val))) {
								System.out.println("Enter unitPrice,stocks,name,category");
								pets.set(val-1,new Pet(val,sc.nextInt(), sc.nextInt(), sc.next(), Category.valueOf(sc.next().toUpperCase())));
							} else
								throw new CustomException("pet Id didn't found");
						} else
							throw new CustomException("Admin only functionality");
						break;
					case 4:
						if (user != null) {
							pets.forEach(System.out::println);
						} else
							throw new CustomException("Please Login First");
						break;
					case 5:
						if (user != null) {
							System.out.println("Enter pet Id and Quantity");
							Integer val =sc.nextInt();
							Order order = new Order(val, sc.nextInt());
							if (orders.contains(order))
								orders.set(val,order);
							else
								throw new CustomException("something went wrong can't place order");
						} else
							throw new CustomException("Please Login First");
						break;
					case 6:
						if (user != null) {
							System.out.println("Please enter order id");
							System.out.println(orders.get(sc.nextInt()).getStatus());
						} else
							throw new CustomException("Please Login First");
						break;
					case 7:
						if (user == "admin") {
							System.out.println("Ener Order Id and status");
							orders.get(orders.indexOf(sc.nextInt())).setStatus(Status.valueOf(sc.next().toUpperCase()));
							;
						} else
							throw new CustomException("Admin only functionality");
						break;
					case 8:
						isFalse = true;
						System.out.println("Please Come Again");
						break;
					default:
						System.out.println("Please Enter Valid Option");
						break;
					}
				}
				catch(IndexOutOfBoundsException exc) {
					System.out.println("Invalid Login Please try again");
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
