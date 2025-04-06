package casestudy.crimeanalysis;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class testCrime {

    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Incidents");

            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Table: Incidents\n----------------------------");

            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.println(meta.getColumnName(i) + " | " + meta.getColumnTypeName(i) + " | " + meta.getPrecision(i));
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
