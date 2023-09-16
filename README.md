<br/>
<p align="center">
  <h1 align="center">College Admissions System</h1>

  <p align="center">
    A Console-Based College Admissions System for Streamlined Admissions Process!
    <br/>
    <br/>
    <a href="https://github.com/Ayyappanakkala/project"><strong>Explore the docs »</strong></a>
    <br/>
  </p>
</p>

## Table Of Contents

- [About the Project](#about-the-project)
- [Features](#features)
  - [Student Section](#student-section)
    - [Student Registration](#student-registration)
    - [Application Status Checking](#application-status-checking)
  - [Admin Section](#admin-section)
    - [Admin Login](#admin-login)
    - [Course Allocation](#course-allocation)
    - [Fetching Records](#fetching-records)
    - [Course Details](#course-details)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)

## About The Project

The College Admissions System is a console-based application designed to streamline the college admissions process. It offers both students and administrators a user-friendly interface to manage admissions efficiently.

## Features

## Student Section

#### Student Registration

The Student Registration feature is the core component of our College Admissions System. It allows aspiring students to initiate the admission process seamlessly. Students are required to provide comprehensive details to create their admission profile.

The registration form prompts students to enter essential information such as their full name, including first name, middle name, and last name. Additionally, students must provide their father's name, which aids in unique identification. To ensure efficient communication, students input their address, mobile number, and email address. This data helps us keep applicants informed throughout the admission process.

For identity verification and government compliance, the registration form also includes an Aadhar card number field. It ensures that the applicant is an Indian citizen and helps maintain admission records.

Furthermore, students need to submit their intermediate marks, which plays a crucial role in course allocation. Lastly, students can prioritize their preferred courses, allowing them to express their academic interests and preferences.

#### Application Status Checking

Once students have completed the registration process, they can conveniently check the status of their admission application through our Application Status Checking feature. Each student receives a unique application ID upon successful registration, which serves as their reference.

By entering this application ID, students gain access to real-time updates on their admission progress. They can monitor their application's status, from submission to acceptance or rejection. This transparency ensures that students are well-informed and reduces uncertainty throughout the admission process.

## Admin Section

#### Admin Login

The Admin Login feature is designed to provide secure access to authorized administrators who oversee the college admissions process. Administrators access the system through a login process, ensuring data privacy and system integrity.

Administrators must input their valid login credentials, including a username and password, to gain access. This authentication mechanism ensures that only authorized personnel can use the system's administrative functions.

#### Course Allocation

Admins play a pivotal role in the course allocation process. Once all students have successfully registered and provided their intermediate marks, administrators can allocate courses based on academic performance.

This feature streamlines the allocation process, ensuring that students are placed in courses that match their qualifications. Admins consider each student's intermediate CGPA to make informed allocation decisions, promoting fairness and efficiency.

#### Fetching Records

Admins can access a wealth of student data stored in the system's database. The Fetching Records feature allows administrators to retrieve and display student records directly within the console.

This feature aids in managing the admissions process effectively, as admins can review and verify student information, monitor registration statistics, and identify any discrepancies or issues promptly.

#### Course Details

To provide greater clarity and transparency, administrators can use the Course Details feature to display essential course information. This includes course codes, available seats, allocated seats, and total seats for each program or department.

By presenting this information within the console, administrators can easily track seat availability and make informed decisions regarding course allocation. It ensures that the admissions process is well-organized and that available resources are utilized optimally.

These features collectively enhance the efficiency and transparency of the college admissions process, benefiting both students and administrators involved in the system.

## Getting Started

This is an example of how you may give instructions on setting up your project locally. To get a local copy up and running, follow these simple steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.

- Java Development Kit (JDK)

### Installation

1. Clone the repo

```sh
git clone https://github.com/Ayyappanakkala/project.git
```

2. Navigate to the Project Directory

   Use the cd (change directory) `command` to navigate to the directory where you cloned the repository.
   For example:

```sh
cd project
```

3. Compile the Java Code

   Compile the Java code in the Admissions.Entry package. Assuming that APP.java is the entry point of your application, you can compile it using the `javac` command

```sh
javac com/main/Main.java
```

4. Run the Application

   After successfully compiling the code, you can run your application using the java command

```sh
java com.main.Main
```

This command will execute the `App.java` file in the Admissions.Entry package, starting your College Admissions System.

Make sure that you have the Java Development Kit (JDK) installed on your machine, and your Java environment variables are set up correctly for these commands to work.
