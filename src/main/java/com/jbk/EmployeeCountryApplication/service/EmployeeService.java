package com.jbk.EmployeeCountryApplication.service;

import java.io.Serializable;
import java.util.List;

import com.jbk.EmployeeCountryApplication.entity.Employee;

public interface EmployeeService {

	Serializable addEmployee(Employee employee);

	Employee getEmployeeById(Integer id);

	List<Employee> getAllEmployee();

	Boolean updateEmployee(Employee employee);

	Boolean deleteEmployee(Integer id);

}
