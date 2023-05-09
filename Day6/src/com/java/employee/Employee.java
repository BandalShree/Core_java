package com.java.employee;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Employee implements Serializable {
	Integer empId;
	String fName;
	String lName;
	Double salary;

	public enum Position {
		JR(25000.0), SR(50000.0), MANAGER(100000.0);

		public final Double minSalary;

		private Position(Double minSalary) {
			this.minSalary = minSalary;
		}
	}

	Position position;
	LocalDate JoinDate;

	public Employee(Integer empId, String fName, String lName, Double salary, Position position, LocalDate JoinDate) {
		this.empId = empId;
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.position = position;
		this.JoinDate = JoinDate;
	}

	public Integer getEmpId() {
		return empId;
	}

	public Position getPosition() {
		return position;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary += salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fName=" + fName + ", lName=" + lName + ", salary=" + salary
				+ ", position=" + position + ", JoinDate=" + JoinDate + "]";
	}

}
