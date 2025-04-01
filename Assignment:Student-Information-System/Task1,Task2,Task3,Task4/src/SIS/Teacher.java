package SIS;

import java.util.*;

import SIS.Sisexceptions.InvalidTeacherDataException;
class Teacher {
	private int teacherID;
	private String firstName;
	private String lastName;
	private String email;
	private String expertise;

    public Teacher(int teacherID, String firstName, String lastName, String email,String expertise)throws InvalidTeacherDataException {
        if (firstName == null || firstName.isEmpty()) {
            throw new InvalidTeacherDataException("Teacher's first name cannot be empty.");
        }
        if (email == null || !email.contains("@")) {
            throw new InvalidTeacherDataException("Invalid email format."); 
        }
        this.teacherID = teacherID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.expertise=expertise;
    }
    
    public void updateTeacher(String firstName, String lastName, String email,String expertise) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.expertise=expertise;
    }
    public void displayteacher() {
    	System.out.println("TeacherName: "+firstName+" "+lastName+" Email: "+email+" Expertise: "+expertise);
    }
   public List<Course> getassignedcourse(List<Course> allcourse){
	   List<Course> assignedcourse=new ArrayList<>();
	   for(Course course:allcourse) {
		   if(course.getteacher()==this) {
			   assignedcourse.add(course);
		   }
	   }
	   return assignedcourse;
   }

  public String getfirstName() {
	return firstName;
  }
  public String getlastName() {
	return lastName;
  }
}