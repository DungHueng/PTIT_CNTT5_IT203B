package Bai_03.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final static String driver = "com.mysql.cj.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost:3306/getSurgeryFee";
    private final static String username = "root";
    private final static String password = "123456";

    // phuong thuc ket noi
    public static Connection openConn(){
        Connection conn;

        // Khai bao cho class biet driver
        try {
            Class.forName(driver);

            // Mo ket noi
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
