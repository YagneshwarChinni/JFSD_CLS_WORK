package com.klu;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;

public class EmployeeHQL {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFacory(); 
		System.out.println(sf);
		
		/*
		 * Configuration cfg = new Configuration(); cfg.configure();
		 * //cfg.configure(aashi.xml);-> to change the name of xml file, its not mando
		 * to give hibernate.cfg.xml //SessionFactory sf = cfg.buildSessionFactory();
		 * SessionFactory sf = HibernateUtil.getSessionFacory(); System.out.println(sf);
		 * Session session = sf.openSession();
		 * 
		 * //transient state of object Employee e=new Employee(); e.setEmpName("rishi");
		 * e.setEmpDesig("student"); e.setEmpSalary(100000);
		 * 
		 * //begin the transaction Transaction tx = session.beginTransaction();
		 * 
		 * //save object into db using session(persistent state) session.save(e);
		 * 
		 * 
		 * //commit the transaction tx.commit();
		 * 
		 * //close session and sessionfactory objects session.close(); sf.close();
		 */
		
		//the above is to insert the values
		 //the below is to retrieve the vales
		
        Session session = sf.openSession();
		
		//retrieving all records from table using hql
		/*
		 * Query<Employee> q = session.createQuery("from Employee"); List<Employee>
		 * empList = q.list();
		 * 
		 * //populate the emp details on console for(Employee e : empList)
		 * System.out.println(e);
		 */
        
        Query<Employee> q = session.createQuery("from Employee as e where empDesig = :desig "); 
        q.setParameter("desig","student");
        List<Employee>empList = q.list();
        
		 //populate the emp details on console 
        for(Employee e : empList)
		 System.out.println(e);
        
		session.close();
		sf.close();

		
	}
}