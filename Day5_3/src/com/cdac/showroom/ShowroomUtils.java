package com.cdac.showroom;

import java.time.LocalDate;
import java.util.*;

import com.cdac.showroom.ShowroomManagement.Colours;

public class ShowroomUtils {
	public static List<ShowroomManagement> populateList() {
		ArrayList <ShowroomManagement>showRmMang = new ArrayList<>();
		showRmMang.add(new ShowroomManagement("1",Colours.BLACK,230000.0,LocalDate.parse("2023-01-10"),"TATA"));
		showRmMang.add(new ShowroomManagement("3",Colours.WHITE,530000.0,LocalDate.parse("2023-02-11"),"TATA"));
		showRmMang.add(new ShowroomManagement("5",Colours.BLUE,300000.0,LocalDate.parse("2023-04-10"),"TATA"));
		showRmMang.add(new ShowroomManagement("7",Colours.BLUE,370000.0,LocalDate.parse("2023-04-10"),"TATA"));
		showRmMang.add(new ShowroomManagement("8",Colours.WHITE,301000.0,LocalDate.parse("2015-04-10"),"TATA"));
		showRmMang.add(new ShowroomManagement("2",Colours.RED,930000.0,LocalDate.parse("2023-12-10"),"TATA"));
		showRmMang.add(new ShowroomManagement("4",Colours.BLACK,340000.0,LocalDate.parse("2023-03-10"),"TATA"));
		showRmMang.add(new ShowroomManagement("6",Colours.RED,293000.0,LocalDate.parse("2023-04-10"),"TATA"));;
		showRmMang.add(new ShowroomManagement("9",Colours.BLACK,390000.0,LocalDate.parse("2023-07-20"),"TATA"));
		showRmMang.add(new ShowroomManagement("10",Colours.BLACK,400000.0,LocalDate.parse("2023-04-10"),"TATA"));
		return showRmMang;
	}
}
