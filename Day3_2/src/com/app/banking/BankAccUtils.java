package com.app.banking;

import java.time.LocalDate;

import java.util.*;

import com.app.banking.BankAccount.AccountType;

public class BankAccUtils {
	public static List<BankAccount> populateList() throws CustomException {
		ArrayList <BankAccount>accounts = new ArrayList<>();
		accounts.add(new BankAccount(1,"SHREE",AccountType.SAVING,25000.0,LocalDate.parse("2022-01-10")));
		accounts.add(new BankAccount(3,"Shreeman",AccountType.CURRENT,34000.0,LocalDate.parse("2013-01-10")));
		accounts.add(new BankAccount(5,"Sheeyas",AccountType.FD,70000.0,LocalDate.parse("2023-08-10")));
		accounts.add(new BankAccount(7,"Sheya",AccountType.NRE,125000.0,LocalDate.parse("2023-01-12")));
		accounts.add(new BankAccount(4,"shreeyansh",AccountType.LOAN,25000.0,LocalDate.parse("2023-01-10")));
		accounts.add(new BankAccount(2,"shreeyansh",AccountType.NRO,27000.0,LocalDate.parse("2023-01-12")));
		return accounts;
	}
}
