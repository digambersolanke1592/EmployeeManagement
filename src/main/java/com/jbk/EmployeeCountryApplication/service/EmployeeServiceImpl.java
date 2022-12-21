 package com.jbk.EmployeeCountryApplication.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.EmployeeCountryApplication.dao.EmployeeDao;
import com.jbk.EmployeeCountryApplication.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	
	@Override
	public Serializable addEmployee(Employee employee) {
		//String id=employee.getName()+employee.getMobile_no();
		
		LocalDate currentDate=LocalDate.now();
		LocalTime currentTime=LocalTime.now();
		LocalDateTime currentDateTime=LocalDateTime.of(currentDate, currentTime);
		
		//employee.setId(id);
		employee.setCreated_date(currentDateTime);
		employee.setUpdated_date(currentDateTime);
		
		return employeeDao.addEmployee(employee);
	}


	@Override
	public Employee getEmployeeById(Integer id) {
		
		System.out.println("service");
		return employeeDao.getEmployeeById(id);
	}


	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		return employeeDao.getAllEmployee();
	}


	@Override
	public Boolean updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}


	@Override
	public Boolean deleteEmployee(Integer id) {
		return employeeDao.deleteEmployee(id);
	}

}
