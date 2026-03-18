package Management_System;

public class DigitalProduct extends Product {
    private double sizeMB;

    public DigitalProduct() {
    }

    public DigitalProduct(String id, String name, double price, double sizeMB) {
        super(id, name, price);
        this.sizeMB = sizeMB;
    }

    public double getSizeMB() {
        return sizeMB;
    }

    public void setSizeMB(double sizeMB) {
        this.sizeMB = sizeMB;
    }

    public void displayInfo(){
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Size: " + getSizeMB());
    }
}
