package casestudy.crimeanalysis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
            	FileInputStream fis = new FileInputStream("C:\\Users\\sha29\\eclipse-workspace\\Crimeanalysis\\src\\casestudy\\crimeanalysis\\db.properties");

            	//InputStream fis = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");

                if (fis == null) {
                    throw new IOException("Properties file not found in classpath!");
                }

                Properties props = new Properties();
                props.load(fis);

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.username");
                String pass = props.getProperty("db.password");
                String driver = props.getProperty("db.driver");

                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, pass);
                System.out.println("Connection established successfully!");

            } catch (SQLException | IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
