package Management_System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductDatabase database = new ProductDatabase();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.print("""
                    ---------------------- QUẢN LÝ SẢN PHẨM ----------------------
                    1. Thêm mới sản phẩm
                    2. Xem danh sách sản phẩm
                    3. Cập nhật thông tin sản phẩm
                    4. Xoá sản phẩm
                    5. Thoát
                    -----------------------------------------------------------------------
                    Lựa chọn của bạn: 
                    """);
            choice = scanner.nextInt();
            scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập id: ");
                        String id = scanner.nextLine();
                        System.out.println("Nhập tên product: ");
                        String name = scanner.nextLine();
                        System.out.println("Nhập giá tiền: ");
                        double price = scanner.nextDouble();

                        database.addProduct(new Product(id, name, price){
                            @Override
                            public String toString() {
                                return "[ Id: " + id + ", Name: " + name + ", Price: " + price + " ]";
                            }
                        });
                        break;
                    case 2:
                        database.displayProducts();
                        break;
                    case 3:
                        System.out.println("Nhập id cần update: ");
                        String updateId = scanner.nextLine();
                        System.out.println("Nhập tên product cần update: ");
                        String updateName = scanner.nextLine();
                        System.out.println("Nhập giá tiền cần update: ");
                        double updatePrice = scanner.nextDouble();
                        database.updateProduct(new Product(updateId, updateName, updatePrice){
                            @Override
                            public String toString() {
                                return "[ Id: " + updateId + ", Name: " + updateName + ", Price: " + updatePrice + " ]";
                            }
                        });
                        break;
                    case 4:
                        database.deleteProduct();
                        System.out.println("--- Đã xoá sản phẩm ---");
                        break;
                    case 5:
                        System.out.println("--- Thoát chương trình thành công ---");
                        break;
                    default:
                        System.err.println("--- Lựa chọn không hợp lệ ---");
                        break;
            }
        } while (choice != 5);
    }
}
