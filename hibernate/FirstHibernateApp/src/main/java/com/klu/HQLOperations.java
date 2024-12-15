package com.klu;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLOperations {
	public static void main(String[] args) {
		HQLOperations operations = new HQLOperations();
		//operations.addEmployee();
		operations.displayallempscompleteobject();
		//operations.displayallempspartialobject();
		//operations.aggregateFunctions();
	}

	public void addEmployee() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Employee emp = new Employee();
		emp.setEmpName("KLEF");
		emp.setEmpDesig("student");
		emp.setEmpSalary(15000);

		session.persist(emp);
		transaction.commit();
		System.out.println("Employee Added Successfully");
		session.close();
		sf.close();
	}

	public void displayallempscompleteobject() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		String hql = "from Employee";
		Query<Employee> qry = session.createQuery(hql, Employee.class);
		List<Employee> emps = qry.getResultList();
		System.out.println("Total Employees=" + emps.size());
		for (Employee e : emps) {
			System.out.println("ID:" + e.getEmpId());
			System.out.println("Name:" + e.getEmpName());
			System.out.println("Designation:" + e.getEmpDesig());
			System.out.println("Salary:" + e.getEmpSalary());
		}
		session.close();
		sf.close();
	}

	public void displayallempspartialobject() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		String hql = "select e.empId,e.empName,e.empSalary from Employee e"; // e is an alias or reference object of
																				// type Employee

		Query<Object[]> qry = session.createQuery(hql, Object[].class);
		List<Object[]> emps = qry.getResultList();
		System.out.println("Total Employees=" + emps.size());
		for (Object[] obj : emps) {
			System.out.println("ID:" + obj[0]);
			System.out.println("Name:" + obj[1]);
			System.out.println("Salary:" + obj[2]);
		}
		session.close();
		sf.close();
	}
	
	public void aggregateFunctions() {
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");

	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();

	    // Count total employees
	    String hql1 = "select count(*) from Employee";
	    Query<Long> qry1 = session.createQuery(hql1, Long.class);
	    long count = qry1.getSingleResult();
	    System.out.println("Total Employees = " + count);

	    // Average salary
	    String hql2 = "select avg(empSalary) from Employee";
	    Query<Double> qry2 = session.createQuery(hql2, Double.class);
	    double averageSalary = qry2.getSingleResult();
	    System.out.println("Average Salary = " + averageSalary);

	    // Minimum salary
	    String hql3 = "select min(empSalary) from Employee";
	    Query<Double> qry3 = session.createQuery(hql3, Double.class);
	    double minSalary = qry3.getSingleResult();
	    System.out.println("Minimum Salary = " + minSalary);

	    // Maximum salary
	    String hql4 = "select max(empSalary) from Employee";
	    Query<Double> qry4 = session.createQuery(hql4, Double.class);
	    double maxSalary = qry4.getSingleResult();
	    System.out.println("Maximum Salary = " + maxSalary);

	    session.close();
	    sf.close();
	}

	

}