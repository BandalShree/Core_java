package com.java.tester;

import java.util.ArrayList;
import java.util.Scanner;
import com.java.app.*;

public class tester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			ArrayList<BankAccount> accounts = IOModule.populateList("/home/shreeyansh/Documents/workspace-spring-tool-suite-4-4.18.0.RELEASE/Practice1/src/com/java/app/jan2023");
			System.out.println("Sum of all deposits = "+accounts.stream().mapToDouble(obj->obj.getDepositAmount()).sum());
			System.out.println("Max deposit amount = "+accounts.stream().mapToDouble(obj->obj.getDepositAmount()).max().getAsDouble());
			System.out.println("Shopping expenses = "+accounts.stream().mapToDouble(obj->obj.getWithdrawalAmount()).sum());
			System.out.println("Date on which maximum amount withdrawn = "+accounts.stream().filter(i->i.getWithdrawalAmount().equals(accounts.stream().mapToDouble(obj->obj.getWithdrawalAmount()).max().getAsDouble())).findFirst().get().getTransactionDate());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
