package com.klef.jfsd.HCQL;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class HCQLOperations {
	public static void main(String[] args) {
		HCQLOperations operations = new HCQLOperations();
		// operations.addFaculty();
		// operations.restrictionsdemo();
		// operations.hcqldemo();
		operations.aggregatefunction();
	}

	public void addFaculty() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		Faculty f = new Faculty();
		f.setId(104);
		f.setName("Rishitha");
		f.setGender("FEMALE");
		f.setDepartment("ECE");
		f.setSalary(40000);
		f.setContactno("9675429123");

		session.persist(f);
		transaction.commit();
		System.out.println("Faculty Added Successfully");

		session.close();
		sf.close();

	}

	public void restrictionsdemo() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Faculty> cq = cb.createQuery(Faculty.class);
		// complete object - from Faculty
		Root<Faculty> root = cq.from(Faculty.class);

		// equals
		// cq.select(root).where(cb.equal(root.get("department"), "CSE"));

		// between
		// cq.select(root).where(cb.between(root.get("salary"), 10000, 60000));

		// greater than or equal to
		cq.select(root).where(cb.ge(root.get("salary"), 30000));

		List<Faculty> facultylist = session.createQuery(cq).getResultList();

		System.out.println("Faculty Count =" + facultylist.size());

		for (Faculty f : facultylist) {

			System.out.println(f.toString());
		}
		session.close();
		sf.close();
	}

	// display faculty object with salarygreater than some value in descending order
	public void hcqldemo() // usecase
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Faculty> cq = cb.createQuery(Faculty.class);

		// complete object - from Faculty
		Root<Faculty> root = cq.from(Faculty.class);

		// criteria or restriction
		cq.select(root).where(cb.greaterThan(root.get("salary"), "30000"));

		// order by
		cq.orderBy(cb.desc(root.get("salary")));

		List<Faculty> facultylist = session.createQuery(cq).getResultList();

		System.out.println("Faculty Count =" + facultylist.size());

		for (Faculty f : facultylist) {
			System.out.println(f.toString());
		}
		session.close();
		sf.close();

	}

	public void aggregatefunction() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		/*
		 * CriteriaBuilder cb = session.getCriteriaBuilder(); CriteriaQuery<Long> cq =
		 * cb.createQuery(Long.class); Root<Faculty> root = cq.from(Faculty.class);
		 * cq.select(cb.count(root.get("name"))); Long count =
		 * session.createQuery(cq).getSingleResult(); System.out.println(count);
		 */

		/*
		 * CriteriaBuilder cb = session.getCriteriaBuilder(); CriteriaQuery<Double> cq =
		 * cb.createQuery(Double.class); Root<Faculty> root = cq.from(Faculty.class);
		 * cq.select(cb.sum(root.get("salary"))); Double sum =
		 * session.createQuery(cq).getSingleResult(); System.out.println(sum);
		 */

		/*
		 * CriteriaBuilder cb = session.getCriteriaBuilder(); CriteriaQuery<Long> cq =
		 * cb.createQuery(Long.class); Root<Faculty> root = cq.from(Faculty.class);
		 * cq.select(cb.countDistinct(root.get("department"))); Long count =
		 * session.createQuery(cq).getSingleResult(); System.out.println(count);
		 */

		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		//count
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Faculty> root = cq.from(Faculty.class);
		cq.select(cb.count(root.get("name")));
		Long count = session.createQuery(cq).getSingleResult();
		System.out.println(count);

		// Maximum Salary
		CriteriaBuilder cb1 = session.getCriteriaBuilder();
		CriteriaQuery<Double> maxQuery = cb1.createQuery(Double.class);
		Root<Faculty> maxRoot = maxQuery.from(Faculty.class);
		maxQuery.select(cb1.max(maxRoot.get("salary")));
		Double maxSalary = session.createQuery(maxQuery).getSingleResult();
		System.out.println("Maximum Salary: " + maxSalary);

		// Minimum Salary
		CriteriaBuilder cb2 = session.getCriteriaBuilder();
		CriteriaQuery<Double> minQuery = cb2.createQuery(Double.class);
		Root<Faculty> minRoot = minQuery.from(Faculty.class);
		minQuery.select(cb2.min(minRoot.get("salary")));
		Double minSalary = session.createQuery(minQuery).getSingleResult();
		System.out.println("Minimum Salary: " + minSalary);

		// Average Salary
		CriteriaBuilder cb3 = session.getCriteriaBuilder();
		CriteriaQuery<Double> avgQuery = cb3.createQuery(Double.class);
		Root<Faculty> avgRoot = avgQuery.from(Faculty.class);
		avgQuery.select(cb3.avg(avgRoot.get("salary")));
		Double avgSalary = session.createQuery(avgQuery).getSingleResult();
		System.out.println("Average Salary: " + avgSalary);

		// Sum of all Salaries
		CriteriaBuilder cb4 = session.getCriteriaBuilder();
		CriteriaQuery<Double> sumQuery = cb4.createQuery(Double.class);
		Root<Faculty> sumRoot = sumQuery.from(Faculty.class);
		sumQuery.select(cb4.sum(sumRoot.get("salary")));
		Double totalSalary = session.createQuery(sumQuery).getSingleResult();
		System.out.println("Sum of All Salaries: " + totalSalary);

		session.close();
		sf.close();

	}
}