package com.CollegeAdimission;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.studentReg.StdRegForm;

public class AdminInterface {

    public void allocateCourse() {
        try (SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(StdRegForm.class).addAnnotatedClass(Admin.class).buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                List<StdRegForm> studentList = session.createQuery("FROM StdRegForm ORDER BY InterMark DESC",
                        StdRegForm.class).list();
                List<Course> courses = session.createQuery("FROM Course", Course.class).list();

                int[] maxSeats = new int[courses.size()];
                int[] seatsAllocate = new int[courses.size()];
                int[] availableSeats = new int[courses.size()]; // Added this line
                String[] departments = new String[courses.size()];

                for (int i = 0; i < courses.size(); i++) {
                    Course course = courses.get(i);
                    maxSeats[i] = course.getTotalSeats();
                    seatsAllocate[i] = course.getAllocatedSeats();
                    availableSeats[i] = maxSeats[i] - seatsAllocate[i]; // Added this line
                    departments[i] = course.getCourseCode();
                }

                Transaction transaction = session.beginTransaction();

                for (StdRegForm student : studentList) {
                    Admin admin = new Admin();
                    admin.setRegID(student.getRegID());
                    admin.setInterMark(student.getInterMark());
                    admin.setPriority_1(student.getcSelection().getPriority_1());
                    admin.setPriority_2(student.getcSelection().getPriority_2());
                    admin.setPriority_3(student.getcSelection().getPriority_3());

                    String[] priorities = {
                            student.getcSelection().getPriority_1(),
                            student.getcSelection().getPriority_2(),
                            student.getcSelection().getPriority_3()
                    };

                    admin.setAllocatedSeat("No seat Allocated");

                    for (String priority : priorities) {
                        for (int i = 0; i < departments.length; i++) {
                            if (priority.equalsIgnoreCase(departments[i]) && availableSeats[i] > 0) { // Updated this condition
                                admin.setAllocatedSeat(departments[i]);
                                seatsAllocate[i]++;
                                availableSeats[i]--; // Updated this line
                                System.out.println("Allocated seat in " + departments[i] + " for studentID " + student.getRegID());
                                break;
                            }
                        }
                        if (!admin.getAllocatedSeat().equals("No seat Allocated")) {
                            break;
                        }
                    }

                    session.save(admin);
                }

                for (int i = 0; i < seatsAllocate.length; i++) {
                    Course course = courses.get(i);
                    course.setAllocatedSeats(seatsAllocate[i]);
                    course.setAvailableSeats(maxSeats[i] - seatsAllocate[i]);
                    session.save(course);
                }

                transaction.commit();
            } catch (Exception e) {
                System.out.println("Courses allocation is completed. There are no seats available.");
                e.printStackTrace(); // Consider logging the exception
            }
        }
    }
        public  void displayAllocateSeats() {
   		 // Create Hibernate configuration and session factory
           Configuration configuration = new Configuration();
           configuration.configure("hibernate.cfg.xml"); // Load your Hibernate configuration file

           try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
               // Create a new session
               try (Session session = sessionFactory.openSession()) {
                   // Fetch data using Hibernate query (replace "YourEntity" with your entity class name)
                   List<Admin> results = session.createQuery("from Admin", Admin.class).list();

                   // Print the table header
                   System.out.println("+-------+-----------+------------+------------+------------+-------------------+");
                   System.out.println("| RegID | InterMark | Priority_1 | Priority_2 | Priority_3 | AllocatedSeat     |");
                   System.out.println("+-------+-----------+------------+------------+------------+-------------------+");

                   // Iterate through the results and print each row
                   for (Admin entity : results) {
                       System.out.printf("| %5d | %9.2f | %-10s | %-10s | %-10s | %-17s |%n",
                               entity.getRegID(), entity.getInterMark(),
                               entity.getPriority_1(), entity.getPriority_2(), entity.getPriority_3(),
                               entity.getAllocatedSeat());
                   }
                   System.out.println("+-------+-----------+------------+------------+------------+-------------------+");
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
   	}
   	public void Courses() {

   		// Create Hibernate configuration and session factory
           Configuration configuration = new Configuration();
           configuration.configure("hibernate.cfg.xml"); // Load your Hibernate configuration file

           try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
               // Create a new session
               try (Session session = sessionFactory.openSession()) {
                   // Fetch data using Hibernate query (replace "Course" with your entity class name)
                   List<Course> courses = session.createQuery("FROM Course", Course.class).list();

                   // Print table structure
                   System.out.println("+----+------------+------------------------------------------+------------+----------------+----------------+");
                   System.out.println("| id | courseCode | courseName                               | totalSeats | availableSeats | allocatedSeats |");
                   System.out.println("+----+------------+------------------------------------------+------------+----------------+----------------+");

                   // Iterate through the result list and print each row
                   for (Course course : courses) {
                       System.out.printf("| %2d | %-10s | %-40s | %10d | %14d | %14d |\n",
                               course.getId(),
                               course.getCourseCode(),
                               course.getCourseName(),
                               course.getTotalSeats(),
                               course.getAvailableSeats(),
                               course.getAllocatedSeats());
                   }

                   // Print table footer
                   System.out.println("+----+------------+------------------------------------------+------------+----------------+----------------+");
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
    }

    // Other methods for displaying allocated seats and courses go here
}
