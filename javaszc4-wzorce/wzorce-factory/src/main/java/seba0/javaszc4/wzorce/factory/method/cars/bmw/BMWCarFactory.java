package seba0.javaszc4.wzorce.factory.method.cars.bmw;

import seba0.javaszc4.wzorce.factory.method.cars.Car;
import seba0.javaszc4.wzorce.factory.method.cars.CarFactory;
import seba0.javaszc4.wzorce.factory.method.cars.CarType;

import java.util.Objects;

public class BMWCarFactory implements CarFactory {
    public Car produceCar(CarType type) {
        Car car = null;
        switch (Objects.requireNonNull(type)) {
            case KOMBI:
                car = new BMWKombi();
                break;
            case SEDAN:
                car = new BMWSedan();
                break;
            case HATCHBACK:
                car = new BMWHatchBack();
                break;
        }
        return car;
    }
}
