package Product_manager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
                    ========= PRODUCT MANAGEMENT SYSTEM =========
                    1. Thêm sản phẩm mới
                    2. Hiển thị danh sách sản phẩm
                    3. Cập nhật số lượng theo Id
                    4. Xóa sản phẩm đã hết hàng
                    5. Thoát chương trình
                    =============================================
                    Lựa chọn của bạn:
                    """);
            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Nhập id: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nhập tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập giá tiền: ");
                        double price = scanner.nextDouble();
                        System.out.print("Nhập số lượng: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nhập danh mục: ");
                        String category = scanner.nextLine();

                        productManager.createProduct(new Product(id, name, price, quantity, category));
                        System.out.println("Thêm sản phẩm thành công!");
                        break;
                    case 2:
                        productManager.displayProducts();
                        break;
                    case 3:
                        System.out.print("Nhập id cần cập nhật: ");
                        int updateId = scanner.nextInt();
                        System.out.print("Nhập số lượng mới: ");
                        int updateQuantity = scanner.nextInt();
                        productManager.updateProduct(updateId, updateQuantity);
                        System.out.println("Cập nhật thành công!");
                        break;
                    case 4:
                        productManager.deleteProduct();
                        System.out.println("Đã xóa các sản phẩm hết hàng!");
                        break;
                    case 5:
                        System.out.println("Thoát chương trình thành công!");
                        break;
                    default:
                        System.err.println("--- Lựa chọn không hợp lệ ---");
                }
            } catch (InvalidProductException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        } while (choice != 5);
    }
}
