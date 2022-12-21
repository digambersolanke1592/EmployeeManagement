package com.jbk.EmployeeCountryApplication.service;

import java.io.Serializable;
import java.util.List;

import com.jbk.EmployeeCountryApplication.entity.Country;

public interface CountryService {
	  
	   
		
		Country getCountryById(Integer id);
		
		List<Country> getAllCountry();
		
		Boolean updateCountry(Country country);
		
		Boolean deleteCountry(Integer id);
		
}
