package com.app.tester;
import com.java.fruits.*;
import java.util.Scanner;

public class FruitBasket {
	public static void main(String[] args) {
		boolean isFalse=false;
		System.out.print("Enter Basket Size : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(),count = 0;
		Fruits []fruit = new Fruits[num];
		while(!isFalse) {
			System.out.print("\n1. Add Mango\n"
					+ "2. Add Orange\n"
					+ "3. Add Apple\n"
					+ "4. Display names of all fruits in the basket\n"
					+ "5. Display name,color,weight,taste of all fresh fruits in the basket.\n"
					+ "6. Mark a fruit in a basket as stale(not fresh)\n"
					+ "7. Mark all sour fruits stale\n"
					+ "8. Invoke fruit specific functionality (pulp / juice / jam)\n"
					+ "9. exit\n"
					+ "Enter Choice : ");
			switch (sc.nextInt()) {
				case 1:		
					if(count<num) {
						System.out.println("Enter Colour, Weight and Is Fresh for Mango");
						fruit[count++] = new Mango(sc.next(),sc.nextDouble(),sc.nextBoolean());
						if(fruit[count-1].getIsFresh()==false) count--;
					}
					else {
						System.out.println("Array Index Out of Bounds");
						isFalse = true;
					}
					break;
				case 2:	
					if(count<num) {
						System.out.println("Enter Colour, Weight and Is Fresh for Orange");
						fruit[count++] = new Orange(sc.next(),sc.nextDouble(),sc.nextBoolean());
						if(fruit[count-1].getIsFresh()==false) count--;
					}
					else {
						System.out.println("Array Index Out of Bounds");
						isFalse = true;
					}
					break;
				case 3:		
					if(count<num) {
						System.out.println("Enter Colour, Weight and Is Fresh for Apple");
						fruit[count++] = new Apple(sc.next(),sc.nextDouble(),sc.nextBoolean());
						if(fruit[count-1].getIsFresh()==false) count--;
					}
					else {
						System.out.println("Array Index Out of Bounds");
						isFalse = true;
					}
					break;
				case 4:		
					System.out.println("Names of Fruits in the Basket");
					for(Fruits f : fruit) if(f!=null) System.out.print(f.getName()+" ");
					System.out.println();
					break;
				case 5:
					for(Fruits f : fruit) if(f!=null && f.getIsFresh()) System.out.println(f+" Taste= "+f.taste());
					break;
				case 6:
					System.out.print("Enter fruit Index you wanna make stale : ");
					int idx = sc.nextInt();
					if(idx>0 && idx<=count) {
						fruit[idx-1].setIsFresh(false);
					}
					else {
						System.out.println("Please Enter valid Index");
					}
					break;
				case 7:
					for(Fruits f : fruit) if(f!=null && (f.taste()).equals("sour")) f.setIsFresh(false);
					break;
				case 8:
					System.out.print("Enter fruit Index : ");
					int id = sc.nextInt();
					if(id>0 && id<=count) {
						if((fruit[id].getName()).equals("Apple")) ((Apple)fruit[id]).jam();
						else if((fruit[id].getName()).equals("Mango")) ((Mango)fruit[id]).pulp();
						else ((Orange)fruit[id]).juice();
					}
					else {
						System.out.println("Please Enter valid Index");
					}
					break;
				case 9:
					System.out.println("Thank You!!!");
					isFalse = true;
					break;
				default:
					System.out.println("Please Enter Valid Choice");
					break;
			}
		}
	}
}
