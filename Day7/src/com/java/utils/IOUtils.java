package com.java.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.java.product.Product;

public interface IOUtils {
	static void writeData(Map<Integer, Product> mapEmp,String fileName){
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(mapEmp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	static HashMap<Integer, Product> readData(String fileName) throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		return (HashMap<Integer, Product>)ois.readObject();
	}
}
