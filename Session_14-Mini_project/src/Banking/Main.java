package Banking;

import Banking.utils.DataConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = DataConnect.openConn();
        try {
            conn.setAutoCommit(false);
            String sqlSender = "UPDATE accounts SET balance = balance - ? WHERE accountId = ?";
            String sqlDeposit = "UPDATE accounts SET balance = balance + ? WHERE accountId = ?";

            int senderId = 1;
            int receiverId = 2;

            PreparedStatement preparedSQLSender = conn.prepareStatement(sqlSender);
            preparedSQLSender.setInt(1, senderId);
            preparedSQLSender.setInt(2, receiverId);

            PreparedStatement preparedSQLDeposit = conn.prepareStatement(sqlDeposit);
            preparedSQLDeposit.setInt(1, senderId);
            preparedSQLDeposit.setInt(2, receiverId);

            preparedSQLSender.executeUpdate();
            preparedSQLDeposit.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            try {
                try {
                    conn.rollback();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
                System.err.println(e.getMessage());
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
