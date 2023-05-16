package com.java.app;

import java.time.LocalDate;

public class PTE extends Employee {
	private Integer hourlyPay;

	public PTE(String name, LocalDate dateOfJoining, Long phoneNum, Long adharNum, Integer pay) {
		super(name, dateOfJoining, phoneNum, adharNum);
		hourlyPay = pay;
	}

	@Override
	public String toString() {
		return " PTE "+super.toString()+" hourlyPay=" + hourlyPay + "]";
	}

}
