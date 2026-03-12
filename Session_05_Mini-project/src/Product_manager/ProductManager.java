package Product_manager;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductManager {
    ArrayList<Product> products =  new ArrayList<>();

    public void createProduct(Product product){
        if(products.stream().anyMatch(product1 -> product1.getId() == product.getId())) {
            throw new IllegalArgumentException("Id nay da ton tai");
        }
        products.add(product);
    }
    public void displayProducts(){
        System.out.println("------- PRODUCTS -------");
        System.out.println("ID: " + products.get(1).getId());
        System.out.println("NAME: " + products.get(1).getName());
        System.out.println("PRICE: " + products.get(1).getPrice());
        System.out.println("QUANTITY: " + products.get(1).getQuantity());
        System.out.println("CATEGORY: " + products.get(1).getCategory());
        System.out.println("------------------------");
        products.forEach(System.out::println);
    }
    public void updateProduct(int id, int newProduct){
        Optional<Product> product = products.stream().filter(product1 -> product1.getId() == id).findFirst();
        if(product.isPresent()){
            product.get().setQuantity(newProduct);
        } else {
            throw new IndexOutOfBoundsException("Khong tim thay san pham");
        }
    }
    public void deleteProduct(){
        products = (ArrayList<Product>) products.stream().filter(product -> product.getQuantity() > 0).collect(Collectors.toList());
    }
}
