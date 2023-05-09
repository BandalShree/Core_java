package com.java.stack;

public class Customer {
	private int customerId;
	private String name;
	private String address;
	
	public Customer(int customerId, String name, String address) {
		this.customerId=customerId;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "customer Id=" + customerId  + " Customer name=" + name + ", address=" + address;
	}
}
