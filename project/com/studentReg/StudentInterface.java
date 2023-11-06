package com.studentReg;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.CollegeAdimission.*;

public class StudentInterface {

	public void RegistrationFrom(){
		Configuration con = new Configuration().configure().addAnnotatedClass(StdRegForm.class);	
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		try{
			Scanner scanner = new Scanner(System.in);
			StdRegForm Student = new StdRegForm();
			StudentName Studentname = new StudentName();
			FatherName Fathername = new FatherName();
			Address address = new Address();
			courseSelection priority = new courseSelection();
			
			System.out.println("Enter Student First Name:");
			Studentname.setStd_FName(scanner.nextLine());

			System.out.println("Enter Student Middle Name:");
			Studentname.setStd_MName(scanner.nextLine());

			System.out.println("Enter Student Last Name:");
			Studentname.setStd_LName(scanner.nextLine());
			Student.setSname(Studentname);

			System.out.println("Enter Father's First Name:");
			Fathername.setFName(scanner.nextLine());

			System.out.println("Enter Father's Middle Name:");
			Fathername.setMName(scanner.nextLine());

			System.out.println("Enter Father's Last Name:");
			Fathername.setLName(scanner.nextLine());
			Student.setFname(Fathername);

			//
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			while (true) {
			    System.out.println("Enter date of birth (dd/MM/yyyy):");
			    String dateStr = scanner.next(); 
			    try {
			        // Parse the date string into a LocalDate object
			        Student.setDOB(LocalDate.parse(dateStr, dateFormatter));
			        break;
			    } catch (DateTimeParseException e) {
			        // Handle any parsing errors here
			        System.out.println("Invalid date of birth. Please enter a valid date of birth in the format dd/MM/yyyy.");
			    }
			}


			//
			System.out.println("Enter Gender:");
			Student.setGender(scanner.next());


			//
			Pattern patternadhar = Pattern.compile("^[0-9]{12}$");
			while(true){
				System.out.print("Enter your Aadhar card number: \n");
				String aadharNumber = scanner.next();

				// Match the entered Aadhar number with the pattern
				Matcher matcher = patternadhar.matcher(aadharNumber);

				if (matcher.matches()) {
					Student.setAadhar_No(aadharNumber);
					break;
				}
				else {
					System.out.println("Invalid Aadhar card number. Please enter a 12-digit numeric Aadhar number.");
				}

			}



			//
			Pattern patternphone = Pattern.compile("^[6789]\\d{9}$");
			while(true) {
				System.out.print("Enter your phone number: \n");
				String phoneNumber = scanner.next();

				// Remove any spaces or hyphens from the input
				phoneNumber = phoneNumber.replaceAll("[\\s-]+", "");

				// Match the entered phone number with the pattern
				Matcher matcher = patternphone.matcher(phoneNumber);

				if (matcher.matches()) {
					Student.setMobile_No(phoneNumber);
					break;
				} 
				else {
					System.out.println("Invalid phone number. Please enter a 10-digit number");
				}
			}



			//
			Pattern Emailpattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z]+\\.[A-Za-z]{2,}$");

			while(true) {
				System.out.print("Enter an email address: \n");
				String emailAddress = scanner.next();

				// Match the entered email address with the pattern
				Matcher matcher = Emailpattern.matcher(emailAddress);

				if (matcher.matches()) {
					Student.setMail(emailAddress);
					break;
				} 
				else {
					System.out.println("Invalid email address. Please enter a valid email address.");
				}
			}


			System.out.println("Enter Address Door Number:");
			address.setDoorNo(scanner.next());

			System.out.println("Enter Address City:");
			address.setCity(scanner.next());

			System.out.println("Enter Address Pin Code:");
			address.setPinCode(scanner.next());
			Student.setAddress(address);


			//
			System.out.println("Enter Intermediate Marks:");
			Student.setInterMark( scanner.nextDouble());
			scanner.nextLine(); // Consume the newline character

			System.out.println("Enter Courses as Per Student Priority");
			System.out.println("Course Codes Electronis&Communication ECE, Computers CSE, Mechanical Mech");
			System.out.println("Enter Course Priority 1:");
			priority.setPriority_1(scanner.nextLine());

			System.out.println("Enter Course Priority 2:");
			priority.setPriority_2(scanner.nextLine());
			
			System.out.println("Enter Course Priority 2:");
			priority.setPriority_3(scanner.nextLine());
			Student.setcSelection(priority);
			
			session.beginTransaction();
			session.save(Student);
			session.getTransaction().commit();

			System.out.println("Registration successful! Registration ID: ");
			System.out.println("Student ID: " + Student.getRegID()+"\n"+"Student Name: " + Student.getSname().getStd_FName() + " " +
	                Student.getSname().getStd_MName() + " " +
	                Student.getSname().getStd_LName()+"\n"+"Father's Name: " + Student.getFname().getFName() + " " +
	                Student.getFname().getMName() + " " +
	                Student.getFname().getLName()+"\n"+"DOB: " + Student.getDOB()+"\n"+"Intermediate marks: " + Student.getInterMark()+"\n"+"Gender: " + Student.getGender()
	                +"\n"+"PhoneNo: " + Student.getMobile_No()+"\n"+"Email: " + Student.getMail()+"\n"+
	                "Address: " + Student.getAddress().getDoorNo() + " " + Student.getAddress().getCity() + " " +
	                Student.getAddress().getPinCode()+"\n"+"Priority: " + Student.getcSelection().getPriority_1() + " " +
	                Student.getcSelection().getPriority_2() + " " + Student.getcSelection().getPriority_3());
		}
		catch(HibernateException he) {
		    System.out.println("Hibernate Exception: " + he.getMessage());
		    he.printStackTrace();
		}
		catch(Exception e) {
		    System.out.println("An unexpected error occurred: " + e.getMessage());
		    e.printStackTrace();
		}

		finally {
			session.close();
			sf.close();
		}
		
	}
	
	 public void ApplicationStatus() {
		    Configuration con = new Configuration().configure().addAnnotatedClass(StdRegForm.class).addAnnotatedClass(Admin.class);	
			SessionFactory sf = con.buildSessionFactory();
		    Session session = sf.openSession();
		    try {
		    	Scanner scanner = new Scanner(System.in);
		    	System.out.println("Enter Your Registration ID");
		    	int RegId = scanner.nextInt();
		    	StdRegForm stdRegForm = session.get(StdRegForm.class ,RegId);
		    	Admin admin = session.get(Admin.class,RegId);
	    		String formattedString = String.format(
	    				"--------------Application Status-------------\n"+
	    	            "Registration ID    : %s%n" +
	    	            "Student Name       : %s %s %s%n" +
	    	            "Intermediate Marks : %s%n" +
	    	            "Priority 1         : %s%n" +
	    	            "Priority 2         : %s%n" +
	    	            "Priority 3         : %s%n" +
	    	            "Allocated Seat     : %s%n" 
	    	            ,
	    	            stdRegForm.getRegID(),
	    	            stdRegForm.getSname().getStd_FName(),
	    	            stdRegForm.getSname().getStd_MName(),
	    	            stdRegForm.getSname().getStd_LName(),
	    	            stdRegForm.getInterMark(),
	    	            stdRegForm.getcSelection().getPriority_1(),
	    	            stdRegForm.getcSelection().getPriority_2(),
	    	            stdRegForm.getcSelection().getPriority_3(),
	    	            admin.getAllocatedSeat()
	    	        );

	    	        // Print the formatted string
	    	        System.out.println(formattedString);
	    	      
		    }
		    catch(Exception ex) {
		    	System.out.println("Failed get Application");
		    }
		    
	    }


	}
	





