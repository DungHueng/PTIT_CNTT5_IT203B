package Bai_01;

public class FanFactory extends DeviceFactory {
    public Function createDevice() {
        System.out.println("--- Đã tạo quạt mới ---");
        return new Fan();
    }
}
