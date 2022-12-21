package com.jbk.EmployeeCountryApplication.dao;

import java.io.Serializable;
import java.util.List;

import com.jbk.EmployeeCountryApplication.entity.Country;
import com.jbk.EmployeeCountryApplication.entity.Employee;

public interface CountryDao {

    
	
	Country getCountryById(Integer id);
	
	List<Country> getAllCountry();
	
	Boolean updateCountry(Country country);
	
	Boolean deleteCountry(Integer id);
	
	
}
