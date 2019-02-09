package seba0.javaszc4.wzorce.serwer.abstrakcyjny;

public class Switch {

    private final Switchable switchable;
    private boolean on;

    public Switch(Switchable switchable) {
        this.switchable = switchable;
    }

    public void turn() {
        if (on) {
            switchable.turnOff();
        } else {
            switchable.turnOn();
        }
        on = !on;
    }
}
