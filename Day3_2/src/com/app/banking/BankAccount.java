package com.app.banking;

import java.time.LocalDate;

public class BankAccount implements Comparable<BankAccount>{
//	Create Bank Account class(in the package - com.app.banking)  : having 
//	acct number(int) , customer name(string), account type (string) , account balance(double), 
//	account opening date(LocalDate)
	private Integer accNum;
	private String name;
	public enum AccountType{
		SAVING(10000.0),CURRENT(30000.0),FD(50000.0),NRE(100000.0),LOAN(20000.0),NRO(25000.0);//constructor call
		private final Double minBal;// instance variable
		private AccountType(Double bal) { //private 
			minBal = bal;//this is not for enum
		}
		public Double getMinBal() { //getter needed
			return minBal;
		}
	}
	private AccountType accType;
	private Double minBal;
	private Double accBal;
	private LocalDate accOpenDate;
	
	public BankAccount(Integer accNum, String name, AccountType accType, Double accBal, LocalDate accOpenDate) throws CustomException{
		this.accNum = accNum;
		this.name = name;
		this.accType = accType;
		this.minBal = accType.getMinBal();
		this.accBal = accBal;
		this.accOpenDate = accOpenDate;
	}
	
	public BankAccount(Integer accNum) {
		this.accNum = accNum;
	}
	
	@Override
	public int compareTo(BankAccount obj) {
		return this.accNum.compareTo(obj.accNum);
	}
	
	@Override
	public String toString() {
		return "BankAccount [accNum=" + accNum + ", name=" + name + ", accType=" + accType + ", accBal=" + accBal
				+ ", accOpenDate=" + accOpenDate + "]";
	}
	
	public void withdrawMoney(Double money) throws CustomException{
		if(this.accBal-money>this.minBal) {
			this.accBal-=money;
			System.out.println(money+" Suscessfully withdrawn Available Balance : "+this.accBal);
		}
		else throw new CustomException("can't Withdraw! Minimum Account balance should be more than "+this.minBal);
	}

	public Integer getAccNum() {
		return accNum;
	}

	public LocalDate getAccOpenDate() {
		return accOpenDate;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof BankAccount)
			return this.accNum.equals(((BankAccount)obj).accNum);
		throw new InvalidObject("object passed is not instance of BankAccount");
	}

	public void depositMoney(Double money) {
		this.accBal+=money;
		System.out.println(money+" Suscessfully deposited Available Balance : "+this.accBal);
	}
	
	public Double getMinBal() {
		return minBal;
	}

	public Double getAccBal() {
		return accBal;
	}

	public void fundsTranfer(BankAccount receverAcc,Double money) throws CustomException{
		if(this.accBal-money>this.minBal) {
			receverAcc.accBal+=money;
			this.accBal-=money;
			System.out.println(money+" Suscessfully Transferd Available Balance : "+this.accBal);
		}
		else throw new CustomException("can't Transfer! Minimum Account balance should be more than "+this.minBal);		
	}
	
}
