package com.app.tester;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import com.app.banking.*;
import com.app.banking.BankAccount.AccountType;

public class TestAccount {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			List <BankAccount> accounts = BankAccUtils.populateList();
			Boolean isFalse=false;
			
			while(!isFalse) {
				try {
					System.out.print("\n1. Enter Account Details\n"
							+ "2. Display Users Account Summary\n"
							+ "3. Withdraw Money\n"
							+ "4. Deposit Money\n"
							+ "5. Fund Transfer\n"
							+ "6. Sort the accounts as per acct nos\n"
							+ "7. Sort the accounts as per acct creation date\n"
							+ "8. Sort the accounts as per acct balance\n"
							+ "0. Exit\n"
							+ "Enter Option : ");
					switch (sc.nextInt()) {
						case 1:
							System.out.println("Enter Account Number, Customer Name, Account Type, Account Balance, Account Opening Date(yyyy-mm-dd)");
							BankAccount acc = new BankAccount(sc.nextInt(),sc.next(),AccountType.valueOf(sc.next().toUpperCase()),sc.nextDouble(),LocalDate.parse(sc.next()));
							if(accounts.contains(acc)) throw new CustomException("Account Number is alredy in DataBase");
							if(acc.getAccBal()<acc.getMinBal()) throw new CustomException("Minimum Account Balance should be "+acc.getMinBal());
							accounts.add(acc);
							break;
						case 2:
							for(BankAccount bankAcc : accounts)
								System.out.println(bankAcc);
							break;
						case 3:
							System.out.print("Enter Account Number : ");
							acc = new BankAccount(sc.nextInt());
							if(! accounts.contains(acc)) throw new CustomException("Account Number is not in DataBase");
							System.out.print("Enter Withdraw Money : ");
							accounts.get(accounts.indexOf(acc)).withdrawMoney(sc.nextDouble());							
							break;
						case 4:
							System.out.print("Enter Account Number : ");
							acc = new BankAccount(sc.nextInt());
							if(! accounts.contains(acc)) throw new CustomException("Account Number is not in DataBase");
							System.out.print("Enter Deposit Money : ");
							accounts.get(accounts.indexOf(acc)).depositMoney(sc.nextDouble());	
							break;
						case 5:
							System.out.print("Enter Sender Account Number : ");
							acc = new BankAccount(sc.nextInt());
							if(! accounts.contains(acc)) throw new CustomException("Senders Account Number is not in DataBase");
							System.out.print("Enter Receivers Account Number : ");
							BankAccount anotherAcc = new BankAccount(sc.nextInt());
							if(! accounts.contains(anotherAcc)) throw new CustomException("Receivers Account Number is not in DataBase");
							System.out.print("Enter Deposit Money : ");
							accounts.get(accounts.indexOf(acc)).fundsTranfer(accounts.get(accounts.indexOf(anotherAcc)),sc.nextDouble());
							break;
						case 6:
							Collections.sort(accounts);
							break;
						case 7:
							Collections.sort(accounts,new AccCreationDate());
							break;
						case 8:
							Collections.sort(accounts,new Comparator<BankAccount>() {
								@Override
								public int compare(BankAccount acc1,BankAccount acc2) {
									return acc1.getAccBal().compareTo(acc2.getAccBal());
								}
							});
							break;
						case 0:
							isFalse=true;
							break;
						default:
							System.out.println("Please Select Valid Option");
							break;
					}
				}
				catch(CustomException e) {
					System.out.println(e.getMessage());
				}
				catch(DateTimeParseException e) {
					System.out.println(e.getMessage());
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
					sc.next();
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
