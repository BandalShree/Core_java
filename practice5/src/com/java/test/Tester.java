package com.java.test;

import static com.java.app.ValidateEmployee.validateEmp;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.java.app.CustomException;
import com.java.app.Employee;
import com.java.app.FTE;
import com.java.app.PTE;

public class Tester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<Short, Employee> employees = new HashMap<>();
			Boolean isFalse = false;
			while (!isFalse) {
				try {
					System.out.print("1. Add full time employee\n" + "2. Add part time employee\n"
							+ "3. Delete an employee by Emp Id\n" + "4. Search employee details by Aadhaar number\n"
							+ "5. Display all employee details\n"
							+ "6. Display all employee details sorted by date of joining\n" + "7. Exit\n"
							+ "Please Select one Option : ");
					switch (sc.nextShort()) {
					case 1:
						System.out.println(
								"Please Enter name, date of joining, phone number, adhar number, monthly salary");
						Employee emp = new FTE(sc.next(), LocalDate.parse(sc.next()), sc.nextLong(), sc.nextLong(),
								sc.nextInt());
						validateEmp(employees, emp);
						employees.put(emp.getEmpId(), emp);
						break;
					case 2:
						System.out
								.println("Please Enter name, date of joining, phone number, adhar number, hourly pay");
						emp = new PTE(sc.next(), LocalDate.parse(sc.next()), sc.nextLong(), sc.nextLong(),
								sc.nextInt());
						validateEmp(employees, emp);
						employees.put(emp.getEmpId(), emp);
						break;
					case 3:
						System.out.print("Enter employee id : ");
						employees.remove(sc.nextShort());
						break;
					case 4:
						System.out.print("Enter Adhar Number : ");
						Long num = sc.nextLong();
						employees.values().stream().filter(e -> e.getAdharNum().equals(num))
								.forEach(System.out::println);
						break;
					case 5:
						employees.values().forEach(System.out::println);
						break;
					case 6:
						employees.values().stream()
								.sorted((e1, e2) -> e1.getDateOfJoining().compareTo(e2.getDateOfJoining()))
								.forEach(System.out::println);
						;
						break;
					case 7:
						System.out.println("Thanks for Visit");
						isFalse = true;
						break;
					default:
						System.out.println("Please Enter Valid Option");
						break;
					}
				} catch (InputMismatchException exc) {
					System.out.println(exc.getMessage());
					sc.next();
				} catch (CustomException exc) {
					System.out.println(exc.getMessage());
				} catch (Exception exc) {
					System.out.println(exc.getMessage());
					sc.next();
					sc.next();
					sc.next();
				}
			}
		}
	}
}
