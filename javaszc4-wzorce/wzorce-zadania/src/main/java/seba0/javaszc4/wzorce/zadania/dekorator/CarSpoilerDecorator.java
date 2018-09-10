package seba0.javaszc4.wzorce.zadania.dekorator;

import java.util.Objects;
import java.util.Optional;

/**
 * Car spoiler decorator
 *
 * @author sebastian
 */
public class CarSpoilerDecorator implements CarDecoratorInterface {

    private final Optional<Spoiler> spoiler;

    /**
     * Constructor
     *
     * @param spoiler spoiler for Car - set to empty if remover
     */
    public CarSpoilerDecorator(Optional<Spoiler> spoiler) {
        this.spoiler = Objects.requireNonNull(spoiler);
    }

    /**
     * Decorate Car
     *
     * @param car Car for decorate
     */
    @Override
    public void decorate(Car car) {
        car.setSpoiler(spoiler);
    }

}
