package SIS;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.Date;

public class Dbconnection {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties props = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\sha29\\eclipse-workspace\\StudentInformationSystem\\src\\SIS\\db.properties");

			props.load(fis);

			String url = props.getProperty("db.url").trim();
			String username = props.getProperty("db.username").trim();
			String password = props.getProperty("db.password").trim();
			String driver = props.getProperty("db.driver").trim();

			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("Connection error: " + e.getMessage());
		}
		return conn;
	}

	public static void simpleQuery(String table, String filterColumn, String filterValue, String orderByColumn) {
		String query = "SELECT * FROM " + table + " WHERE " + filterColumn + " = ?";

		if (orderByColumn != null && !orderByColumn.isEmpty()) {
			query += " ORDER BY " + orderByColumn;
		}

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, filterValue);

			ResultSet rs = ps.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(meta.getColumnName(i) + ": " + rs.getObject(i) + " | ");
				}
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Query failed: " + e.getMessage());
		}
	}

	public static void getAllStudents() {
		String query = "SELECT * FROM Students";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("student_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");

				System.out.println("Student ID: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving students: " + e.getMessage());
		}
	}

	public static void getAllCourses() {
		String query = "SELECT * FROM Courses";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int courseId = rs.getInt("course_id");
				String courseName = rs.getString("course_name");
				int credits = rs.getInt("credits");
				int teacherId = rs.getInt("teacher_id");

				System.out.println("Course ID: " + courseId + ", Name: " + courseName + ", Credits: " + credits
						+ ", Teacher ID: " + teacherId);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving courses: " + e.getMessage());
		}
	}

	public static void getAllTeachers() {
		String query = "SELECT * FROM Teacher";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("teacher_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");

				System.out.println("Teacher ID: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving teachers: " + e.getMessage());
		}
	}

	public static void getAllEnrollments() {
		String query = "SELECT * FROM Enrollments";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int enrollmentId = rs.getInt("enrollment_id");
				int studentId = rs.getInt("student_id");
				int courseId = rs.getInt("course_id");
				Date date = rs.getDate("enrollment_date");

				System.out.println("Enrollment ID: " + enrollmentId + ", Student ID: " + studentId + ", Course ID: "
						+ courseId + ", Date: " + date);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving enrollments: " + e.getMessage());
		}
	}

	// Retrieve all payments
	public static void getAllPayments() {
		String query = "SELECT * FROM Payments";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int paymentId = rs.getInt("payment_id");
				int studentId = rs.getInt("student_id");
				double amount = rs.getDouble("amount");
				Date paymentDate = rs.getDate("payment_date");

				System.out.println("Payment ID: " + paymentId + ", Student ID: " + studentId + ", Amount: " + amount
						+ ", Date: " + paymentDate);
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving payments: " + e.getMessage());
		}
	}

	public static void insertStudent(int studentid, String firstName, String lastName, String email, Date dob,
			String phone) {
		String query = "INSERT INTO Students(student_id, first_name, last_name, date_of_birth, email, phone_number) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

			if (email == null || !email.contains("@")) {
				System.out.println("Invalid email address.");
				return;
			}

			ps.setInt(1, studentid);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setDate(4, dob);
			ps.setString(5, email);
			ps.setString(6, phone);

			int rows = ps.executeUpdate();
			System.out.println(rows + " student(s) inserted.");

		} catch (SQLException e) {
			System.out.println("Error inserting student: " + e.getMessage());
		}
	}

	public static void updateStudentEmail(int studentId, String newEmail) {
		String query = "UPDATE Students SET email = ? WHERE student_id = ?";

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

			if (newEmail == null || !newEmail.contains("@")) {
				System.out.println("Invalid email address.");
				return;
			}

			ps.setString(1, newEmail);
			ps.setInt(2, studentId);

			int rows = ps.executeUpdate();
			System.out.println(rows + " student(s) updated.");

		} catch (SQLException e) {
			System.out.println("Error updating student email: " + e.getMessage());
		}
	}

	public static void insertEnrollment(int enrollmentid, int studentId, int courseId) {
		String query = "INSERT INTO Enrollments (enrollment_id,student_id, course_id, enrollment_date) VALUES (?,?,?,NOW())";

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, enrollmentid);
			ps.setInt(2, studentId);
			ps.setInt(3, courseId);

			int rows = ps.executeUpdate();
			System.out.println(rows + " enrollment(s) inserted.");

		} catch (SQLException e) {
			System.out.println("Error inserting enrollment: " + e.getMessage());
		}
	}

	public static void insertPayment(int paymentid, int studentId, double amount) {
		if (amount <= 0) {
			System.out.println("Amount must be greater than zero.");
			return;
		}

		String query = "INSERT INTO Payments (payment_id,student_id, amount, payment_date) VALUES (?,?,?,NOW())";

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, paymentid);
			ps.setInt(2, studentId);
			ps.setDouble(3, amount);

			int rows = ps.executeUpdate();
			System.out.println(rows + " payment(s) inserted.");

		} catch (SQLException e) {
			System.out.println("Error inserting payment: " + e.getMessage());
		}
	}

	public static void enrollStudentWithTransaction(int enrollmentId, int studentId, int courseId, int paymentId,
			double amount) {
		String enrollmentQuery = "INSERT INTO Enrollments (enrollment_id, student_id, course_id, enrollment_date) VALUES (?, ?, ?, NOW())";
		String paymentQuery = "INSERT INTO Payments (payment_id, student_id, amount, payment_date) VALUES (?, ?, ?, NOW())";

		try (Connection conn = getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement enrollStmt = conn.prepareStatement(enrollmentQuery);
					PreparedStatement paymentStmt = conn.prepareStatement(paymentQuery)) {

				enrollStmt.setInt(1, enrollmentId);
				enrollStmt.setInt(2, studentId);
				enrollStmt.setInt(3, courseId);
				enrollStmt.executeUpdate();

				paymentStmt.setInt(1, paymentId);
				paymentStmt.setInt(2, studentId);
				paymentStmt.setDouble(3, amount);
				paymentStmt.executeUpdate();

				conn.commit();
				System.out.println("Enrollment and payment successful!");

			} catch (SQLException e) {
				conn.rollback();
				System.out.println("Transaction failed, rolled back. Reason: " + e.getMessage());
			} finally {
				conn.setAutoCommit(true);
			}

		} catch (SQLException e) {
			System.out.println("Connection or rollback error: " + e.getMessage());
		}
	}

	public static void enrollNewStudentWithCourses(int enrollmentid, int studentId, String firstName, String lastName,
			Date dob, String email, String phone, int[] courseIds, Date enrollment_date) {
		try (Connection conn = getConnection()) {
			String insertStudent = "INSERT INTO Students (student_id, first_name, last_name, date_of_birth, email, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement studentStmt = conn.prepareStatement(insertStudent);
			studentStmt.setInt(1, studentId);
			studentStmt.setString(2, firstName);
			studentStmt.setString(3, lastName);
			studentStmt.setDate(4, dob);
			studentStmt.setString(5, email);
			studentStmt.setString(6, phone);
			studentStmt.executeUpdate();

			for (int courseId : courseIds) {
				String enrollSQL = "INSERT INTO Enrollments (enrollment_id,student_id, course_id,enrollment_date) VALUES (?,?,?,?)";
				PreparedStatement enrollStmt = conn.prepareStatement(enrollSQL);
				enrollStmt.setInt(1, enrollmentid);
				enrollStmt.setInt(2, studentId);
				enrollStmt.setInt(3, courseId);
				enrollStmt.setDate(4, enrollment_date);
				enrollStmt.executeUpdate();
			}

			System.out.println("Student enrolled successfully!");
		} catch (SQLException e) {
			System.out.println("Enrollment failed: " + e.getMessage());
		}
	}

	public static void enrollJohnDoe() {
		int enrollmentid = 419;
		int studentId = 128;
		String firstName = "John";
		String lastName = "Doe";
		Date dob = Date.valueOf("1995-08-15");
		String email = "johnyy.doee@example.com";
		String phone = "823385091";
		int[] courseIds = { 301, 302, 303 };
		Date enrollmentDate = Date.valueOf("2025-04-06");

		enrollNewStudentWithCourses(enrollmentid, studentId, firstName, lastName, dob, email, phone, courseIds,
				enrollmentDate);
	}

	public static void assignTeacherToCourse(int teacherid, String firstName, String lastName, String email,
			int courseId) {
		try (Connection conn = getConnection()) {

			String insertTeacher = "INSERT INTO Teacher (teacher_id,first_name, last_name, email) VALUES (?,?,?,?)";
			PreparedStatement teacherStmt = conn.prepareStatement(insertTeacher, Statement.RETURN_GENERATED_KEYS);
			teacherStmt.setInt(1, teacherid);
			teacherStmt.setString(2, firstName);
			teacherStmt.setString(3, lastName);
			teacherStmt.setString(4, email);
			teacherStmt.executeUpdate();

			ResultSet rs = teacherStmt.getGeneratedKeys();
			int teacherId = -1;
			if (rs.next()) {
				teacherId = rs.getInt(1);
			}

			if (teacherId == -1) {
				System.out.println("Teacher ID not generated.");
				return;
			}

			String updateCourse = "UPDATE Courses SET teacher_id = ? WHERE course_id = ?";
			PreparedStatement courseStmt = conn.prepareStatement(updateCourse);
			courseStmt.setInt(1, teacherId);
			courseStmt.setInt(2, courseId);
			int rowsUpdated = courseStmt.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Teacher assigned to course successfully!");
			} else {
				System.out.println("Course not found.");
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void assignSarahSmithToCourse() {
		assignTeacherToCourse(213, "Sarah", "Smith", "sarah.smith@example.com", 302);
	}

	public static void updateJaneBalance() {
		int studentId = 101;
		double paymentAmount = 500.00;

		try (Connection conn = getConnection()) {
			String updateSQL = "UPDATE Students SET outstanding_balance = outstanding_balance - ? WHERE student_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateSQL);
			pstmt.setDouble(1, paymentAmount);
			pstmt.setInt(2, studentId);

			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("Jane's balance updated successfully.");
			} else {
				System.out.println("Student not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void generateEnrollmentReport(String courseName) {
		String query = "SELECT c.course_name, s.student_id, CONCAT(s.first_name, ' ', s.last_name) AS student_name, e.enrollment_date "
				+ "FROM Enrollments e " + "JOIN Students s ON e.student_id = s.student_id "
				+ "JOIN Courses c ON e.course_id = c.course_id " + "WHERE c.course_name = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setString(1, courseName);
			ResultSet rs = pstmt.executeQuery();

			System.out.println("Enrollment Report for: " + courseName);
			System.out.println("--------------------------------------------------");
			boolean found = false;

			while (rs.next()) {
				found = true;
				String studentName = rs.getString("student_name");
				int studentId = rs.getInt("student_id");
				Date enrollmentDate = rs.getDate("enrollment_date");

				System.out.println("Student ID: " + studentId);
				System.out.println("Student Name: " + studentName);
				System.out.println("Enrollment Date: " + enrollmentDate);
				System.out.println("--------------------------------------------");
			}

			if (!found) {
				System.out.println("No students enrolled in this course.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Dbconnection db = new Dbconnection();
		db.generateEnrollmentReport("Science");

		updateJaneBalance();
		assignSarahSmithToCourse();
		enrollJohnDoe();

		getAllStudents();
		getAllCourses();
		getAllTeachers();
		getAllEnrollments();
		getAllPayments();
		enrollStudentWithTransaction(416, 155, 302, 528, 7500.0);

		int id = 155;
		String firstName = "Varalakshmi";
		String lastName = "Devi";
		String email = "devi@demo.com";
		Date dob = Date.valueOf("1992-08-15");
		String phone = "9876543710";

		Dbconnection.insertStudent(id, firstName, lastName, email, dob, phone);
		updateStudentEmail(108, "devi.updated@mail.com");
		insertEnrollment(415, 102, 303);
		insertPayment(518, 109, 5000.0);

	}
}
