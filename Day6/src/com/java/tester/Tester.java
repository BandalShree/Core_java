package com.java.tester;

import static com.java.utils.IOUtils.readData;
import static com.java.utils.IOUtils.writeData;
import static com.java.validations.Validations.isUniqEmpId;
import static com.java.validations.Validations.isValidEmpSal;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.java.employee.Employee;
import com.java.employee.Employee.Position;
import com.java.exception.CustomException;

public class Tester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String fileName = "/home/shreeyansh/Documents/workspace-spring-tool-suite-4-4.18.0.RELEASE/Day6/src/text.ser";

			HashMap<Integer, Employee> mapEmp = readData(fileName);
			Boolean isExit = false;
			while (!isExit) {

				try {
					System.out.print("\n1. Add emp details\n" + "2. Display all emps\n" + "3. Retrieve by emp id\n"
							+ "4. Update by emp id\n" + "5. Delete all emp details\n" + "6. Delete emp details by emp id\n"
							+ "7. display all emps from specific pos , between sal range\n" + "8. Salary increment\n"
							+ "9. Exit\n" + "Enter your Choise : ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter employee id, first name, last name, salary, position, joining date");
						Employee emp = new Employee(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),
								Position.valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()));
						isUniqEmpId(emp.getEmpId(), mapEmp);
						isValidEmpSal(emp);
						mapEmp.put(emp.getEmpId(), emp);
						break;
					case 2:
						mapEmp.values().forEach(System.out::println);
						break;
					case 3:
						System.out.print("Enter the emp Id you wanna search : ");
						emp = mapEmp.get(sc.nextInt());
						if (emp == null)
							throw new CustomException("Employee is not register! please register first");
						System.out.println(emp);
						break;
					case 4:
						System.out.print("Enter the emp Id you wanna update details : ");
						emp = mapEmp.get(sc.nextInt());
						if (emp == null)
							throw new CustomException("Employee is not register for update! please register first");
						System.out.println(
								"Enter new details employee id, first name, last name, salary, position, joining date");
						Employee newEmp = new Employee(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),
								Position.valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()));
						isUniqEmpId(newEmp.getEmpId(), mapEmp);
						isValidEmpSal(newEmp);
						mapEmp.remove(emp.getEmpId());
						mapEmp.put(newEmp.getEmpId(), newEmp);
						break;
					case 5:
						mapEmp.forEach((key,value) -> mapEmp.remove(key));
						break;
					case 6:
						System.out.print("Enter the emp Id you wanna search : ");
						emp = mapEmp.get(sc.nextInt());
						if (emp == null)
							throw new CustomException("Employee is not register to delete! please register first");
						mapEmp.remove(emp.getEmpId());
						break;
					case 7:
						System.out.print("Enter Employee Position : ");
						Position depName = Position.valueOf(sc.next().toUpperCase());
						System.out.print("Enter Salary Range min salary and max salary : ");
						Double minSal = sc.nextDouble();
						Double maxSal = sc.nextDouble();
						mapEmp.values().stream().filter(val -> val.getPosition().equals(depName) && val.getSalary()>minSal && val.getSalary()<maxSal).forEach(System.out::println);
						break;
					case 8:
						System.out.print("Enter Employee Position to give increment: ");
						depName = Position.valueOf(sc.next().toUpperCase());
						System.out.print("Enter Increment Percentage : ");
						Integer percent = sc.nextInt();
						mapEmp.values().stream().filter(val -> val.getPosition().equals(depName)).forEach(val -> val.setSalary(val.getSalary()*percent/100));
						break;
					case 9:
						isExit = true;
						break;
					default:
						System.out.println("Please select valid option");
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					sc.next();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			writeData(mapEmp, fileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
