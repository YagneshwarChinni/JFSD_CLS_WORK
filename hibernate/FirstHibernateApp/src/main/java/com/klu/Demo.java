package com.klu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Demo {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFacory();
		Session s = sf.openSession();
		// get student details of primary key value 2
		// using get() method
		Student st = s.get(Student.class, 2);
		if (st != null)
			System.out.println("using get: " + st);
		else
			System.out.println("using get(): object not available");

		// using load() method
		try {
			Student st1 = s.load(Student.class, 2);
			System.out.println("using load: " + st1);
		} catch (Exception e) {
			System.out.println("using load: " + e.getMessage());
		}

		s.close();
		sf.close();
	}
}