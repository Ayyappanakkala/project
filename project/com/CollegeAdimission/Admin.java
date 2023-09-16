package com.CollegeAdimission;

import com.studentReg.StdRegForm;

public class Admin {
    // Private instance variables to store Admin information
    private int RegID;
    private double InterMark;
    private String Priority_1;
    private String Priority_2;
    private String Priority_3;
    
    // Reference to a StdRegForm object associated with this Admin
    private StdRegForm stdRegForm;
    
    // A string to store the allocated seat information
    private String AllocatedSeat;

    // Getter method for AllocatedSeat
    public String getAllocatedSeat() {
        return AllocatedSeat;
    }

    // Setter method for AllocatedSeat
    public void setAllocatedSeat(String allocatedSeat) {
        this.AllocatedSeat = allocatedSeat;
    }

    // Getter method for StdRegForm
    public StdRegForm getStdRegForm() {
        return stdRegForm;
    }

    // Setter method for StdRegForm
    public void setStdRegForm(StdRegForm stdRegForm) {
        this.stdRegForm = stdRegForm;
    }

    // Getter method for RegID
    public int getRegID() {
        return RegID;
    }

    // Setter method for RegID
    public void setRegID(int regID) {
        this.RegID = regID;
    }

    // Getter method for InterMark
    public double getInterMark() {
        return InterMark;
    }

    // Setter method for InterMark
    public void setInterMark(double interMark) {
        this.InterMark = interMark;
    }

    // Getter method for Priority_1
    public String getPriority_1() {
        return Priority_1;
    }

    // Setter method for Priority_1
    public void setPriority_1(String priority_1) {
        this.Priority_1 = priority_1;
    }

    // Getter method for Priority_2
    public String getPriority_2() {
        return Priority_2;
    }

    // Setter method for Priority_2
    public void setPriority_2(String priority_2) {
        this.Priority_2 = priority_2;
    }

    // Getter method for Priority_3
    public String getPriority_3() {
        return Priority_3;
    }

    // Setter method for Priority_3
    public void setPriority_3(String priority_3) {
        this.Priority_3 = priority_3;
    }
}
