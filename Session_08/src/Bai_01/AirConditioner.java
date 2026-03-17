package Bai_01;

public class AirConditioner implements Function{
    private double temperature = 25;

    public void turnOn() {
        System.out.println("Điều hòa: Làm mát.");
    }

    public void turnOff() {
        System.out.println("Điều hòa: Tắt.");
    }

    public void setTemperature(double temp) {
        System.out.println("FACADE: Điều hòa set " + temp + "°C");
    }

    public double getTemperature() {
        return temperature;
    }
}
