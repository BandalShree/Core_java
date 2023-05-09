package com.app.tester;
import java.time.LocalDate;
import java.util.Scanner;
import com.app.banking.*;

public class TestAccount {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter Account Number, Customer Name, Account Type, Account Balance, Account Opening Date(yyyy-mm-dd)");
			BankAccount acc1 = new BankAccount(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble(),LocalDate.parse(sc.next()));
			System.out.println("Enter Account Number, Customer Name, Account Type, Account Balance, Account Opening Date(yyyy-mm-dd)");
			BankAccount acc2 = new BankAccount(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble(),LocalDate.parse(sc.next()));
			
			Boolean isFalse=false;
			Integer accNum;
			while(!isFalse) {
				try {
					System.out.println("\n1. Display Users Account Summary\n"
							+ "2. Withdraw Money\n"
							+ "3. Deposit Money\n"
							+ "4. Fund Transfer\n"
							+ "5. Exit");
					switch (sc.nextInt()) {
						case 1:
							System.out.println("1st User : "+acc1);
							System.out.println("2nd User : "+acc2);
							break;
						case 2:
							System.out.println("Enter Account Number");
							accNum = sc.nextInt();
							System.out.println("Enter Withdraw Money");
							if(acc1.getAccNum().equals(accNum)) acc1.withdrawMoney(sc.nextDouble());
							else if(acc2.getAccNum().equals(accNum)) acc2.withdrawMoney(sc.nextDouble());
							else throw new CustomException("Account Number didn't found!");
							break;
						case 3:
							System.out.println("Enter Account Number");
							accNum = sc.nextInt();
							System.out.println("Enter Deposit Money");
							if(acc1.getAccNum().equals(accNum)) acc1.depositMoney(sc.nextDouble());
							else if(acc2.getAccNum().equals(accNum)) acc2.depositMoney(sc.nextDouble());
							else throw new CustomException("Account Number didn't found!");
							break;
						case 4:
							System.out.println("Enter Sender Account Number");
							accNum = sc.nextInt();
							System.out.println("Enter Deposit Money");
							if(acc1.getAccNum().equals(accNum)) acc1.fundsTranfer(acc2,sc.nextDouble());
							else if(acc2.getAccNum().equals(accNum)) acc2.fundsTranfer(acc1,sc.nextDouble());
							else throw new CustomException("Account Number didn't found!");
							break;
						case 5:
							isFalse=true;
							break;
						default:
							System.out.println("Please Select Valid Option");
							break;
					}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
