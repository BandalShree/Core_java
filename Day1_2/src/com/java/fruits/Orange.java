package com.java.fruits;

public class Orange extends Fruits{
	public Orange(String colour, double weight, boolean isFresh) {
		super(colour, weight, "Orange", isFresh);
	}
	public void juice() {
		//Display name n weight of the fruit + a mesg extracting juice!
		System.out.println("Name : "+super.getName()+" Weight : "+super.getWeight()+" extracting juice! ");
	}
	@Override
	public String taste() {
		return "sour";
	}
}
