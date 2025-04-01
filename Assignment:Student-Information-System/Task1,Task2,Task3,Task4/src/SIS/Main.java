package SIS;

import SIS.Sisexceptions.InvalidCourseDataException;
import SIS.Sisexceptions.InvalidEnrollmentDataException;
import SIS.Sisexceptions.InvalidStudentDataException;
import SIS.Sisexceptions.InvalidTeacherDataException;

public class Main {
    public static void main(String[] args) throws InvalidCourseDataException, InvalidStudentDataException, InvalidTeacherDataException, InvalidEnrollmentDataException {

        Student student1 = new Student(1, "John", "Doe", "2002-05-14", "john@example.com", "9876543210");
        Student student2 = new Student(2, "Alice", "Smith", "2001-08-21", "alice@example.com", "9123456789");
        Course course1 = new Course(101, "Java Programming", "CS101", "Dr. Smith");
        Course course2 = new Course(102, "Data Structures", "CS102", "Prof. Johnson");
        Teacher teacher1 = new Teacher(1, "Dr. James", "Brown", "james@university.com", "Computer Science");

        Sis sis = new Sis();

        sis.addStudent(student1);
        sis.addStudent(student2);
        sis.addCourse(course1);
        sis.addCourse(course2);
        sis.addTeacher(teacher1);

        try {
            sis.enrollStudentInCourse(student1, course1);
            sis.enrollStudentInCourse(student2, course2);

            sis.assignTeacherToCourse(teacher1, course1);

            sis.recordPayment(student1, 500.0, "2025-04-01");
            sis.recordPayment(student2, 400.0, "2025-04-02");

            sis.generateenrollmentreport(course1);
            sis.generatepaymentreport(student1);

            sis.calculatecoursestatistics(course1);

        } catch (Sisexceptions.DuplicateEnrollmentException | 
                 Sisexceptions.CourseNotFoundException | 
                 Sisexceptions.StudentNotFoundException | 
                 Sisexceptions.InsufficientFundsException | 
                 Sisexceptions.TeacherNotFoundException | 
                 Sisexceptions.PaymentValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
