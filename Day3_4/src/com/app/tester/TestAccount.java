package com.app.tester;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import com.app.banking.*;
import com.app.banking.BankAccount.AccountType;

public class TestAccount {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			HashMap <Integer,BankAccount> accounts = BankAccUtils.populateMap();
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
							+ "9. Shuffle the list\n"
							+ "10. Reverse the list\n"
							+ "0. Exit\n"
							+ "Enter Option : ");
					switch (sc.nextInt()) {
						case 1:
							System.out.println("Enter Account Number, Customer Name, Account Type, Account Balance, Account Opening Date(yyyy-mm-dd)");
							BankAccount acc = new BankAccount(sc.nextInt(),sc.next(),AccountType.valueOf(sc.next().toUpperCase()),sc.nextDouble(),LocalDate.parse(sc.next()));
							if(accounts.containsKey(acc.getAccNum())) throw new CustomException("Account Number is alredy in DataBase");
							if(acc.getAccBal()<acc.getMinBal()) throw new CustomException("Minimum Account Balance should be "+acc.getMinBal());
							accounts.put(acc.getAccNum(),acc);
							break;
						case 2:
							accounts.forEach((k,v) -> System.out.println(v));
							break;
						case 3:
							System.out.print("Enter Account Number : ");
							Integer accNum = sc.nextInt();
							if(! accounts.containsKey(accNum)) throw new CustomException("Account Number is not in DataBase");
							System.out.print("Enter Withdraw Money : ");
							accounts.get(accNum).withdrawMoney(sc.nextDouble());							
							break;
						case 4:
							System.out.print("Enter Account Number : ");
							accNum = sc.nextInt();
							if(! accounts.containsKey(accNum)) throw new CustomException("Account Number is not in DataBase");
							System.out.print("Enter Deposit Money : ");
							accounts.get(accNum).depositMoney(sc.nextDouble());	
							break;
						case 5:
							System.out.print("Enter Sender Account Number : ");
							accNum = sc.nextInt();
							if(! accounts.containsKey(accNum)) throw new CustomException("Senders Account Number is not in DataBase");
							System.out.print("Enter Receivers Account Number : ");
							Integer anotherAccNum = sc.nextInt();
							if(! accounts.containsKey(anotherAccNum)) throw new CustomException("Receivers Account Number is not in DataBase");
							System.out.print("Enter Deposit Money : ");
							accounts.get(accNum).fundsTranfer(accounts.get(anotherAccNum),sc.nextDouble());
							break;
						case 6:
							TreeMap <Integer,BankAccount> sortedAccounts = new TreeMap<>(accounts);
							sortedAccounts.forEach((k,v) -> System.out.println(v));
							break;
						case 7:
							List <BankAccount> listAccounts = new ArrayList<>(accounts.values());
							Collections.sort(listAccounts,(acc1,acc2) -> acc1.getAccOpenDate().compareTo(acc2.getAccOpenDate()));
							GenericUtils.printGenericElements(listAccounts);
							break;
						case 8:
							listAccounts = new ArrayList<>(accounts.values());
							Collections.sort(listAccounts,(acc1,acc2) ->  acc1.getAccBal().compareTo(acc2.getAccBal()));
							GenericUtils.printGenericElements(listAccounts);
							break;
						case 9:
							listAccounts = new ArrayList<>(accounts.values());
							Collections.shuffle(listAccounts);
							GenericUtils.printGenericElements(listAccounts);
							break;
						case 10:
							listAccounts = new ArrayList<>(accounts.values());
							Collections.reverse(listAccounts);
							GenericUtils.printGenericElements(listAccounts);
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
