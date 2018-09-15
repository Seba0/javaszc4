package seba0.javaszc4.wzorce.zadania.dekorator;

import java.util.Objects;
import javafx.scene.paint.Color;

/**
 * Car decorator base class for extension
 *
 * @author sebastian
 */
public abstract class CarDecorator implements Car {

    private final Car car;

    /**
     * Constructor
     *
     * @param car Car for decorate
     */
    public CarDecorator(Car car) {
        this.car = Objects.requireNonNull(car);
    }

    /**
     * Get new color of Car body
     *
     * @return new color of Car body
     */
    @Override
    public Color getBodyColor() {
        return car.getBodyColor();
    }

    /**
     * Get sar spoiler
     *
     * @return Car spoiler
     */
    @Override
    public Spoiler getSpoiler() {
        return car.getSpoiler();
    }

    /**
     * Get wheels size
     *
     * @return size of wheels
     */
    @Override
    public int getWheelsSize() {
        return car.getWheelsSize();
    }

}
