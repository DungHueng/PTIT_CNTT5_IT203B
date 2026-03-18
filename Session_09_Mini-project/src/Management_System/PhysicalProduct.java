package Management_System;

public class PhysicalProduct extends Product {
    private String weight;

    public PhysicalProduct() {
    }

    public PhysicalProduct(String id, String name, double price, String weight) {
        super(id, name, price);
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void displayInfo(){
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Weight: " + getWeight());
    }
}
