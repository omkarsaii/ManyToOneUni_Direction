package com.jsp.ManytoOneUnidirection.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.ManytoOneUnidirection.dta.Company;

public class CompanyDao {
	
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Omkarr");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void save(Company company)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	public void updateCompany(int id,Company company)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Company companydb=entityManager.find(Company.class, id);
		
		if(companydb!=null)
		{
			company.setId(id);
			entityTransaction.begin();
			entityManager.merge(company);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Company doesn't exist");
		}
		
	}
	
	public void DeleteById(int id)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Company company=entityManager.find(Company.class, id);
		
		if(company!=null)
		{ 
			entityTransaction.begin();
			entityManager.remove(company);
			entityTransaction.commit();
			System.out.println("Company deleted successfully");
		}
		else
		{
			System.out.println("Company doesnt exist");
		}
	}
}
