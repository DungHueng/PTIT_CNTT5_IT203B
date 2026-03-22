package Bai_04;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLInjection {
    public void searchPatient(Connection conn, String inputName) {
        try {
            Statement stmt = conn.createStatement();

            String patientName = inputName;
            patientName = patientName.replace("'", "");
            patientName = patientName.replace("--", "");
            patientName = patientName.replace(";", "");

            String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Tên: " + rs.getString("full_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
