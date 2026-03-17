package Bai_03;

import Bai_01.Fan;

public class FanOnCommand implements Command {
    protected Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOn();
    }

    @Override
    public void undo() {
        fan.turnOff();
    }
}
