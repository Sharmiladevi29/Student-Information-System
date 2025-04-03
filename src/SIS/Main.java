package SIS;

import java.util.Scanner;
import SIS.Sisexceptions.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sis sis = new Sis();
        
        try {
            // Creating students, courses, and teachers
            Student student1 = new Student(1, "John", "Doe", "2002-05-14", "john@example.com", "9876543210");
            Student student2 = new Student(2, "Alice", "Smith", "2001-08-21", "alice@example.com", "9123456789");
            Course course1 = new Course(101, "Java Programming", "CS101", "Dr. Smith");
            Course course2 = new Course(102, "Data Structures", "CS102", "Prof. Johnson");
            Teacher teacher1 = new Teacher(1, "Dr. James", "Brown", "james@university.com", "Computer Science");
            
            // Adding them to the system
            sis.addStudent(student1);
            sis.addStudent(student2);
            sis.addCourse(course1);
            sis.addCourse(course2);
            sis.addTeacher(teacher1);
            
            // Interactive menu
            while (true) {
                System.out.println("\nStudent Information System (SIS)");
                System.out.println("1. Enroll Student in Course");
                System.out.println("2. Assign Teacher to Course");
                System.out.println("3. Record Payment");
                System.out.println("4. Generate Enrollment Report");
                System.out.println("5. Generate Payment Report");
                System.out.println("6. Calculate Course Statistics");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        try {
                            sis.enrollStudentInCourse(student1, course1);
                            System.out.println("Student enrolled successfully.");
                        } catch (DuplicateEnrollmentException e) {
                            System.out.println("Error: Student is already enrolled in this course.");
                        } catch (CourseNotFoundException e) {
                            System.out.println("Error: Course not found.");
                        } catch (StudentNotFoundException e) {
                            System.out.println("Error: Student not found.");
                        } catch (InvalidEnrollmentDataException e) {
                            System.out.println("Enrollment Error: " + e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            sis.assignTeacherToCourse(teacher1, course1);
                            System.out.println("Teacher assigned successfully.");
                        } catch (TeacherNotFoundException e) {
                            System.out.println("Error: Teacher not found.");
                        }
                        break;
                    case 3:
                        try {
                            sis.recordPayment(student1, 500.0, "2025-04-01");
                            System.out.println("Payment recorded successfully.");
                        } catch (PaymentValidationException e) {
                            System.out.println("Payment Error: " + e.getMessage());
                        } catch (InsufficientFundsException e) {
                            System.out.println("Error: Insufficient funds for payment.");
                        }
                        break;
                    case 4:
                        sis.generateenrollmentreport(course1);
                        break;
                    case 5:
                        sis.generatepaymentreport(student1);
                        break;
                    case 6:
                        sis.calculatecoursestatistics(course1);
                        break;
                    case 7:
                        System.out.println("Exiting... Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (InvalidStudentDataException | InvalidCourseDataException | InvalidTeacherDataException e) {
            System.out.println("Data Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}
