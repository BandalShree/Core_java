package com.java.tester;
import com.cdac.showroom.*;
import com.cdac.showroom.ShowroomManagement.Colours;

import java.time.LocalDate;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("Enter how many vehicles you wanna add : ");
			ShowroomManagement []showRmMang = new ShowroomManagement[sc.nextInt()];
			Boolean isFalse = false;
			Integer counter = 0;
			while(!isFalse) {
				try {
					System.out.print("\n1. Add Vehicle to the showroom.\n"
							+ "2. Display all vehicle details\n"
							+ "3. Exit\n"
							+ "Choose one Option : ");
					switch(sc.nextInt()) {
					case 1: 
						System.out.println("Enter uniqueID, color, basePrice, manufactureDate(yyyy-mm-dd), company");
						showRmMang[counter++] = new ShowroomManagement(sc.next(),Colours.valueOf(sc.next().toUpperCase()),sc.nextDouble(),LocalDate.parse(sc.next()),sc.next());
						for(Integer i=0;i<counter-1;i++) 
							if(showRmMang[i].equals(showRmMang[counter-1])) 
								throw new CustomException("No dup vehicles should be added in the showroom");
						if(!showRmMang[counter-1].getManufactureDate().isAfter(LocalDate.of(LocalDate.now().getYear(), 01, 01)))
							throw new CustomException("manufactureDate : must be in current year onwards");
//						Colours []colours = Colours.values();
//						Colours colour=showRmMang[counter-1].getColour();
//						for(Integer i=0;i<colours.length;i++)
//							if(colours[i]==colour) break;
//							else if(i+1==colours.length) throw new CustomException("Vehicle color must be valid");
						break;
					case 2:
						for(ShowroomManagement showRmMangMnt:showRmMang)
							if(showRmMangMnt!=null)
								System.out.println(showRmMangMnt);
						break;
					case 3: 
						isFalse = true;
						break;
					default:
						System.out.println("Please Select Valid Option");
					}
				}
				catch(Exception exc) {
					showRmMang[--counter] = null;
					System.out.println(exc.getMessage());
//					sc.next();
				}
			}
		}
	}

}
