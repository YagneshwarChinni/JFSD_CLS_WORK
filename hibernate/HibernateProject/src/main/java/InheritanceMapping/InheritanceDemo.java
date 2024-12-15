package InheritanceMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InheritanceDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		
		Person p = new Person();
	    p.setName("Rishitha");
	    p.setGender("FEMALE");
	    p.setAge(21);
	    p.setContactno("9701670129");
	    p.setLocation("Vijayawada");
	    
	    Scholar s = new Scholar();
	    s.setDepartment("CSE");
	    s.setProgram("B.Tech");
	    s.setYear(3);
	    s.setCgpa(9.72);
	    s.setBacklogs(1);
	    s.setCounsellor("Mounika");
	    
	    Teacher t = new Teacher();
	    t.setQualification("M.Tech");
	    t.setDepartment("ECE");
	    t.setDesignation("Professor");
	    t.setSalary(50000);
	    t.setExperience(5.6);
		
		session.persist(p);
		session.persist(s);
		session.persist(t);
		
		System.out.println("SUCCESS...!!!");
		transaction.commit();
		session.close();
		sf.close();

	}

}
