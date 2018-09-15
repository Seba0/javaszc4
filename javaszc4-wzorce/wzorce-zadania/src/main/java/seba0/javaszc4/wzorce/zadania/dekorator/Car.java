package seba0.javaszc4.wzorce.zadania.dekorator;

import javafx.scene.paint.Color;

/**
 * Car interface
 *
 * @author sebastian
 */
public interface Car {

    /**
     * Get color of Car body
     *
     * @return body color
     */
    Color getBodyColor();

    /**
     * Get sar spoiler
     *
     * @return Car spoiler
     */
    Spoiler getSpoiler();

    /**
     * Get wheels size
     *
     * @return size of wheels
     */
    int getWheelsSize();
}
