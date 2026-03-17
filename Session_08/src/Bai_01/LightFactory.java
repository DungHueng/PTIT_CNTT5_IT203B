package Bai_01;

public class LightFactory extends DeviceFactory {
    public Function createDevice() {
        System.out.println("--- Đã tạo đèn mới ---");
        return new Light();
    }
}
