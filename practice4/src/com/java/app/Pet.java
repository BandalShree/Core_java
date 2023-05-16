package com.java.app;

public class Pet {
	private Integer petId,unitPrice,stocks;
	private String name;
	private Category category;
	private static Integer id=1;
	
	public enum Category{
		CAT, DOG, RABBIT, FISH
	}

	public Pet(Integer petId, Integer unitPrice, Integer stocks, String name, Category category) {
		super();
		this.petId = petId;
		this.unitPrice = unitPrice;
		this.stocks = stocks;
		this.name = name;
		this.category = category;
	}
	
	public Pet(Integer unitPrice, Integer stocks, String name, Category category) {
		super();
		this.petId = id++;
		this.unitPrice = unitPrice;
		this.stocks = stocks;
		this.name = name;
		this.category = category;
	}
	
	public Pet(Integer petId) {
		this.petId = petId;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", unitPrice=" + unitPrice + ", stocks=" + stocks + ", name=" + name
				+ ", category=" + category + "]";
	}

	public Integer getStocks() {
		return this.stocks;
	}

	@Override
	public boolean equals(Object obj) {
		return this.petId.equals(((Pet)obj).petId);
	}
	
}
