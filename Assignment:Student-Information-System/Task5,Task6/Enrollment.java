package SIS;

import SIS.Sisexceptions.InvalidEnrollmentDataException;

class Enrollment {
	private int enrollmentID;
	private Student student;
	private Course course;
	private String enrollmentDate;

	public Enrollment(int enrollmentID, Student student, Course course, String enrollmentDate)
			throws InvalidEnrollmentDataException {
		if (student == null) {
			throw new InvalidEnrollmentDataException("Student reference cannot be null.");
		}
		if (course == null) {
			throw new InvalidEnrollmentDataException("Course reference cannot be null.");
		}
		this.enrollmentID = enrollmentID;
		this.student = student;
		this.course = course;
		this.enrollmentDate = enrollmentDate;
	}

	public Student getstudent() {
		return student;
	}

	public Course getcourse() {
		return course;
	}
}
