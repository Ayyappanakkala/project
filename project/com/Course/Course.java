package com.Course;

public class Course {
	 	private int id;
	    private String courseCode;
	    private String courseName;
	    private int totalSeats;
	    private int availableSeats;
	    private int allocatedSeats;
	    
		public int getAvailableSeats() {
			return availableSeats;
		}
		public void setAvailableSeats(int availableSeats) {
			this.availableSeats = availableSeats;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCourseCode() {
			return courseCode;
		}
		public void setCourseCode(String courseCode) {
			this.courseCode = courseCode;
		}
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public int getTotalSeats() {
			return totalSeats;
		}
		public void setTotalSeats(int totalSeats) {
			this.totalSeats = totalSeats;
		}

		public int getAllocatedSeats() {
			return allocatedSeats;
		}
		public void setAllocatedSeats(int allocatedSeats) {
			this.allocatedSeats = allocatedSeats;
		}
}
