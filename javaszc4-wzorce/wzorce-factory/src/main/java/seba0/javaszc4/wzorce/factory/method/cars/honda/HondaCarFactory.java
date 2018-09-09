package seba0.javaszc4.wzorce.factory.method.cars.honda;

import seba0.javaszc4.wzorce.factory.method.cars.Car;
import seba0.javaszc4.wzorce.factory.method.cars.CarFactory;
import seba0.javaszc4.wzorce.factory.method.cars.CarType;

import java.util.Objects;

public class HondaCarFactory implements CarFactory {
    public Car produceCar(CarType type) {
        Car car = null;
        switch (Objects.requireNonNull(type)) {
            case KOMBI:
                car = new HondaKombi();
                break;
            case SEDAN:
                car = new HondaSedan();
                break;
            case HATCHBACK:
                car = new HondaHatchBack();
                break;
        }
        return car;
    }
}
