package com.java.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public interface IOModule {
	static ArrayList<BankAccount> populateList(String str) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(str));
		ArrayList<BankAccount> accounts = new ArrayList<>();
		br.lines().forEach((line)->{
			String []data = line.split(",");
			String []date = data[0].split("-");
			accounts.add(new BankAccount(LocalDate.parse(date[2]+"-"+date[1]+"-"+date[0]),data[1],Double.parseDouble(data[2]),Double.parseDouble(data[3])));
		});
		return accounts;
	}
}
