package seba0.javaszc4.wzorce.serwer.abstrakcyjny;

public class Light implements Switchable {

    private boolean on;

    @Override
    public void turnOn() {
        on = true;
    }

    @Override
    public void turnOff() {
        on = false;
    }

    public boolean isOn() {
        return on;
    }
}
