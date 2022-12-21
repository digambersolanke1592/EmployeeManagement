package com.jbk.EmployeeCountryApplication.dao;


import java.io.Serializable;
import java.util.List;

import com.jbk.EmployeeCountryApplication.entity.Employee;


public interface EmployeeDao {

	Serializable addEmployee(Employee employee);
	
	Employee getEmployeeById(Integer id);
	
	List<Employee> getAllEmployee();
	
	Boolean updateEmployee(Employee employee);
	
	Boolean deleteEmployee(Integer id);
	
	
}
