package seba0.javaszc4.solid.liskov.substitution.car;

import seba0.javaszc4.solid.liskov.substitution.car.gear.Gear;

public class Car {

    private Gear gear;

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public Gear getGear() {
        return gear;
    }
}
