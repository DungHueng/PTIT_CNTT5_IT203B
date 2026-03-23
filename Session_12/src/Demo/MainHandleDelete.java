package Demo;

import Demo.util.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainHandleDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Thao tac xoa bac si
        // B1: Nhap id bac si muon xoa
        System.out.println("Nhap vao ma bac si muon xoa");
        String idDelete = sc.nextLine();
        // B2: Mo ket noi
        try (Connection connection = DatabaseConnection.openConn()){
            // B3: Goi thu tuc
            CallableStatement callableStatement = connection.prepareCall("{call proc_delete_doctor_by_id(?)}");
            callableStatement.setString(1, idDelete);
            // B4: Su dung doi tuong CallableStatement de goi
            int row = callableStatement.executeUpdate();
            // B5: Thuc thi cau lenh executeUpdate();
            System.out.println(row);
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
