package Bai_01;

public class AirConditionerFactory extends DeviceFactory {
    public Function createDevice() {
        System.out.println("--- Đã tạo điều hòa mới ---");
        return new AirConditioner();
    }
}
