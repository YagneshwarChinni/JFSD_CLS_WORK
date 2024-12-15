package com.klu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFacory();
		Session s = sf.openSession();
		
		//update operation
		Student st = s.get(Student.class, 2);
		if (st != null) {
			System.out.println("using Get before updation: " + st);
			Transaction tx = s.beginTransaction();
		    st.setFees(50000);
		    s.update(st);
		    tx.commit();
		}    
		else
			System.out.println("using get(): object not available");
       
		//getting data after updation from the same row
		//using load() method get the update data
		try { 
			  Student st1 = s.load(Student.class, 2);
		  System.out.println("using load after updation: " + st1); 
		  } 
		  catch (Exception e) {
			  System.out.println("using load: " + e.getMessage()); 
		  }
		
		//delete operation
		Student st2 = s.load(Student.class, 1);
		  if (st2 != null) {
				System.out.println("using Get before updation: " + st2);
				Transaction tx = s.beginTransaction();
			    s.delete(st2);
			    tx.commit();
			}
		  else
			  System.out.println("Using get(): object not available");
		  
		  //get the deleted row using load() method
		  try { 
			  Student st3 = s.load(Student.class, 1);
		  System.out.println("using load after updation: " + st3); 
		  } 
		  catch (Exception e) {
			  System.out.println("using load: " + e.getMessage()); 
		  }
		  s.close();
		  sf.close();

	}

}
