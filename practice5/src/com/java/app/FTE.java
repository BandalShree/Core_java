package com.java.app;

import java.time.LocalDate;

public class FTE extends Employee {
	private Integer monthlySalary;

	public FTE(String name, LocalDate dateOfJoining, Long phoneNum, Long adharNum, Integer salary) {
		super(name, dateOfJoining, phoneNum, adharNum);
		monthlySalary = salary;
	}

	@Override
	public String toString() {
		return " FTE "+super.toString()+" monthlySalary=" + monthlySalary + "]";
	}

}
