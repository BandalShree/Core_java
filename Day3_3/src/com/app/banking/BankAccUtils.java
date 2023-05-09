package com.app.banking;

import java.time.LocalDate;

import java.util.*;

import com.app.banking.BankAccount.AccountType;

public class BankAccUtils {
	public static List<BankAccount> populateList() throws CustomException {
		ArrayList <BankAccount>accounts = new ArrayList<>();
		accounts.add(new BankAccount(1,"Shree",AccountType.SAVING,25000.0,LocalDate.parse("2022-01-10")));
		accounts.add(new BankAccount(16,"rakesh",AccountType.CURRENT,34000.0,LocalDate.parse("2013-01-10")));
		accounts.add(new BankAccount(17,"aditya",AccountType.FD,70000.0,LocalDate.parse("2023-08-10")));
		accounts.add(new BankAccount(7,"lokesh",AccountType.NRE,125000.0,LocalDate.parse("2023-01-12")));
		accounts.add(new BankAccount(4,"saurav",AccountType.LOAN,25000.0,LocalDate.parse("2023-01-10")));
		accounts.add(new BankAccount(12,"akash",AccountType.NRO,27000.0,LocalDate.parse("2023-01-12")));
		return accounts;
	}
	
	public static HashMap<Integer,BankAccount> populateMap() throws CustomException {
		List <BankAccount>accountsList = BankAccUtils.populateList();
		HashMap<Integer,BankAccount> accountsMap = new HashMap<>();
		for(BankAccount account : accountsList)
			accountsMap.put(account.getAccNum(),account);
		return accountsMap;
	}
}
