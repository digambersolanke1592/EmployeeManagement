package com.jbk.EmployeeCountryApplication.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.EmployeeCountryApplication.dao.CountryDao;
import com.jbk.EmployeeCountryApplication.entity.Country;

@Service
public class CountryService_IMPL implements CountryService {

	@Autowired
	CountryDao countrydao;
	
	

	@Override
	public Country getCountryById(Integer id) {
		// TODO Auto-generated method stub
		return countrydao.getCountryById(id);
	}

	@Override
	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		return countrydao.getAllCountry();
	}

	@Override
	public Boolean updateCountry(Country country) {
		// TODO Auto-generated method stub
		
		return countrydao.updateCountry(country);
	}

	@Override
	public Boolean deleteCountry(Integer id) {
		// TODO Auto-generated method stub
		return countrydao.deleteCountry(id);
	}

}
