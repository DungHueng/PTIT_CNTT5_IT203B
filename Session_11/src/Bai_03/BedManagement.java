package Bai_03;

import java.sql.Connection;
import java.sql.Statement;

public class BedManagement {
    public void updateBedStatus(Connection conn, int inputId) {
        try {
            Statement stmt = conn.createStatement();

            String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = " + inputId;

            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật giường bệnh thành công!");
            } else {
                System.out.println("Lỗi: Mã giường không tồn tại!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
