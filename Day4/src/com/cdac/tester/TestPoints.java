package com.cdac.tester;
import java.util.Scanner;
import com.cdac.geometry.*;

public class TestPoints {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("Enter how many points you wanna enter : ");
			Point2D []points = new Point2D[sc.nextInt()];
			for(int i=0;i<points.length;i++) {
				System.out.print("Enter X and Y : ");
				points[i] = new Point2D(sc.nextInt(),sc.nextInt());
				
			}
			for(Point2D pnt:points)
				if(pnt!=null)
					System.out.println(pnt);
			System.out.println("Enter two indices you wanna compaire");
			Integer index1=sc.nextInt(),index2=sc.nextInt();
			System.out.println(points[index1].equals(points[index2])?"Both Points are same":points[index1].calculateDistance(points[index2]));
		}
	}

}
