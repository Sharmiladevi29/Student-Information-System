package SIS;

import java.util.ArrayList;
import java.util.List;

import SIS.Sisexceptions.InsufficientFundsException;
import SIS.Sisexceptions.InvalidEnrollmentDataException;

public class Sis {

	private List<Student> students = new ArrayList<>();
	private List<Course> courses = new ArrayList<>();
	private List<Teacher> teachers = new ArrayList<>();
	private List<Enrollment> enrollments = new ArrayList<>();
	private List<Payment> payments = new ArrayList<>();

	public void enrollStudentInCourse(Student student, Course course) throws Sisexceptions.DuplicateEnrollmentException,
			Sisexceptions.CourseNotFoundException, Sisexceptions.StudentNotFoundException,
			Sisexceptions.InsufficientFundsException, InvalidEnrollmentDataException {
		if (!students.contains(student)) {
			throw new Sisexceptions.StudentNotFoundException("Student not found in the system.");
		}
		if (!courses.contains(course)) {
			throw new Sisexceptions.CourseNotFoundException("Course not found in the system.");
		}
		if (student.getenrolledcourses().contains(course)) {
			throw new Sisexceptions.DuplicateEnrollmentException("Student is already enrolled in this course.");
		}
		if (student.getBalance() < course.getCourseFee()) {
			throw new Sisexceptions.InsufficientFundsException(
					"Student does not have enough funds to enroll in this course.");
		}

		student.enrollincourse(course);
		Enrollment enrollment = new Enrollment(enrollments.size() + 1, student, course,
				java.time.LocalDate.now().toString());
		enrollments.add(enrollment);
		course.addenrollment(enrollment);
		System.out.println(student.getfirstName() + " enrolled in " + course.getcourseName());

	}

	public void assignTeacherToCourse(Teacher teacher, Course course) throws Sisexceptions.TeacherNotFoundException {
		if (!teachers.contains(teacher)) {
			throw new Sisexceptions.TeacherNotFoundException("Teacher not found in the system.");
		}
		course.assignteacher(teacher);
		System.out.println(
				teacher.getfirstName() + " " + teacher.getlastName() + " is assigned to " + course.getcourseName());
	}

	public void recordPayment(Student student, double amount, String paymentDate)
			throws Sisexceptions.PaymentValidationException, InsufficientFundsException {
		if (amount <= 0) {
			throw new Sisexceptions.PaymentValidationException("Payment amount must be greater than zero.");
		}
		Payment payment = new Payment(payments.size() + 1, student, amount, paymentDate);
		payments.add(payment);
		student.makepayment(amount, paymentDate);
	}

	public void generateenrollmentreport(Course course) {
		System.out.println("Enrollment report for " + course.getcourseName() + ":");
		for (Enrollment enrollment : enrollments) {
			if (enrollment.getcourse().equals(course)) {
				System.out.println("Student: " + enrollment.getstudent().getfirstName() + " "
						+ enrollment.getstudent().getlastName());
			}
		}
	}

	public void generatepaymentreport(Student student) {
		for (Payment payment : payments) {
			if (payment.getstudent().equals(student)) {
				System.out.println("Amount " + payment.getpaymentamount() + " ||Date: " + payment.getpaymentdate());
			}
		}
	}

	public void calculatecoursestatistics(Course course) {
		int totalenroll = 0;
		double totalpay = 0;
		for (Enrollment enrollment : enrollments) {
			if (enrollment.getcourse().equals(course)) {
				totalenroll++;
			}
		}

		for (Payment payment : payments) {
			if (payment.getstudent().getenrolledcourses().contains(course)) {
				totalpay += payment.getpaymentamount();
			}
		}

		System.out.println("Course: " + course.getcourseName() + " Statistics:");
		System.out.println("Total Enrollments: " + totalenroll);
		System.out.println("Total Payments: " + totalpay);
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
	 public void addEnrollment(Student student, Course course, String enrollmentDate) throws InvalidEnrollmentDataException {
	        Enrollment enrollment = new Enrollment(enrollments.size() + 1, student, course, enrollmentDate);
	        enrollments.add(enrollment);
	        student.enrollincourse(course);
	        course.addenrollment(enrollment);
	    }
	 public void assignCourseToTeacher(Course course, Teacher teacher) {
	        teacher.assigncourse(course);
	        course.assignteacher(teacher);
	    }
	 public void addPayment(Student student, double amount, String paymentDate) throws InsufficientFundsException {
	        Payment payment = new Payment(payments.size() + 1, student, amount, paymentDate);
	        payments.add(payment);
	        student.makepayment(amount, paymentDate);
	    }
	 public List<Enrollment> getEnrollmentsForStudent(Student student) {
	        List<Enrollment> studentEnrollments = new ArrayList<>();
	        for (Enrollment enrollment : enrollments) {
	            if (enrollment.getstudent().equals(student)) {
	                studentEnrollments.add(enrollment);
	            }
	        }
	        return studentEnrollments;
	 }
	 public List<Course> getCoursesForTeacher(Teacher teacher) {
	        return teacher.getassignedcourses();
	    }

}
