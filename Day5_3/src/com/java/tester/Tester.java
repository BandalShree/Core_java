package com.java.tester;
import com.cdac.showroom.*;


import com.cdac.showroom.ShowroomManagement.Colours;

import java.time.LocalDate;
import java.util.*;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			List <ShowroomManagement>showRmMang = ShowroomUtils.populateList();
			Boolean isFalse = false;
			while(!isFalse) {
				try {
					System.out.print("\n1. Add Vehicle to the showroom.\n"
							+ "2. Display all vehicle details\n"
							+ "3. get specific vehicle details\n"
							+ "4. Apply Disocunt\n"
							+ "5. Remove specific vehicle details\n"
							+ "6. Sort the vehicles by Id\n"
							+ "7. Sort by vehicles by Price\n"
							+ "8. Sort by vehicles by Date\n"
							+ "9. Sort by vehicles by Price first then Date\n"
							+ "10. Remove all vehicle details by a specific color\n"
							+ "0. Exit\n"
							+ "Choose one Option : ");
					switch(sc.nextInt()) {
					case 1: 
						System.out.println("Enter uniqueID, color, basePrice, manufactureDate(yyyy-mm-dd), company");
						ShowroomManagement obj = new ShowroomManagement(sc.next(),Colours.valueOf(sc.next().toUpperCase()),sc.nextDouble(),LocalDate.parse(sc.next()),sc.next());
						if(showRmMang.contains(obj))
							throw new CustomException("No dup vehicles should be added in the showroom");
						if(!obj.getManufactureDate().isAfter(LocalDate.of(LocalDate.now().getYear(), 01, 01)))
							throw new CustomException("manufactureDate : must be in current year onwards");
						showRmMang.add(obj);
						System.out.println("Vehicle Suscessfully added!");
						break;
					case 2:
						for(ShowroomManagement showRmMangMnt:showRmMang)
							System.out.println(showRmMangMnt);
						break;
					case 3: 
						System.out.print("Enter the Charsi Number : ");
						Integer idx = showRmMang.indexOf(new ShowroomManagement(sc.next()));
						if(idx==-1) throw new CustomException("Vehicle is not in the Showroom");
						System.out.println(showRmMang.get(idx));
						break;
					case 4:
						for(ShowroomManagement showRmMangMnt:showRmMang)
							if(showRmMangMnt.getManufactureDate().isBefore(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()))) //discount on vehicles before today
								showRmMangMnt.setBasePrice();
						break;
					case 5:
						System.out.print("Enter the Charsi Number : ");
						idx = showRmMang.indexOf(new ShowroomManagement(sc.next()));
						if(idx==-1) throw new CustomException("Vehicle is not in the Showroom");
						System.out.println(showRmMang.remove((int)idx)+" Sucsessfully Removed");
						break;
					case 6:
						Collections.sort(showRmMang);
						break;
					case 7:
						Collections.sort(showRmMang,new Comparator<ShowroomManagement>() {
							@Override
							public int compare(ShowroomManagement sm1, ShowroomManagement sm2) {
								return sm1.getBasePrice().compareTo(sm2.getBasePrice());
							}
						});
						break;
					case 8:
						Collections.sort(showRmMang,new Comparator<ShowroomManagement>() {
							@Override
							public int compare(ShowroomManagement sm1, ShowroomManagement sm2) {
								return sm1.getManufactureDate().compareTo(sm2.getManufactureDate());
							}
						});
						break;
					case 9:
						Collections.sort(showRmMang,new Comparator<ShowroomManagement>() {
							@Override
							public int compare(ShowroomManagement sm1, ShowroomManagement sm2) {
								if(sm1.getBasePrice().compareTo(sm2.getBasePrice())!=0)
									return sm1.getBasePrice().compareTo(sm2.getBasePrice());
								else
									return sm1.getManufactureDate().compareTo(sm2.getManufactureDate());
							}
						});
						break;
					case 10:
						System.out.print("Enter Colour Name : ");
						Colours colour = Colours.valueOf(sc.next().toUpperCase());
						Iterator <ShowroomManagement> itr = showRmMang.iterator();
						while(itr.hasNext()) 
							if(itr.next().getColour().equals(colour))
								itr.remove();
						break;
					case 0:
						isFalse = true;
						break;
					default:
						System.out.println("Please Select Valid Option");
					}
				}
				catch(Exception exc) {
					System.out.println(exc.getMessage());
				}
			}
		}
	}

}
