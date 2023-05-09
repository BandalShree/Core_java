package com.app.banking;

import java.time.LocalDate;

public class BankAccount {
//	Create Bank Account class(in the package - com.app.banking)  : having 
//	acct number(int) , customer name(string), account type (string) , account balance(double), 
//	account opening date(LocalDate)
	private Integer accNum;
	private String name;
	private String accType;
	private Double accBal;
	private LocalDate accOpenDate;
	
	public BankAccount(Integer accNum, String name, String accType, Double accBal, LocalDate accOpenDate) throws CustomException{
		if(accNum>5) this.accNum = accNum;
		else throw new CustomException("Account number should be more than 5 Digits");
		this.name = name;
		this.accType = accType;
		if(accBal>10000) this.accBal = accBal;
		else throw new CustomException("Minimum Account balance should be more than 10k");
		this.accOpenDate = accOpenDate;
	}

	@Override
	public String toString() {
		return "BankAccount [accNum=" + accNum + ", name=" + name + ", accType=" + accType + ", accBal=" + accBal
				+ ", accOpenDate=" + accOpenDate + "]";
	}
	
	public void withdrawMoney(Double money) throws CustomException{
		if(this.accBal-money>10000) {
			this.accBal-=money;
			System.out.println(money+" Suscessfully withdrawn Available Balance : "+this.accBal);
		}
		else throw new CustomException("can't Withdraw! Minimum Account balance should be more than 10k");
	}

	public Integer getAccNum() {
		return accNum;
	}

	public void depositMoney(Double money) {
		this.accBal+=money;
		System.out.println(money+" Suscessfully deposited Available Balance : "+this.accBal);
	}
	
	public void fundsTranfer(BankAccount receverAcc,Double money) throws CustomException{
		if(this.accBal-money>10000) {
			receverAcc.accBal+=money;
			this.accBal-=money;
			System.out.println(money+" Suscessfully Transferd Available Balance : "+this.accBal);
		}
		else throw new CustomException("can't Transfer! Minimum Account balance should be more than 10k");		
	}
	
}
