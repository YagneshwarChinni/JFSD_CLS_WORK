package GeneratorClassDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Demo {
	public static void main(String[] args) {
		Demo d =new Demo();
		//d.addUser();
		d.viewallusers();
		
	}
	
	public void addUser() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		User u = new User();
		//id is auto generated
		u.setName("KLU");
		u.setGender("FEMALE");
		u.setAge(34.5);
		u.setContact("9865341290");
		
		session.persist(u);
		transaction.commit();
		
		System.out.println("User added successfully");
		
		session.close();
		sf.close();	
		
	}
	public void viewallusers() {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
			String hql="from User"; //select * from user(user is table name)
			
			Query <User> qry = session.createQuery(hql,User.class);
			List<User> users = qry.getResultList();
			
			for(User u: users) {
				System.out.println(u.toString());
			}
			session.close();
			sf.close();	
		
	}

}















