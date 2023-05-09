package com.app.banking;

import java.util.*;

public class GenericUtils {
	public static void printGenericElements(Collection <?> c){
		for(Object obj:c)
			System.out.println(obj);
	}
}
