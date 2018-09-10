package seba0.javaszc4.wzorce.zadania.dekorator;

/**
 * Car wheels size decorator
 *
 * @author sebastian
 */
public class CarWheelsSizeDecorator implements CarDecoratorInterface {

    private final int wheelsSize;

    /**
     * Constructor
     *
     * @param wheelsSize size of wheels to mount on Car (min. 12, max. 30)
     */
    public CarWheelsSizeDecorator(int wheelsSize) {
        if (wheelsSize < 12 || wheelsSize > 30) {
            throw new IllegalArgumentException("Unsupported whells size");
        }
        this.wheelsSize = wheelsSize;
    }

    /**
     * Decorate Car
     *
     * @param car Car for decorate
     */
    @Override
    public void decorate(Car car) {
        car.setWheelsSize(wheelsSize);
    }
}
