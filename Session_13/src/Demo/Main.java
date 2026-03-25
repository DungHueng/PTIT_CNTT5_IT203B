package Demo;

import Demo.utils.DataConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
    /**
     * Bai Toan:
     * - THuc hien chuyen tu A -> B 10tr
     * - TestCase:
     *  + test dung chuyen duoc
     *  + test sai co loi xay ra trong giao dich
     * */
    // Mo ket noi
        Connection conn = DataConnect.openConn();
        try {
            // B1: Tat autocommit
            conn.setAutoCommit(false);
            // B2: Thuc thi code
            /* Tru tien tai khoan sender
            * Tao transfer lich su
            * Cong tien vao tai khoan recive*/
            String sqlWithdraw = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            String sqlTransfer = "INSERT INTO transfer (sender_id, receive_id, amount, message, transfer_date) VALUES (?, ?, ?, ?, ?)";
            String sqlDeposit = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            double amount = 9000000.0;
            int senderId = 1;
            int receiveId = 2;

            PreparedStatement preparedWithdraw = conn.prepareStatement(sqlWithdraw);
            preparedWithdraw.setDouble(1, amount);
            preparedWithdraw.setInt(2, senderId);

            PreparedStatement preparedTransfer = conn.prepareStatement(sqlTransfer);
            preparedTransfer.setInt(1, senderId);
            preparedTransfer.setInt(2, receiveId);
            preparedTransfer.setDouble(3, amount);
            preparedTransfer.setString(4, "tieu di");
            preparedTransfer.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

            PreparedStatement preparedDeposit = conn.prepareStatement(sqlDeposit);
            preparedDeposit.setDouble(1, amount);
            preparedDeposit.setInt(2, receiveId);

            preparedWithdraw.executeUpdate();
            preparedTransfer.executeUpdate();
            preparedDeposit.executeUpdate();

            // B3: commit
            conn.commit();
        } catch (SQLException e) {
            // B4: RollBack
            try {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                System.err.println("--- " + e.getMessage() + " ---");
            } finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}