package com.java.validations;

import java.util.Map;

import com.java.employee.Employee;
import com.java.exception.CustomException;

public interface Validations {
	static void isUniqEmpId(Integer empId, Map<Integer, Employee> mapEmp) throws CustomException {
		if (mapEmp.containsKey(empId))
			throw new CustomException("Employee alredy Registerd");
	}

	static void isValidEmpSal(Employee emp) throws CustomException {
		if (emp.getSalary() < emp.getPosition().minSalary)
			throw new CustomException(
					emp.getPosition().toString() + " salary must be greater than " + emp.getPosition().minSalary);
	}
}
