package com.jsp.ManytoOneUnidirection.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.ManytoOneUnidirection.dta.Company;
import com.jsp.ManytoOneUnidirection.dta.Employee;

public class EmployeeDao {
	
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Omkarr");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;	
	}

	public void save(Employee employee)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	
	public void updateEmployee(int id,Employee employee)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Employee employee2=entityManager.find(Employee.class, id);
		
		if(employee2!=null)
		{
			employee.setId(id);
			employee.setCompany(employee2.getCompany());
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("employee is not present");
		}
	}
	
	public void deleteById(int id)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Employee employee=entityManager.find(Employee.class, id);
		
		if(employee!=null)
		{
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			System.out.println("Employee deleted Successfully");
		}
		else
		{
			System.out.println("Employee is not present");
		}
		
	}
	
}
