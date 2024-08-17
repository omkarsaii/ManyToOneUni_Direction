package com.jsp.ManytoOneUnidirection;

import com.jsp.ManytoOneUnidirection.dao.CompanyDao;
import com.jsp.ManytoOneUnidirection.dao.EmployeeDao;
import com.jsp.ManytoOneUnidirection.dta.Company;
import com.jsp.ManytoOneUnidirection.dta.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	
       EmployeeDao employeedao=new EmployeeDao();
       CompanyDao companydao=new CompanyDao();
       
//       Employee e1=new Employee();
//       e1.setName("Krishna");
//       e1.setEmail("Krishna@gmail.com");
//       e1.setPassword("123");
//       
//       Employee e2=new Employee();
//       e2.setName("Ram");
//       e2.setEmail("ram@gmail.com");
//       e2.setPassword("456"); 
//       
//       Company company=new Company();
//       company.setCname("TCS");
//       company.setAddress("Bangalore");
//       
//       e1.setCompany(company);
//       e2.setCompany(company);
//       
//       companydao.save(company);
//       employeedao.save(e1);
//       employeedao.save(e2);'
       
       Employee employee=new Employee();
       employee.setName("Krishna Radha");
       employee.setEmail("KrishnaR@gmail.com");
       employee.setPassword("1232");
       
       employeedao.updateEmployee(1, employee);
       
    }
}
