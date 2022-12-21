package com.jbk.EmployeeCountryApplication.dao;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.EmployeeCountryApplication.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	
	@Override
	public Serializable addEmployee(Employee employee) {
		Employee emp=null;
		Serializable id=null;
		//Boolean b=false;
		try
		{
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("mobile_no", employee.getMobile_no()));
			emp=(Employee) criteria.uniqueResult();	
			System.out.println(emp);
			Transaction t=session.beginTransaction();
			if(emp==null)
			{
				id=session.save(employee);
				t.commit();
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return id;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		System.out.println("ram ram");
		Employee emp=null;
		try
		{
			session=sessionFactory.openSession();
			System.out.println("123");
			emp=session.get(Employee.class, id);
			System.out.println("1234");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empList=null;
		try
		{
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Employee.class);
			empList=criteria.list();
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		
		System.out.println(employee);
		Employee emp=null;
		Boolean b=false;
		try
		{
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("id", employee.getId()));
			emp=(Employee) criteria.uniqueResult();
			System.out.println(emp);
			Transaction t=session.beginTransaction();
			
			if(emp!=null)
			{
				System.out.println("11111111111111111111111");
				session.merge(employee);
				System.out.println("222222222222222222222222");
				t.commit();
				b=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return b;
	}

	@Override
	public Boolean deleteEmployee(Integer id) {
		Boolean b=false;
		Employee emp=null;
		try
		{
			session=sessionFactory.openSession();
			emp=session.get(Employee.class, id);
			Transaction t=session.beginTransaction();
			
			if(emp!=null)
			{
				session.delete(emp);
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
