package Demo;

import Demo.util.DatabaseConnection;

import java.sql.*;

public class HandleGetAVGAge {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.openConn()){
            CallableStatement callableStatement = connection.prepareCall("{call proc_get_avg_age_doctor(?)}");
            // register dang ky tham so out
            callableStatement.registerOutParameter(1, Types.DOUBLE);
            // Thuc thi cau lenh
            callableStatement.execute();
            // Lay gia tri cua tham so out o thu thuc
            Double result = callableStatement.getDouble(1);
            System.out.println(result);
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}