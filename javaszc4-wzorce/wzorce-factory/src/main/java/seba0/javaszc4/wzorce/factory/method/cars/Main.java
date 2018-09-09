package seba0.javaszc4.wzorce.factory.method.cars;

import seba0.javaszc4.wzorce.factory.method.cars.bmw.BMWCarFactory;
import seba0.javaszc4.wzorce.factory.method.cars.honda.HondaCarFactory;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<CarFactory> carFactories = Arrays.stream(new CarFactory[]{
                new BMWCarFactory(),
                new HondaCarFactory()
        });

//TODO - Repair

//        cars.parallelStream()
//                .map(Car::getDescription)
//                .forEach(System.out::println);

    }
}
