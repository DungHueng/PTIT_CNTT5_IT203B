package Bai_02;

public class Main {
    public static void main(String[] args) {
        // xem nhiet do
        OldThermometer old = new OldThermometer();
        TemperatureSensor t1 = new ThermometerAdapter(old);

        double res = t1.getTemperatureCelsius();
        System.out.printf("Nhiệt độ hiện tại: %.2f " , res);
        System.out.println();
        // che do roi nha
        SmartHomeFacade s = new SmartHomeFacade(t1);
        s.leaveHome();

        // che do ngu
        s.sleepMode();
    }
}
