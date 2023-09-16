package com.studentReg;
import java.time.LocalDate;

public class StdRegForm {
    private int RegID;

    // Student's full name
    private StudentName sname;

    // Father's full name
    private FatherName fname;

    // Date of Birth of the student
    private LocalDate DOB;

    // Gender of the student
    private String Gender;

    // Intermediate exam marks
    private double InterMark;

    // Aadhar number of the student (Indian identification number)
    private String Aadhar_No;

    // Mobile number of the student
    private String Mobile_No;

    // Email address of the student
    private String Mail;

    // Address details of the student
    private Address address;

    // Course selection details for the student
    private courseSelection cSelection;

    // Getter for courseSelection
    public courseSelection getcSelection() {
        return cSelection;
    }

    // Setter for courseSelection
    public void setcSelection(courseSelection cSelection) {
        this.cSelection = cSelection;
    }

    // Getter for RegID
    public int getRegID() {
        return RegID;
    }

    // Setter for RegID
    public void setRegID(int regID) {
        this.RegID = regID;
    }

    // Getter for sname
    public StudentName getSname() {
        return sname;
    }

    // Setter for sname
    public void setSname(StudentName sname) {
        this.sname = sname;
    }

    // Getter for fname
    public FatherName getFname() {
        return fname;
    }

    // Setter for fname
    public void setFname(FatherName fname) {
        this.fname = fname;
    }

    // Getter for DOB
    public LocalDate getDOB() {
        return DOB;
    }

    // Setter for DOB
    public void setDOB(LocalDate localDate) {
        DOB = localDate;
    }

    // Getter for Gender
    public String getGender() {
        return Gender;
    }

    // Setter for Gender
    public void setGender(String gender) {
        Gender = gender;
    }

    // Getter for InterMark
    public double getInterMark() {
        return InterMark;
    }

    // Setter for InterMark
    public void setInterMark(double interMark) {
        InterMark = interMark;
    }

    // Getter for Aadhar_No
    public String getAadhar_No() {
        return Aadhar_No;
    }

    // Setter for Aadhar_No
    public void setAadhar_No(String aadhar_No) {
        Aadhar_No = aadhar_No;
    }

    // Getter for Mobile_No
    public String getMobile_No() {
        return Mobile_No;
    }

    // Setter for Mobile_No
    public void setMobile_No(String mobile_No) {
        Mobile_No = mobile_No;
    }

    // Getter for Mail
    public String getMail() {
        return Mail;
    }

    // Setter for Mail
    public void setMail(String mail) {
        Mail = mail;
    }

    // Getter for address
    public Address getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(Address address) {
        this.address = address;
    }

    // Override toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "StdRegForm [RegID=" + RegID + ", sname=" + sname + ", fname=" + fname + ", DOB=" + DOB + ", Gender="
                + Gender + ", InterMark=" + InterMark + ", Aadhar_No=" + Aadhar_No + ", Mobile_No=" + Mobile_No
                + ", Mail=" + Mail + ", address=" + address + "]";
    }
}
