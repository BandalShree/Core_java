package com.java.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface CollectionMod {
	static Map<Short,Cricketer> populate(){
		Map<Short,Cricketer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter name, age, email, phone, rating");
			Cricketer obj =  new Cricketer(sc.next(),sc.nextShort(),sc.next(),sc.nextLong(),sc.nextShort());
			map.put(obj.getCricketerId(), obj);
		}
		return map;
	}
}
