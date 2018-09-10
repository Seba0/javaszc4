package seba0.javaszc4.wzorce.zadania.dekorator;

import java.util.Optional;
import javafx.scene.paint.Color;

/**
 * Car class
 *
 * @author sebastian
 */
public class Car {

    private Color bodyColor = Color.DODGERBLUE;
    private Optional<Spoiler> spoiler;
    private int wheelsSize = 14;

    /**
     * Get Car body collor
     *
     * @return body collor
     */
    public Color getBodyColor() {
        return bodyColor;
    }

    /**
     * Set Car body collor
     *
     * @param bodyColor body collor
     */
    void setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
    }

    /**
     * Get Car spoiler - optional
     *
     * @return spoiler
     */
    public Optional<Spoiler> getSpoiler() {
        return spoiler;
    }

    /**
     * Set Car spoiler - optional
     *
     * @param spoiler
     */
    void setSpoiler(Optional<Spoiler> spoiler) {
        this.spoiler = spoiler;
    }

    /**
     * Get Car wheels size
     *
     * @return wheels size
     */
    public int getWheelsSize() {
        return wheelsSize;
    }

    /**
     * Set Car wheels size
     *
     * @param wheels size
     */
    void setWheelsSize(int wheelsSize) {
        this.wheelsSize = wheelsSize;
    }

}
