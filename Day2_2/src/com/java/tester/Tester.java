package com.java.tester;
import java.util.Scanner;
import com.java.stack.*;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isFalse=false;
		byte isChose=0;
		Stack st = null;
		try(Scanner sc = new Scanner(System.in)){
			while(!isFalse) {
				System.out.print("\n1 -- Choose Fixed Stack\n"
						+"2 -- Choose Growable Stack\n"
						+"3 -- Push data\n"
						+"4 --- Pop data & display\n"
						+"5 -- Exit\n"
						+"Enter the Option : ");
				int key = sc.nextInt();
				switch (key) {
					case 1: 
						if(isChose==1) System.out.println("You Alredy Chosen Fixed Stack");
						else if(isChose==2) System.out.println("You Alredy Chosen Growable Stack"); 
						else { System.out.println("You have Chosen Fixed Stack"); isChose=1; st = new FixedStack();}
						break;
					case 2:
						if(isChose==1) System.out.println("You Alredy Chosen Fixed Stack");
						else if(isChose==2) System.out.println("You Alredy Chosen Growable Stack"); 
						else { System.out.println("You have Chosen Growable Stack"); isChose=2; st = new GrowableStack();};
						break;
					case 3:
						if(st!=null) {
							System.out.print("Enter Id, Name of Customer1, Item Name : ");
							st.push(new Customer(sc.nextInt(),sc.next(),sc.next()));
						}
						else System.out.println("NO stack chosen !!!");
						break;
					case 4:
						if(st!=null) {
							System.out.println(st.pop());
						}
						else System.out.println("NO stack chosen !!!");
						break;
					case 5:
						System.out.println("Thanks!!!");
						isFalse=true;
						break;
					default:
						System.out.println("please select only from given options...");
						break;
				}
			}
		}
		catch(Exception e) {
//			System.out.println(e);
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
