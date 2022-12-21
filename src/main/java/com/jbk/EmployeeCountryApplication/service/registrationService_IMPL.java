package com.jbk.EmployeeCountryApplication.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.EmployeeCountryApplication.dao.registrationDao;
import com.jbk.EmployeeCountryApplication.entity.registrationAdmin;

@Service
public class registrationService_IMPL implements registrationService {

	@Autowired
	registrationDao regDao;
	
	@Override
	public HashMap loginCheck(registrationAdmin reg) {
		// TODO Auto-generated method stub
		
		registrationAdmin  ra = regDao.loginCheck(reg);
		
		HashMap map = new HashMap();
		
		if(ra == null) {
			map.put("msg", "invalid user");
		}
		
		else {
			map.put("msg","valid user");
		}
		
		   map.put("user", ra);
		
	   return map;
			
	}

	
}
