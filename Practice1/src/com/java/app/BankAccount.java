package com.java.app;

import java.time.LocalDate;

public class BankAccount {
	private LocalDate TransactionDate;
	private String Narration;
	private Double WithdrawalAmount,DepositAmount;
	
	public BankAccount(LocalDate transactionDate, String narration, Double withdrawalAmount, Double depositAmount) {
		super();
		TransactionDate = transactionDate;
		Narration = narration;
		WithdrawalAmount = withdrawalAmount;
		DepositAmount = depositAmount;
	}

	@Override
	public String toString() {
		return "BankAccount [TransactionDate=" + TransactionDate + ", Narration=" + Narration + ", WithdrawalAmount="
				+ WithdrawalAmount + ", DepositAmount=" + DepositAmount + "]";
	}

	public Double getDepositAmount() {
		return DepositAmount;
	}

	public Double getWithdrawalAmount() {
		return WithdrawalAmount;
	}

	public LocalDate getTransactionDate() {
		return TransactionDate;
	}
	
	
}
