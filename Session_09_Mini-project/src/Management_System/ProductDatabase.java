package Management_System;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDatabase {
    List<Product> products =  new ArrayList<>();

public void addProduct(Product product){
    if(products.stream().anyMatch(p -> p.getId() == product.getId())){
        System.err.println("--- Product này đã tồn tại ---");
    }
    products.add(product);
}
public void displayProducts(){
    if(products.isEmpty()) {
        System.out.println("Danh sách sản phẩm trống!");
        return;
    }
    System.out.println("------- DANH SÁCH SẢN PHẨM -------");
    products.forEach(System.out::println);
    System.out.println("----------------------------------");
}
public void updateProduct(Product product){
    Optional<Product> found = products.stream().filter(p -> p.getId() == product.getId()).findFirst();
    if(found.isPresent()){
        found.get().setName(product.getName());
        found.get().setPrice(product.getPrice());
    } else {
        System.err.println("--- Không tìm thấy product ---");
    }
}
public void deleteProduct(){
    products.removeIf(product -> product.getId() == product.getId());
}
}
