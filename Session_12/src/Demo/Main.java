package Demo;

import Demo.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Tao database (hospital)
        // tao bang doctor (id, doctorName, gender, age, department)

        // Yeu cau nhap vao thong tin de them moi du lieu vao database
        // B1: Mo ket noi
        try (Connection connection = DatabaseConnection.openConn()){
            // B2: Viet cau lenh SQL
            String sql = "INSERT INTO doctors VALUES (?, ?, ?, ?, ?)";
            // B3: Khoi tao doi tuong preparedStatment
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 2; i++) {
                // B4: Set paramenter (Tham so) vao
                System.out.print("Nhap ma bac si: ");
                preparedStatement.setString(1, sc.nextLine());
                System.out.print("Nhap ten bac si: ");
                preparedStatement.setString(2, sc.nextLine());
                System.out.print("Nhap gioi tinh: ");
                preparedStatement.setString(3, sc.nextLine());
                System.out.print("Nhap tuoi: ");
                preparedStatement.setInt(4, Integer.parseInt(sc.nextLine()));
                System.out.print("Nhap khoa: ");
                preparedStatement.setString(5, sc.nextLine());
                // B5: Thuc thi cau lenh
                int row = preparedStatement.executeUpdate();
                // Thuc thi xong thi phai set lai parameter ve null
                System.out.println(row);
            }
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
