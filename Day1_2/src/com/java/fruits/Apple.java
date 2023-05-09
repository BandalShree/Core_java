package com.java.fruits;

public class Apple extends Fruits{
	public Apple(String colour, double weight, boolean isFresh) {
		super(colour, weight, "Apple", isFresh);
	}
	public void jam() {
		//Display name of the fruit + a mesg making jam!
		System.out.println("Name : "+super.getName()+" making jam! ");
	}
	@Override
	public String taste() {
		return "sweet n sour";
	}
}
