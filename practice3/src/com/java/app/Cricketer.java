package com.java.app;

public class Cricketer {
	private static Short id=1;
	private Short cricketerId;
	private String name;
	private Short age;
	private String email_id;
	private Long phone;
	private Short rating;
	
	public Cricketer(String name, Short age, String email_id, Long phone, Short rating) {
		this.cricketerId=id++;
		this.name = name;
		this.age = age;
		this.email_id = email_id;
		this.phone = phone;
		this.rating = rating;
	}

	public Short getCricketerId() {
		return cricketerId;
	}

	public void setRating(Short rating) {
		this.rating = rating;
	}

	public Short getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Cricketer [cricketerId=" + cricketerId + ", name=" + name + ", age=" + age + ", email_id=" + email_id
				+ ", phone=" + phone + ", rating=" + rating + "]";
	}
	
	
	
}
