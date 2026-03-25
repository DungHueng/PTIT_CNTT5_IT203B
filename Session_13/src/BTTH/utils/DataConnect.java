package BTTH.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    private final static String driver = "com.mysql.cj.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost:3306/my_hospital?createDatabaseIfNotExist=true";
    private final static String user = "root";
    private final static String password = "123456";

    public static Connection openConn() {
        Connection conn;
        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}

