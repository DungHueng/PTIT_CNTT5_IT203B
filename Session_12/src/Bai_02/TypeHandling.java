package Bai_02;

import Bai_02.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * PHẦN 1 - PHÂN TÍCH
 * Vấn đề:
 * - Sử dụng Statement và nối chuỗi để cập nhật dữ liệu số (double, int).
 * - Khi nối chuỗi, giá trị số sẽ bị chuyển thành String.
 *
 * Ví dụ lỗi:
 * double temp = 37.5;
 * String sql = "UPDATE Vitals SET temperature = " + temp;
 * - Trong một số hệ điều hành (locale Pháp/Việt),
 *   số thực có thể được biểu diễn là 37,5 (dùng dấu phẩy).
 *
 * Hậu quả:
 * - SQL chỉ chấp nhận dấu chấm (37.5), không chấp nhận dấu phẩy (37,5).
 * - Gây lỗi cú pháp SQL (SQLSyntaxErrorException).
 * - Dữ liệu không được cập nhật vào database.
 *
 * Ảnh hưởng trong hệ thống y tế:
 * - Không cập nhật được nhiệt độ, nhịp tim của bệnh nhân.
 * - Dữ liệu sai hoặc thiếu → ảnh hưởng đến theo dõi sức khỏe.
 *
 * Giải pháp - Vì sao PreparedStatement giải quyết được:
 * - PreparedStatement sử dụng các phương thức setDouble(), setInt().
 * - Dữ liệu được truyền đúng kiểu (double, int), KHÔNG chuyển thành chuỗi.
 *
 * Cơ chế hoạt động:
 * - Driver JDBC sẽ tự động chuyển đổi dữ liệu sang định dạng phù hợp với database.
 * - Không phụ thuộc vào locale của hệ điều hành.
 * - Dù nhập 37.5 hay hệ thống dùng 37,5 → vẫn xử lý đúng.
 *
 * Kết luận:
 * - PreparedStatement giúp xử lý đúng kiểu dữ liệu.
 * - Tránh lỗi định dạng số do khác biệt vùng miền (locale).
 */

public class TypeHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Id cua benh nhan: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap nhiet do cua benh nhan: ");
        Double temperature = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap nhip tim cua benh nhan: ");
        int heartBeat = Integer.parseInt(sc.nextLine());

        try(Connection connection = DatabaseConnection.openConn()){
            String sql = "UPDATE vitals SET temperature = ?, heartBeat = ? WHERE p_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, temperature);
            preparedStatement.setInt(2, heartBeat);
            preparedStatement.setInt(3, id);
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
        } catch (SQLException e) {
            System.err.println("--- " + e.getMessage() + " ---");
        }
    }
}
