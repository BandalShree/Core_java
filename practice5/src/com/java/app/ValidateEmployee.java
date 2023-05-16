package com.java.app;

import java.util.Map;

public interface ValidateEmployee {

	@SuppressWarnings("static-access")
	static void validateEmp(Map<Short,Employee> employees,Employee emp) throws CustomException {
		if (emp.getAdharNum().toString().length() != 12 || !emp.getAdharNum().toString().matches("^[0-9]*$"))
			throw new CustomException("Enter Valid Adhar number");
		else if (emp.getPhoneNum().toString().length() != 10 || !emp.getPhoneNum().toString().matches("^[0-9]*$"))
			throw new CustomException("Enter Valid Phone number");
		else if(employees.containsValue(emp))
			throw new CustomException("Adhar number or Phone number Alredy exist");
	}

}
