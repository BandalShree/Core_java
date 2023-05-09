package com.app.banking;

import java.util.Comparator;

public class AccCreationDate implements Comparator<BankAccount>{

	@Override
	public int compare(BankAccount o1, BankAccount o2) {
		return o1.getAccOpenDate().compareTo(o2.getAccOpenDate());
	}
	
}
