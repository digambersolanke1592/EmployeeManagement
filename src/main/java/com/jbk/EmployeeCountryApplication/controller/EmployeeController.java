package com.jbk.EmployeeCountryApplication.controller;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.EmployeeCountryApplication.entity.Country;
import com.jbk.EmployeeCountryApplication.entity.Employee;
import com.jbk.EmployeeCountryApplication.entity.registrationAdmin;
import com.jbk.EmployeeCountryApplication.service.CountryService;
import com.jbk.EmployeeCountryApplication.service.EmployeeService;
import com.jbk.EmployeeCountryApplication.service.registrationService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	registrationService regService;
	

	@PostMapping(value = "addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		Serializable s = employeeService.addEmployee(employee);

		if (s!=null) {
			return new ResponseEntity<String>("Employee Added !!!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Employee Not Added !!!", HttpStatus.CONFLICT);
		}

	}

	@GetMapping(value = "getEmployeeById/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable Integer id) {
		
		Employee employee = employeeService.getEmployeeById(id);

		if (employee != null) {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Employee Does Not Exist !!!", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "getAllEmployee")
	public ResponseEntity<Object> getAllEmployee() {
		List<Employee> empList = employeeService.getAllEmployee();
		if (!empList.isEmpty()) {
			return new ResponseEntity<>(empList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Employees Not Found", HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(value = "updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		Boolean b = employeeService.updateEmployee(employee);

		if (b = true) {
			return new ResponseEntity<>("Employee Updated !!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Employee Not Found !!!", HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		Boolean b = employeeService.deleteEmployee(id);

		if (b) {
			return new ResponseEntity<>("Employee Deleted !!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Employee Not Found !!!", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "getCountryById/{id}")
	public ResponseEntity<Object> getCountryById(@PathVariable Integer id) {
		Country country = countryService.getCountryById(id);

		if (country != null) {
			return new ResponseEntity<>(country, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Country Does Not Exist !!!", HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping(value = "getAllCountry")
	public ResponseEntity<Object> getAllCountry() {
		List<Country> cntList = countryService.getAllCountry();
		if (!cntList.isEmpty()) {
			return new ResponseEntity<>(cntList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Country Not Found", HttpStatus.NOT_FOUND);
		}

	}
	
	@PutMapping(value = "updateCountry")
	public ResponseEntity<String> updateCountry(@RequestBody Country country) {
		Boolean b = countryService.updateCountry(country);

		if (b = true) {
			return new ResponseEntity<>("Country Updated !!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Country Not Found !!!", HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "deleteCountry/{id}")
	public ResponseEntity<String> deleteCountry(@PathVariable Integer id) {
		Boolean b = countryService.deleteCountry(id);

		if (b) {
			return new ResponseEntity<>("Country Deleted !!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Country Not Found !!!", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("logincheck")
	public HashMap loginCheck(@RequestBody registrationAdmin reg ) {
	
		HashMap  ra = regService.loginCheck(reg);
	System.out.println(ra);
	
	
	if (ra != null) {
		
		
		return ra;
	}
	else {
		
		return null;
	}
	
	
	}
}
