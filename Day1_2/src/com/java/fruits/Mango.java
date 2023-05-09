package com.java.fruits;

public class Mango extends Fruits{
	public Mango(String colour, double weight, boolean isFresh) {
		super(colour, weight, "Mango", isFresh);
	}
	public void pulp() {
		//Display name n color of the fruit + a mesg  creating  pulp!
		System.out.println("Name : "+super.getName()+" Colour : "+super.getColour()+" creating  pulp! ");
	}
	@Override
	public String taste() {
		return "sweet";
	}
}
