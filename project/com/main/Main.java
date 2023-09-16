package com.main;


import java.util.Scanner;

import com.CollegeAdimission.AdminInterface;
import com.authentication.ValidateUser;
import com.studentReg.StudentInterface;

public class Main {

    public static void main(String[] args) {
    	
        try(Scanner scanner = new Scanner(System.in)){
        int maxChances = 3; // Maximum number of chances to choose an option
        int chances = 0; // Counter for chances
        boolean isAdminLoggedIn = false; // Flag to track admin login

        System.out.println("------Welcome to the Portal-------");

        while (chances < maxChances) {
            System.out.println("Choose Any Option");
            System.out.println("1.Student Section");
            System.out.println("2.Admission Section");
            System.out.println("3.Exit");
            System.out.println("Enter your Choice (1, 2, or 3)");

            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    studentSection(scanner);
                    break;

                case 2:
                    if (!isAdminLoggedIn) {
                        if (ValidateUser.Validate()) {
                            isAdminLoggedIn = true; // Admin logged in successfully
                        } else {
                            System.out.println("Login Failed");
                            break; // Retry login
                        }
                    }
                    admissionSection(scanner);
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Exiting the Portal. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

            chances++;
        }

        // If user reaches maximum chances without choosing "Exit"
        System.out.println("Maximum chances reached. Exiting the Portal. Goodbye!");
        //scanner.close();
    }
        }

    private static void studentSection(Scanner scanner) {
        while (true) {
            System.out.println("------Welcome to the Student Section-------");
            System.out.println("Choose Any Option");
            System.out.println("1.Registration Form");
            System.out.println("2.Application Status");
            System.out.println("3.Exit");
            System.out.println("Enter your Choice (1, 2, or 3)");

            // Check if there is an integer input available
       
                int choice1 = scanner.nextInt();
                StudentInterface student = new StudentInterface();
                switch (choice1) {
                    case 1:
                        student.RegistrationFrom();
                        break;
                    case 2:
                        student.ApplicationStatus();
                        break;
                    case 3:
                    	System.out.println("Exiting the Portal. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            
        }
    }
    private static void admissionSection(Scanner scanner) {
    	
        while (true) {
            System.out.println("------Welcome to the Admission Section-------");
            System.out.println("Choose Any Option");
            System.out.println("1.Allocate Courses");
            System.out.println("2.Display All Students with Allocated Seats");
            System.out.println("3.Display All Courses Details");
            System.out.println("4.Back to Main Menu");
            System.out.println("Enter your Choice (1, 2, 3, or 4)");
            int choice2 = scanner.nextInt();
            AdminInterface admin = new AdminInterface();
            switch (choice2) {
                case 1:
                    admin.allocateCourse();
                    break;
                case 2:
                    admin.displayAllocateSeats();
                    break;
                case 3:
                    admin.Courses();
                    break;
                case 4:
                    // Back to the main menu
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
    