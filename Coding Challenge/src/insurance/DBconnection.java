package insurance;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnection {

	private static Connection connection = null;

	public static String getPropertyString(String filePath) {
		Properties props = new Properties();
		String url = null;

		try (FileInputStream fis = new FileInputStream(filePath)) {
			props.load(fis);
			url = props.getProperty("db.url") + "?user=" + props.getProperty("db.username") + "&password="
					+ props.getProperty("db.password");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return url;
	}

	public static Connection getConnection() {
		if (connection == null) {
			try {
				String path = "C:\\Users\\sha29\\eclipse-workspace\\insurance\\src\\db.properties";
				String url = getPropertyString(path);
				connection = DriverManager.getConnection(url);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}