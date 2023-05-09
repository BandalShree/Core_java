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
			System.out.print("1. Add Mango\n"
					+ "2. Add Orange\n"
					+ "3. Add Apple\n"
					+ "4. Display names of all fruits in the basket\n"
					+ "5. Display name,color,weight,taste of all fresh fruits in the basket.\n"
					+ "6. Mark a fruit in a basket as stale(not fresh)\n"
					+ "7. Mark all sour fruits stale\n"
					+ "8. Invoke fruit specific functionality (pulp / juice / jam)\n"
					+ "9. exit\n"
					+ "ENter Choice : ");
			switch (sc.nextInt()) {
				case 1:		
					if(count<num) {
						System.out.println("Enter Colour, Weight and Is Fresh for Mango");
						fruit[count++] = new Mango(sc.next(),sc.nextDouble(),sc.nextBoolean());
						break;
					}
					else {
						System.out.println("Array Index Out of Bounds");
						isFalse = true;
					}
				case 2:	
					if(count<num) {
						System.out.println("Enter Colour, Weight and Is Fresh for Orange");
						fruit[count++] = new Orange(sc.next(),sc.nextDouble(),sc.nextBoolean());
						break;
					}
					else {
						System.out.println("Array Index Out of Bounds");
						isFalse = true;
					}
				case 3:		
					if(count<num) {
						System.out.println("Enter Colour, Weight and Is Fresh for Apple");
						fruit[count++] = new Apple(sc.next(),sc.nextDouble(),sc.nextBoolean());
						break;
					}
					else {
						System.out.println("Array Index Out of Bounds");
						isFalse = true;
					}
				case 4:		
					System.out.println("Names of Fruits in the Basket");
					for(Fruits f : fruit) if(f!=null) System.out.print(f.getName());
					break;
				case 5:
					for(Fruits f : fruit) if(f!=null) System.out.println("Name :"+f.getName()+" Colour :"+f.getColour()+" Weight :"+f.getWeight()+" Taste :"+f.taste());
					break;
				case 6:
					System.out.print("Enter fruit Index you wanna make stale : ");
					int idx = sc.nextInt();
					if(idx>0 && idx<=count) {
						fruit[idx].setIsFresh(false);
					}
					else {
						System.out.println("Please Enter valid Index");
						isFalse = true;
					}
					break;
				case 7:
					for(Fruits f : fruit) if((f.taste()).equals("sour")) f.setIsFresh(false);
					break;
				case 8:
					System.out.print("Enter fruit Index : ");
					int idx = sc.nextInt();
					if(idx>0 && idx<=count) {
						if((fruit[idx].getName()).equals("Apple")) fruit[idx].jam();
						else if((fruit[idx].getName()).equals("Mango")) fruit[idx].pulp();
						else fruit[idx].juice();
					}
					else {
						System.out.println("Please Enter valid Index");
						isFalse = true;
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
