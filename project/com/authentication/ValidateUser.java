package com.authentication;

import java.util.*;

import javax.persistence.TypedQuery;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class ValidateUser {
	
	public static boolean Validate() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();	
		
	    // creating session object
	     Session session = factory.openSession();

	     // creating transaction object
	     Transaction t = session.beginTransaction();
		System.out.println("-----Welcome to the login Section-----");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username ");
		String user = sc.nextLine();
		System.out.println("Enter Password ");
		String pass = sc.nextLine();
		// Create a CriteriaBuilder
		 String hql = "FROM Login u WHERE u.username = :username AND u.password = :password";
         TypedQuery<Login> query = session.createQuery(hql, Login.class);
         query.setParameter("username", user);
         query.setParameter("password", pass);

         // Execute the query and get the results
         List<Login> results = query.getResultList();
		
		boolean Status;

		if (results.isEmpty()) {
		    Status=false;
		} else {
		    Status=true;
		}

		t.commit();
		session.close();
		return Status;
		
	}
}