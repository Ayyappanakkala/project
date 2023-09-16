package com.authentication;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ValidateUser {
	public static boolean Validate() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();	
		
	    // creating session object
	     Session session = factory.openSession();

	     // creating transaction object
	     Transaction t = session.beginTransaction();
	     
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username ");
		String user = sc.nextLine();
		System.out.println("Enter Password ");
		String pass = sc.nextLine();

		// Create a CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// Create a CriteriaQuery for the Login entity
		CriteriaQuery<Login> criteriaQuery = builder.createQuery(Login.class);
		Root<Login> root = criteriaQuery.from(Login.class);

		// Add predicates to the query for username and password
		criteriaQuery.where(
		    builder.equal(root.get("username"), user),
		    builder.equal(root.get("password"), pass)
		);

		// Execute the query
		List<Login> results = session.createQuery(criteriaQuery).getResultList();
		
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
