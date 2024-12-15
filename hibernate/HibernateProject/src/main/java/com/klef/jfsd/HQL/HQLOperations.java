package com.klef.jfsd.HQL;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

public class HQLOperations {
	public static void main(String[] args) {
		HQLOperations operations = new HQLOperations();
		// operations.addEmployee();
		// operations.displayallempscompleteobject();
		// operations.displayallempspartialobject();
		// operations.aggregatefunctions();

		// operations.updatepositionalparams();
		// operations.updatenamedparams();

		// operations.deletepositionalparams();
		// operations.deletenamedparams();
		// operations.hqldemo();
		//operations.pagination();
	}

	public void addEmployee() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Employee emp = new Employee();
		emp.setEmpName("ep");
		emp.setEmpDesig("Professor");
		emp.setEmpSalary(7000);

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

	public void aggregatefunctions() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		// count
		String hql1 = "select count(*) from Employee";
		Query<Long> qry1 = session.createQuery(hql1, Long.class);
		long count = qry1.getSingleResult();
		System.out.println("Total Employee=" + count);

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

		// Sum of salaries
		String hql5 = "select sum(empSalary) from Employee";
		Query<Double> qry5 = session.createQuery(hql5, Double.class);
		double sumSalary = qry5.getSingleResult();
		System.out.println("Sum of Salaries = " + sumSalary);

		session.close();
		sf.close();
	}

	public void updatepositionalparams() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "update Employee set empName=:?1,empSalary=:?2 where empId=:?3";
		// session.createQuery(null)

		MutationQuery qry = session.createMutationQuery(hql);
		qry.setParameter(1, "EP");
		qry.setParameter(2, 6700);
		qry.setParameter(3, 1);

		int n = qry.executeUpdate();

		if (n > 0) {
			System.out.println("Employee Updated Successfully");
		} else {
			System.out.println("Employee ID not found");
		}
		transaction.commit();
		session.close();
		sf.close();

	}

	public void updatenamedparams() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "update Employee set empName=:v1,empSalary=:v2 where empId=:v3";
		// session.createQuery(null)

		MutationQuery qry = session.createMutationQuery(hql);
		qry.setParameter("v1", "klu");
		qry.setParameter("v2", 6700);
		qry.setParameter("v3", 1);

		int n = qry.executeUpdate();

		if (n > 0) {
			System.out.println("Employee Updated Successfully");
		} else {
			System.out.println("Employee ID not found");
		}
		transaction.commit();
		session.close();
		sf.close();

	}

	public void deletepositionalparams() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter EMP ID:");
		int eid = sc.nextInt();

		String hql = "delete from Employee where empId=?1";
		// session.createQuery(null)

		MutationQuery qry = session.createMutationQuery(hql);
		qry.setParameter(1, eid);

		int n = qry.executeUpdate();

		if (n > 0) {
			System.out.println("Employee deleted Successfully");
		} else {
			System.out.println("Employee ID not found");
		}
		transaction.commit();
		session.close();
		sf.close();

	}

	public void deletenamedparams() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter EMP ID:");
		int eid = sc.nextInt();

		String hql = "delete from Employee where empId=:v";
		// session.createQuery(null)

		MutationQuery qry = session.createMutationQuery(hql);
		qry.setParameter("v", eid);

		int n = qry.executeUpdate();

		if (n > 0) {
			System.out.println("Employee deleted Successfully");
		} else {
			System.out.println("Employee ID not found");
		}
		transaction.commit();
		session.close();
		sf.close();

	}

	// display employee objects based on designation(student) and salary should be
	// >= 10000

	public void hqldemo() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		String hql = "from Employee where empDesig=?1 and empSalary>=?2";

		Query<Employee> qry = session.createQuery(hql, Employee.class);

		qry.setParameter(1, "professor");
		qry.setParameter(2, 10000);

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

	public void pagination() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		String hql = "from Employee";
		Query<Employee> qry = session.createQuery(hql, Employee.class); 

		qry.setFirstResult(2);
		qry.setMaxResults(5);

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

}