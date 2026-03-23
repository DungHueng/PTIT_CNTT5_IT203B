package Bai_03;

import Bai_03.utils.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * PHẦN 1 - PHÂN TÍCH
 * JDBC yêu cầu gọi registerOutParameter() trước khi thực thi vì chương trình cần khai báo trước kiểu dữ liệu của tham số đầu ra để JDBC biết cách nhận và chuyển dữ liệu từ Database về Java. Nếu không đăng ký trước, JDBC không biết kiểu dữ liệu để xử lý nên sẽ gây lỗi khi lấy giá trị.
 * Nếu tham số đầu ra trong SQL là kiểu DECIMAL, trong Java cần đăng ký bằng hằng số: Types.DECIMAL
 */

public class sugeryFee {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.openConn()){
            CallableStatement cstmt = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}");
            cstmt.setInt(1, 505);
            cstmt.registerOutParameter(2, Types.DECIMAL);
            cstmt.execute();
            double cost = cstmt.getDouble(2);
            System.out.println(cost);

        } catch (SQLException e) {
            System.err.println("--- " + e.getMessage() + " ---");
        }
    }
}
