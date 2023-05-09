package com.java.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.java.employee.Employee;

public interface IOUtils {
	static void writeData(Map<Integer, Employee> mapEmp,String fileName) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
		oos.writeObject(mapEmp);
	}
	@SuppressWarnings("unchecked")
	static HashMap<Integer, Employee> readData(String fileName) throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		return (HashMap<Integer, Employee>)ois.readObject();
	}
}
