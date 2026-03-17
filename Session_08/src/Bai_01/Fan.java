package Bai_01;

public class Fan implements Function {
    public void turnOn() {
        System.out.println("Quạt: Quay.");
    }

    public void turnOff() {
        System.out.println("Quạt: Dừng.");
    }

    public void setLowSpeed() {
        System.out.println("Quạt: quay chạy tốc độ chậm");
    }
}
