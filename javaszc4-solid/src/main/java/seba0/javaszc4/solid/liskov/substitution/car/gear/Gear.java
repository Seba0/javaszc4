package seba0.javaszc4.solid.liskov.substitution.car.gear;

import seba0.javaszc4.solid.liskov.substitution.car.gear.type.GearType;

public interface Gear<T extends GearType> {

    void changeGear(T type);

}
