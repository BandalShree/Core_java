package com.java.fruits;
abstract public class Fruits {
	private String colour;
	private double weight;
	private String name;
	private boolean isFresh;
	
	public Fruits(String colour, double weight, String name, boolean isFresh) {
		this.colour = colour;
		this.weight = weight;
		this.name = name;
		this.isFresh = isFresh;
	}

	public String getColour() {
		return colour;
	}

	public double getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}
	
	public boolean getIsFresh() {
		return isFresh;
	}

	public void setIsFresh(boolean isFresh) {
		this.isFresh = isFresh;
	}

	@Override
	public String toString() {
		return "colour=" + colour + ", weight=" + weight + ", name=" + name ;
	}
	
	abstract public String taste();
}
