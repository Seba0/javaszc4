package seba0.javaszc4.wzorce.zadania.dekorator;

import java.util.Objects;
import javafx.scene.paint.Color;

/**
 * Car body color decorator
 *
 * @author sebastian
 */
public class CarBodyColorDecorator extends CarDecorator {

    private final Color bodyColor;

    /**
     * Constructor
     *
     * @param bodyColor color for Car body
     * @param car Car for decorate
     */
    public CarBodyColorDecorator(Color bodyColor, Car car) {
        super(car);
        this.bodyColor = Objects.requireNonNull(bodyColor);
    }

    /**
     * Get new color of Car body
     *
     * @return new color of Car body
     */
    @Override
    public Color getBodyColor() {
        return bodyColor;
    }
}
