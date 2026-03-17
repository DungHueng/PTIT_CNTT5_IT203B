package Bai_03;

import Bai_01.AirConditioner;
import Bai_02.OldThermometer;
import Bai_02.TemperatureSensor;
import Bai_02.ThermometerAdapter;

public class ACSetTemperatureCommand implements Command {
    protected AirConditioner airConditioner;
    protected Double newCon;
    protected Double oldCon;

    public ACSetTemperatureCommand(AirConditioner airConditioner, Double newCon) {
        this.airConditioner = airConditioner;
        this.newCon = newCon;
    }


    OldThermometer old = new OldThermometer();
    TemperatureSensor t = new ThermometerAdapter(old);
    double res = t.getTemperatureCelsius();

    @Override
    public void execute() {
        oldCon = airConditioner.getTemperature();
        airConditioner.setTemperature(newCon);
    }

    @Override
    public void undo() {
        airConditioner.setTemperature(oldCon);
    }
}
