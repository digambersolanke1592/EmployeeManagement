package com.jbk.EmployeeCountryApplication.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.EmployeeCountryApplication.entity.Country;
import com.jbk.EmployeeCountryApplication.entity.Employee;

@Repository
public class CountryDao_IMPL implements CountryDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	
	
	

	@Override
	public Country getCountryById(Integer id) {
		// TODO Auto-generated method stub
		Country cnt=null;
		try
		{
			session=sessionFactory.openSession();
			cnt=session.get(Country.class, id);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		
		List<Country> cntList=null;
		try
		{
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Country.class);
			cntList=criteria.list();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return cntList;
	}

	@Override
	public Boolean updateCountry(Country country) {
		// TODO Auto-generated method stub
		Country cnt=null;
		Boolean b=false;
		try
		{
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Country.class);
			criteria.add(Restrictions.eq("id", country.getCid()));
			cnt=(Country) criteria.uniqueResult();
			System.out.println(cnt);
			Transaction t=session.beginTransaction();
			
			if(cnt!=null)
			{
				//System.out.println("11111111111111111111111");
				session.merge(country);
			//	System.out.println("222222222222222222222222");
				t.commit();
				b=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Boolean deleteCountry(Integer id) {
		// TODO Auto-generated method stub
		Boolean b=false;
		Country cnt=null;
		try
		{
			session=sessionFactory.openSession();
			cnt=session.get(Country.class, id);
			Transaction t=session.beginTransaction();
			
			if(cnt!=null)
			{
				session.delete(cnt);
				t.commit();
				b=true;
			}
			
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return b;
	}
	}


