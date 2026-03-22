package Bai_02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PharmacyCatalogue {
    public void showMedicines(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");

        while (rs.next()) {
            System.out.println(
                    "Thuốc: " + rs.getString("medicine_name") +
                            " | Tồn kho: " + rs.getInt("stock")
            );
        }
    }
}
