package Bai_01;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HỆ THỐNG QUẢN LÝ BỆNH NHÂN ===");

        DatabaseConnection service = new DatabaseConnection();

        service.getPatients();

        System.out.println("=== KẾT THÚC ===");
    }
}
