package seba0.javaszc4.wzorce.factory.method.cars.honda;

import seba0.javaszc4.wzorce.factory.method.cars.Car;

public class HondaSedan implements Car {

    @Override
    public String getDescription() {
        return "Honda Sedan";
    }
}