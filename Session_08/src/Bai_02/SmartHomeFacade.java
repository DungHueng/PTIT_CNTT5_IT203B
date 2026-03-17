package Bai_02;

import Bai_01.AirConditioner;
import Bai_01.Fan;
import Bai_01.Light;

public class SmartHomeFacade {
    protected Light light;
    protected Fan fan;
    protected AirConditioner airConditioner;
    protected TemperatureSensor sensor;
    public SmartHomeFacade(TemperatureSensor sensor) {
        this.light = new Light();
        this.fan = new Fan();
        this.airConditioner = new AirConditioner();
        this.sensor = sensor;
    }

    public void leaveHome(){
        light.turnOff();
        fan.turnOff();
        airConditioner.turnOff();
    }

    public void sleepMode(){
        light.turnOff();
        airConditioner.setTemperature(28);
        fan.setLowSpeed();
    }

    public void getCurrentTemperature(){
        System.out.println("Nhiet do hien tai : " + sensor.getTemperatureCelsius());
    }
}
