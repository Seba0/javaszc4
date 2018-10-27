package seba0.javaszc4.java8.functional.interfaces.supplier._1;

import seba0.javaszc4.java8.utils.TimeCounter;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        TimeCounter.watch(() -> {
            Car car = createCar(() -> Car.NAMES.get(new Random().nextInt(Car.NAMES.size())));
            System.out.println(car);
        });
    }

    public static Car createCar(Supplier<String> carNameSupplier) {
        return new Car(carNameSupplier.get());
    }
}
