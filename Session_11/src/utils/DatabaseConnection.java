package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/medicalAppointmentsDB?createDatabaseifnotexits"; // phu thuoc vao port mySQL
    private static String USERNAME = "root";
    private static String PASSWORD = "123456";

    // phuong thuc mo ket noi
    public static Connection openConnection() {
        Connection connection;
        try {
            Class.forName(DRIVER); // Khai bao cho java biet driver
            // mo ket noi den database
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    // phuong thuc dong ket noi
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
