package Product_manager;

import java.util.ArrayList;
import java.util.Optional;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();

    public void createProduct(Product product) throws InvalidProductException {
        if(products.stream().anyMatch(p -> p.getId() == product.getId())) {
            throw new InvalidProductException("ID đã tồn tại!");
        }
        products.add(product);
    }

    public void displayProducts() {
        if(products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        System.out.println("------- DANH SÁCH SẢN PHẨM -------");
        products.forEach(System.out::println);
        System.out.println("----------------------------------");
    }

    public void updateProduct(int id, int newQuantity) throws InvalidProductException {
        Optional<Product> product = products.stream().filter(p -> p.getId() == id).findFirst();
        if(product.isPresent()){
            product.get().setQuantity(newQuantity);
        } else {
            throw new InvalidProductException("Không tìm thấy sản phẩm với ID: " + id);
        }
    }

    public void deleteProduct(){
        products.removeIf(p -> p.getQuantity() == 0);
    }
}
