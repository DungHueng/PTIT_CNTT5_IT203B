package Demo;

import utils.DatabaseConnection;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestOpen {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        System.out.println("Chuan bi ket noi");
        Connection connection = DatabaseConnection.openConnection();

        // Statement
        // Viet cau lenh sql
        String sql = "SELECT * FROM students";
        try {
            // Khoi tao statement
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)
                );
            }
            while (rs.next()){
                System.out.println("ID: " +  rs.getInt("id"));
                System.out.println("Full Name: " +  rs.getString("full_name"));
                System.out.println("Age: " +  rs.getInt("age"));
                System.out.println("Address: " + rs.getString(4));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        students.forEach(System.out::println);

        //Them moi
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        String fullName = scanner.nextLine();
        System.out.println("Nhap tuoi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap dia chi: ");
        String address = scanner.nextLine();

        String sqlInsert = "INSERT INTO students (full_name, age, address) VALUE ('" + fullName + "'," +  age + "'," + address + "')";

        Statement handleInsert = null;
        try {
            handleInsert = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            handleInsert.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // PrepareStatement

        // CallableStatement

        System.out.println("Ket noi thanh cong");
    }
}
