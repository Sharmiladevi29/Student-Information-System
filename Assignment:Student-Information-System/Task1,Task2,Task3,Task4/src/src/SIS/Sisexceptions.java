package SIS;

public class Sisexceptions {

	    
	    // Custom exception for duplicate enrollment
	    public static class DuplicateEnrollmentException extends Exception {
	        public DuplicateEnrollmentException(String message) {
	            super(message);
	        }
	    }
	    
	    // Custom exception for course not found
	    public static class CourseNotFoundException extends Exception {
	        public CourseNotFoundException(String message) {
	            super(message);
	        }
	    }
	    
	    // Custom exception for student not found
	    public static class StudentNotFoundException extends Exception {
	        public StudentNotFoundException(String message) {
	            super(message);
	        }
	    }
	    
	    // Custom exception for teacher not found
	    public static class TeacherNotFoundException extends Exception {
	        public TeacherNotFoundException(String message) {
	            super(message);
	        }
	    }
	    
	    // Custom exception for insufficient funds
	    public static class InsufficientFundsException extends Exception {
	        public InsufficientFundsException(String message) {
	            super(message);
	        }
	    }
	    
	    // Custom exception for payment validation
	    public static class PaymentValidationException extends Exception {
	        public PaymentValidationException(String message) {
	            super(message);
	        }
	    }
	    
	    // Custom exception for invalid student data
	    public static class InvalidStudentDataException extends Exception {
	        public InvalidStudentDataException(String message) {
	            super(message);
	        }
	    }
	    
	    // Custom exception for invalid course data
	    public static class InvalidCourseDataException extends Exception {
	        public InvalidCourseDataException(String message) {
	            super(message);
	        }
	    }
	    
	    // Custom exception for invalid enrollment data
	    public static class InvalidEnrollmentDataException extends Exception {
	        public InvalidEnrollmentDataException(String message) {
	            super(message);
	        }
	    }
	    
	    // Custom exception for invalid teacher data
	    public static class InvalidTeacherDataException extends Exception {
	        public InvalidTeacherDataException(String message) {
	            super(message);
	        }
	    }
	}
