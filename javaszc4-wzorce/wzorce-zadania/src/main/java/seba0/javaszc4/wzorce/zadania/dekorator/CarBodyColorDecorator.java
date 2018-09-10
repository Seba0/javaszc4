package seba0.javaszc4.wzorce.zadania.dekorator;

import java.util.Objects;
import javafx.scene.paint.Color;

/**
 * Car body color decorator
 *
 * @author sebastian
 */
public class CarBodyColorDecorator implements CarDecoratorInterface {

    private final Color bodyColor;

    /**
     * Constructor
     *
     * @param bodyColor color for decorate Car body
     */
    public CarBodyColorDecorator(Color bodyColor) {
        this.bodyColor = Objects.requireNonNull(bodyColor);
    }

    /**
     * Decorate Car
     *
     * @param car car for decorate
     */
    @Override
    public void decorate(Car car) {
        car.setBodyColor(bodyColor);
    }
}
