package com.java.app;

import java.time.LocalDate;

public class Employee {
	private Short empId;
	private static Short id = 1;
	private String name;
	private LocalDate dateOfJoining;
	private Long phoneNum, adharNum;

	public Employee(String name, LocalDate dateOfJoining, Long phoneNum, Long adharNum) {
		super();
		empId = id++;
		this.name = name;
		this.dateOfJoining = dateOfJoining;
		this.phoneNum = phoneNum;
		this.adharNum = adharNum;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dateOfJoining=" + dateOfJoining + ", phoneNum="
				+ phoneNum + ", adharNum=" + adharNum;
	}

	public Short getEmpId() {
		return empId;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public Long getAdharNum() {
		return adharNum;
	}

	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee)obj;
		return this.phoneNum.equals(emp.phoneNum) && this.phoneNum.equals(emp.phoneNum);
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

}
