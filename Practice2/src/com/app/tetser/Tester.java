package com.app.tetser;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import com.java.app.Task;
import com.java.app.Task.ENUM;

public class Tester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			HashMap<Integer, Task> tasks = new HashMap<>();
			Boolean isFalse = false;
			while (!isFalse) {
				try {
					Task obj;
					System.out.print("\na. Add New Task\n" + "b. Delete a task\n" + "c. Update task status\n"
							+ "d. Display all pending tasks\n" + "e. Display all pending tasks for today\n"
							+ "f. Display all tasks sorted by taskDate\n" + "g. exit" + "Select one choice : ");
					switch (sc.next()) {
					case "a":
						System.out.println("Enter task Name, Describtion, Task Date to add");
						obj = new Task(sc.next(), sc.next(), LocalDate.parse(sc.next()));
						tasks.put(obj.getTaskId(), obj);
						break;
					case "b":
						System.out.print("Enter task Id to delete : ");
						tasks.get(sc.nextInt()).setActive(false);
						break;
					case "c":
						System.out.println("Enter task Id, task Name, Describtion, Task Date, Status to update");
						obj = new Task(sc.nextInt(), sc.next(), sc.next(), LocalDate.parse(sc.next()),
								ENUM.valueOf(sc.next().toUpperCase()));
						tasks.put(obj.getTaskId(), obj);
						break;
					case "d":
						tasks.values().stream().filter(i -> i.getStatus().equals(ENUM.PENDING))
								.forEach(System.out::println);
						break;
					case "e":
						tasks.values().stream().filter(i -> i.getStatus().equals(ENUM.PENDING))
								.filter(i -> i.getTaskDate().equals(LocalDate.now())).forEach(System.out::println);
						break;
					case "f":
						tasks.values().stream()
								.sorted((task1, task2) -> task1.getTaskDate().compareTo(task2.getTaskDate()))
								.forEach(System.out::println);
						break;
					case "g":
						isFalse=true;
						break;
					default:
						System.out.println("Please Select Valid Option");
						break;
					}
				} catch (Exception exc) {
					System.out.println("err" + exc.getMessage());
				}
			}
		}
	}
}
