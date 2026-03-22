package Bai_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static String USERNAME = "admin";
    private static String PASSWORD = "med123";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection conn) {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }

    public void patients() throws SQLException {
        Connection conn = null;

        try {
            conn = DatabaseConnection.getConnection();
            System.out.println("--- Ket noi thanh cong! ---");
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
}
