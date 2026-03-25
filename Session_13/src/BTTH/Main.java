package BTTH;

import BTTH.utils.DataConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Thiet lap thu tuc
        Connection conn = DataConnect.openConn();
        int patientId = 101;
            try {
                conn.setAutoCommit(false);
                String sqlInvoices = """
                        INSERT INTO invoices (patient_id, amount, create_date) VALUE (?, ?, ?)
                        """;
                String sqlPatient = """
                        UPDATE patient SET status = ? WHERE id = ?
                        """;
                String sqlBed = """
                        UPDATE beds SET status = ? WHERE id = ?;
                        """;

                // - Lap hoa don
                PreparedStatement preparedInvoices = conn.prepareStatement(sqlInvoices);
                preparedInvoices.setInt(1, patientId);
                preparedInvoices.setDouble(2, 10000000);
                preparedInvoices.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

                // - Cap nhat trang thai benh nhan
                PreparedStatement preparedPatient = conn.prepareStatement(sqlPatient);
                preparedPatient.setString(1, "Da xuat vien");
                preparedPatient.setInt(2, patientId);

                // - Cap nhat tinh trang giuong benh
                PreparedStatement preparedBeds = conn.prepareStatement(sqlBed);
                preparedBeds.setString(1, "Trong");
                preparedBeds.setString(2, "G01");

                preparedInvoices.executeUpdate();
                preparedBeds.executeUpdate();
                preparedBeds.executeUpdate();

                System.out.println("Da xuat vien thanh cong");

                conn.commit();

            } catch (SQLException e) {
                    conn.rollback();
                    System.err.println(e.getMessage());
                } finally {
                conn.close();
            }
        }
    }
