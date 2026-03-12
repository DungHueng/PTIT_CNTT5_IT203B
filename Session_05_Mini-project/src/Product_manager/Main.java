package Product_manager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager ProductManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
                    ========= PRODUCT MANAGEMENT SYSTEM =========
                    1. Them san pham moi
                    2. Hien thi danh sach san pham
                    3. Cap nhat so luong theo Id
                    4. Xoa san pham het hang
                    5. Thoat chuong trinh
                    =============================================
                    Lua chon cua ban:
                    """);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhap id: ");
                    int id = scanner.nextInt();
                    System.out.println("Nhap ten: ");
                    String name = scanner.nextLine();
                    System.out.println("Nhap gia tien: ");
                    double price = scanner.nextDouble();
                    System.out.println("Nhap so luong: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Nhap danh muc: ");
                    String category = scanner.nextLine();
                    ProductManager.createProduct(new Product(id, name, price, quantity, category));
                    break;
                case 2:
                    ProductManager.deleteProduct();
                    break;
                case 3:
                    System.out.println("Nhap id ban muon cap nhat: ");
                    int updateId = scanner.nextInt();
                    System.out.println("Nhap so luong can cap nhat: ");
                    int updateQuantity = scanner.nextInt();
                    ProductManager.updateProduct(updateId,updateQuantity);
                    break;
                case 4:
                    ProductManager.deleteProduct();
                    System.out.println("Da xoa san pham");
                    break;
                case 5:
                    System.out.println("Thoat thanh cong");
                    break;
                    default:
                        System.err.println("--- Lua chon khong hop le ---");
            }
        } while (choice != 5);
    }
}
