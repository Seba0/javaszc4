package seba0.javaszc4.wzorce.zadania.dekorator;

import java.util.Objects;
import javafx.scene.paint.Color;

/**
 * Basic Car implementation
 *
 * @author sebastian
 */
public class CarBasic implements Car {

    private final Color bodyColor;
    private final Spoiler spoiler;
    private final int wheelsSize;

    /**
     * Constructor
     *
     * @param bodyColor Color of Car body
     * @param spoiler Car Spoiler
     * @param wheelsSize size of wheels to mount on Car (min. 12, max. 30)
     */
    public CarBasic(Color bodyColor, Spoiler spoiler, int wheelsSize) {
        this.bodyColor = Objects.requireNonNull(bodyColor);
        this.spoiler = Objects.requireNonNull(spoiler);
        if (wheelsSize < 12 || wheelsSize > 30) {
            throw new IllegalArgumentException("Unsupported whells size");
        }
        this.wheelsSize = wheelsSize;
    }

    /**
     * Get Car body collor
     *
     * @return body collor
     */
    @Override
    public Color getBodyColor() {
        return bodyColor;
    }

    /**
     * Get Car spoiler
     *
     * @return spoiler
     */
    @Override
    public Spoiler getSpoiler() {
        return spoiler;
    }

    /**
     * Get Car wheels size
     *
     * @return wheels size
     */
    @Override
    public int getWheelsSize() {
        return wheelsSize;
    }

}
