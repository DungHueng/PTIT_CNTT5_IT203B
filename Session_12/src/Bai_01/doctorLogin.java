package Bai_01;
/**
 * PHẦN 1 - PHÂN TÍCH
 * Vấn đề:
 * - Sử dụng Statement và nối chuỗi trực tiếp để tạo câu lệnh SQL.
 * - Dữ liệu đầu vào (code, pass) được ghép thẳng vào câu query.
 *
 * Ví dụ lỗi:
 * String sql = "SELECT * FROM Doctors WHERE code = '" + code + "' AND pass = '" + pass + "'";
 * - Nếu người dùng nhập: pass = ' OR '1'='1
 * -> Câu SQL sẽ trở thành luôn đúng.
 *
 * Hậu quả:
 * - Bị tấn công SQL Injection.
 * - Hacker có thể đăng nhập mà không cần mật khẩu đúng.
 * - Có thể truy cập dữ liệu nhạy cảm (hồ sơ bệnh án).
 * - Nguy hiểm hơn: có thể sửa/xoá dữ liệu trong database.
 *
 * Ảnh hưởng trong hệ thống y tế:
 * - Lộ thông tin bệnh nhân (vi phạm bảo mật).
 * - Bác sĩ giả mạo truy cập hệ thống.
 * - Dữ liệu bị thay đổi → chẩn đoán sai → ảnh hưởng sức khỏe bệnh nhân.
 *
 * Giải pháp - Vì sao PreparedStatement là "tấm khiên":
 * - PreparedStatement sử dụng dấu ? thay vì nối chuỗi.
 * - Câu SQL được biên dịch trước (pre-compiled) bởi database.
 * - Dữ liệu đầu vào được truyền riêng, KHÔNG phải là một phần của câu lệnh SQL.
 *
 * Cơ chế bảo vệ:
 * - Input của người dùng được xem là dữ liệu thuần (plain data).
 * - Các ký tự đặc biệt như ' OR '1'='1 sẽ bị escape.
 * - Không thể thay đổi cấu trúc câu SQL ban đầu.
 *
 * So sánh:
 * - Statement -> SQL + data trộn lẫn → dễ bị inject.
 * - PreparedStatement → SQL cố định + data riêng → an toàn.
 *
 * Kết luận:
 * - PreparedStatement giúp ngăn chặn SQL Injection hiệu quả.
 * - Cần sử dụng PreparedStatement thay cho Statement khi làm việc với dữ liệu người dùng.
 */

import Bai_01.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class doctorLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap code bac si: ");
        String code = sc.nextLine();

        System.out.println("Nhap mat khau: ");
        String password = sc.nextLine();

        try (Connection connection = DatabaseConnection.openConn()){
            String sql = "SELECT * FROM doctors WHERE code = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("--- Dang nhap thanh cong ---");
            } else  {
                System.err.println("--- Sai ten tai khoan hoac mat khau ---");
            }
        } catch (SQLException e) {
            System.err.println("--- " + e.getMessage() + " ---");
        }

    }
}
