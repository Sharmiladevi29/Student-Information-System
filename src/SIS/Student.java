package SIS;

import java.util.*;

class Student {
	private int studentID;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private String phoneNumber;
	private double balance;

	public double getBalance() {
		return this.balance;
	}

	List<Course> enrolledcourses = new ArrayList<>();
	List<Payment> paymenthistory = new ArrayList<>();

	public Student(int studentID, String firstName, String lastName, String dateOfBirth, String email,
			String phoneNumber) throws Sisexceptions.InvalidStudentDataException {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;

		if (firstName == null || firstName.isEmpty()) {
			throw new Sisexceptions.InvalidStudentDataException("Name cannot be empty.");
		}
		if (email == null || !email.contains("@")) {
			throw new Sisexceptions.InvalidStudentDataException("Invalid email format.");
		}
	}

	public void enrollincourse(Course course) {
		enrolledcourses.add(course);
	}

	public void UpdateStudent(int studentID, String firstName, String lastName, String dateOfBirth, String email,
			String phoneNumber) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void addFunds(double amount) {
	    if (amount > 0) {
	        this.balance += amount;
	    } else {
	        System.out.println("Invalid fund amount. Please enter a positive value.");
	    }
	}

	public void makepayment(double amount, String paymentDate) throws Sisexceptions.InsufficientFundsException {
	    if (amount > balance) {
	        throw new Sisexceptions.InsufficientFundsException("Insufficient funds. Please add more balance.");
	    }
	    
	    balance -= amount; // Deduct the payment from the balance
	    paymenthistory.add(new Payment(paymenthistory.size() + 1, this, amount, paymentDate));
	    System.out.println("Payment successful. Remaining balance: " + balance);
	}

	public void displaystudnetinfo() {
		System.out.println("StudentID: " + studentID + " Studentname: " + firstName + " " + lastName);
	}

	public List<Course> getenrolledcourses() {
		return enrolledcourses;
	}

	public List<Payment> getpaymenthistory() {
		return paymenthistory;
	}

	public String getfirstName() {
		return firstName;
	}

	public String getlastName() {
		return lastName;
	}

}