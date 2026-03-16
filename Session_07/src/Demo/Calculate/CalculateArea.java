package Demo.Calculate;

public class CalculateArea {
    public double getArea(String shape){
        if (shape.equals("HCN")){
            System.out.println("Tinh toan hinh chu nhat");
        } else if (shape.equals("HV")) {
            System.out.println("Tinh toan hinh vuong");
        } else if (shape.equals("HT")) {
            System.out.println("Tinh dien tich hinh tron");
        }
        return 0;
    }
}
