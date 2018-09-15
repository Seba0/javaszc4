package seba0.javaszc4.wzorce.zadania.dekorator;

import java.util.Objects;

/**
 * Car spoiler decorator
 *
 * @author sebastian
 */
public class CarSpoilerDecorator extends CarDecorator {

    private final Spoiler spoiler;

    /**
     * Constructor
     *
     * @param spoiler spoiler for Car
     * @param car Car for decorate
     */
    public CarSpoilerDecorator(Spoiler spoiler, Car car) {
        super(car);
        this.spoiler = Objects.requireNonNull(spoiler);
    }

    /**
     * Get sar spoiler
     *
     * @return Car spoiler
     */
    @Override
    public Spoiler getSpoiler() {
        return spoiler;
    }
}
