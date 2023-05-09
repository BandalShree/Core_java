package com.cdac.showroom;

import java.time.LocalDate;

public class ShowroomManagement implements Comparable<ShowroomManagement>{
//	chasisNo(string) : Unique ID, color(enum) , basePrice(double) , manufactureDate(LocalDate),company,isAvailable
	private String uniqueID;
	public enum Colours{
		RED(10000.0),WHITE(2000.0),BLACK(15000.0),BLUE(3000.0);
		private final Double price;
		private Colours(Double price) {
			this.price = price;
		}
		public Double getPrice() {
			return price;
		}
	}
	private Colours colour;
	private Double basePrice;
	private LocalDate manufactureDate;
	private String company;
	private Boolean isAvailable;
	
	public ShowroomManagement(String uniqueID,Colours colour, Double basePrice, LocalDate manufactureDate, String company) {
//		super();
		this.uniqueID = uniqueID;
		this.colour = colour;
		this.basePrice = basePrice+colour.getPrice();
		this.manufactureDate = manufactureDate;
		this.company = company;
		this.isAvailable=true;
	}
	
	@Override
	public int compareTo(ShowroomManagement obj) {
		return this.uniqueID.compareTo(obj.uniqueID);
	}
	
	public ShowroomManagement(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice() {
		this.basePrice-=this.basePrice/5; // 20% discount
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	@Override
	public String toString() {
		return "ShowroomManagement [uniqueID=" + uniqueID + ", colour=" + colour + ", basePrice=" + basePrice
				+ ", manufactureDate=" + manufactureDate + ", company=" + company + ", isAvailable=" + isAvailable
				+ "]";
	}

	public Colours getColour() {
		return colour;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ShowroomManagement)
			return this.uniqueID.equals(((ShowroomManagement)obj).uniqueID);
		throw new InvalidObject("Invoker object is not of ShowroomManagement class");
	}
	
	
}
