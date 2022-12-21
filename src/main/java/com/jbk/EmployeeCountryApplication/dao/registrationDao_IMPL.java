package com.jbk.EmployeeCountryApplication.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.EmployeeCountryApplication.entity.registrationAdmin;

@Repository
public class registrationDao_IMPL implements registrationDao {

	@Autowired
	SessionFactory sessionFactory;
	//Session session;
	
	@SuppressWarnings("deprecation")
	@Override
	public registrationAdmin loginCheck(registrationAdmin reg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		registrationAdmin ra=null;
		try {
			Criteria criteria = session.createCriteria(registrationAdmin.class);
			Criterion username = Restrictions.eq("email", reg.getEmail());
			Criterion password = Restrictions.eq("password", reg.getPassword());
			criteria.add(Restrictions.and(username, password));

			ra = (registrationAdmin) criteria.uniqueResult();
System.out.println(ra);
		} catch (Exception e) {
			System.out.println(ra);
			System.out.println("i am in null");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ra;
		
		
	}

}
