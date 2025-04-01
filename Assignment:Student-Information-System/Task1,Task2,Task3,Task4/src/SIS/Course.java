package SIS;

import java.util.*;

import SIS.Sisexceptions.InvalidCourseDataException;
class Course {
	private int courseID;
	private String courseName;
	private String courseCode;
	private String instructorName;
	private Teacher assignedteacher;
	    private double courseFee;
	    public double getCourseFee() {
	        return this.courseFee;
	    }

    
    List<Enrollment> enrollments=new ArrayList<>();

    public Course(int courseID, String courseName, String courseCode, String instructorName)throws InvalidCourseDataException {
        if (courseCode == null || courseCode.isEmpty()) {
            throw new InvalidCourseDataException("Course code cannot be empty.");
        }
        if (instructorName == null || instructorName.isEmpty()) {
            throw new InvalidCourseDataException("Instructor name cannot be empty.");
        } 
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructorName = instructorName;
    }
    public void assignteacher(Teacher teacher) {
    	this.assignedteacher=teacher;
    }
    public void updatecourse( String courseName, String courseCode, String instructorName) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructorName = instructorName;
    }
    public void displaycourse() {
    	System.out.println("CourseName: "+courseName+" Course code: "+courseCode+" InstructorName: "+instructorName);
    }
    public List<Enrollment> getenrollments(){
    	return enrollments;
    }
    public Teacher getteacher() {
    	return assignedteacher;
    }
	public void addenrollment(Enrollment enrollment) {
		enrollments.add(enrollment);
		
	}
	public String getcourseName() {
		return courseName;
	}
}