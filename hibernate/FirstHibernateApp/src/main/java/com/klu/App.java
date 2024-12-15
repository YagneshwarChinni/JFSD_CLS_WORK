package com.klu;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import org.hibernate.cfg.Configuration;

//Hello world!
public class App 
{
	public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.configure();
    	//cfg.configure("hibernate.xml");
    	SessionFactory sf = cfg.buildSessionFactory();
    	//SessionFactory sf = HibernateUtil.getSessionFacory();
    	System.out.println(sf);
    	Session session = sf.openSession();
    	
    	//transient state of object
    	Student s = new Student();
    	s.setSname("aashi");
    	s.setCourse("JFSD");
    	s.setFees(20000);
    	
    	Product p = new Product();
    	p.setPname("apple");
    	p.setPrice(2000);
    
    	//begin the transaction
    	Transaction tx = session.beginTransaction();
    	
    	//save object into db using session(persistent state)
    	session.save(s);
    	session.save(p);
    	
    	//commit the transaction
    	tx.commit();
    	
    	//close the session and sessionfactory object
    	session.close();
    	sf.close();
    	
    	
    	}
}
