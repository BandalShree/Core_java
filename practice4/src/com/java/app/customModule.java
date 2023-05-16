package com.java.app;

import java.util.ArrayList;
import java.util.List;

import com.java.app.Pet.Category;
import com.java.app.Order.Status;;

public interface customModule {
	static List<Users> populateUsers(){
		List<Users> users = new ArrayList<>();
		users.add(new Users("admin","admin"));
		users.add(new Users("c1","c1"));
		return users;
	}
	static List<Pet> populatePets(){
		List<Pet> pets = new ArrayList<>();
		pets.add(new Pet(1000,50,"Bull Dog",Category.DOG));
		pets.add(new Pet(3000,30,"Husky",Category.DOG));
		pets.add(new Pet(7000,10,"German Shepard",Category.DOG));
		pets.add(new Pet(500,70,"Pussy",Category.CAT));
		pets.add(new Pet(10000,25,"Rabby",Category.RABBIT));
		pets.add(new Pet(300,160,"Gold Fish",Category.FISH));
		return pets;
	}
	static List<Order> populateOrders(){
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1,25,Status.PLACED));
		orders.add(new Order(2,20,Status.PLACED));
		orders.add(new Order(3,20,Status.COMPLETED));
		orders.add(new Order(4,30,Status.IN_PROCESS));
		orders.add(new Order(5,60,Status.PLACED));
		orders.add(new Order(6,22,Status.IN_PROCESS));
		orders.add(new Order(7,6,Status.COMPLETED));
		return orders;
	}
}
