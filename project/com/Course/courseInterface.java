package com.Course;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class courseInterface {
	public static void addCourse() {
		Scanner sc = new Scanner(System.in);
		try (SessionFactory sf = new Configuration().configure().addAnnotatedClass(Course.class).buildSessionFactory();
				Session session = sf.openSession()) {
			
			System.out.println("Enter how many courses you want to add to the database:");

			int count = sc.nextInt();
			sc.nextLine(); // Consume the newline character left by nextInt()

			while (count > 0) {
				Course course = new Course();
				System.out.println("Enter course name:");
				String name = sc.nextLine();
				course.setCourseName(name);

				System.out.println("Enter course code:");
				String code = sc.next().toUpperCase();
				course.setCourseCode(code);

				System.out.println("Enter total available Seats:");
				int total = sc.nextInt();
				sc.nextLine(); // Consume the newline character left by nextInt()
				course.setTotalSeats(total);
				course.setAvailableSeats(total);

				session.save(course);

				System.out.println("Added course with code " + course.getCourseCode() + " and id " + course.getId());
				count--;
			}
		}
	}




}
