package com.java.fruits;
abstract public class Fruits {
	private String colour;
	private double weight;
	private String name;
	private boolean isFresh;
	
	public Fruits(String colour, double weight, String name, boolean isFresh) {
		if(isFreash) {
			this.colour = colour;
			this.weight = weight;
			this.name = name;
			this.isFresh = true;
		}
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
	
	public void setIsFresh(boolean isFresh) {
		this.isFresh = isFresh;
	}

	@Override
	public String toString() {
		return "Fruits [colour=" + colour + ", weight=" + weight + ", name=" + name + "]";
	}
	
	abstract public String taste();
	
}
