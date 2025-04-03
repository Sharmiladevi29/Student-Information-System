package SIS;

public class Sisexceptions {

	// duplicate enrollment
	public static class DuplicateEnrollmentException extends Exception {
		public DuplicateEnrollmentException(String message) {
			super(message);
		}
	}

	// course not found
	public static class CourseNotFoundException extends Exception {
		public CourseNotFoundException(String message) {
			super(message);
		}
	}

	// student not found
	public static class StudentNotFoundException extends Exception {
		public StudentNotFoundException(String message) {
			super(message);
		}
	}

	// teacher not found
	public static class TeacherNotFoundException extends Exception {
		public TeacherNotFoundException(String message) {
			super(message);
		}
	}

	// insufficient funds
	public static class InsufficientFundsException extends Exception {
		public InsufficientFundsException(String message) {
			super(message);
		}
	}

	// payment validation
	public static class PaymentValidationException extends Exception {
		public PaymentValidationException(String message) {
			super(message);
		}
	}

	// invalid student data
	public static class InvalidStudentDataException extends Exception {
		public InvalidStudentDataException(String message) {
			super(message);
		}
	}

	// invalid course data
	public static class InvalidCourseDataException extends Exception {
		public InvalidCourseDataException(String message) {
			super(message);
		}
	}

	// invalid enrollment data
	public static class InvalidEnrollmentDataException extends Exception {
		public InvalidEnrollmentDataException(String message) {
			super(message);
		}
	}

	// invalid teacher data
	public static class InvalidTeacherDataException extends Exception {
		public InvalidTeacherDataException(String message) {
			super(message);
		}
	}
}
