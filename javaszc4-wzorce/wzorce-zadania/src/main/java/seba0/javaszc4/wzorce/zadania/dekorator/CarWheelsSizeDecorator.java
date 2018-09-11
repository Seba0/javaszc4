package seba0.javaszc4.wzorce.zadania.dekorator;

/**
 * Car wheels size decorator
 *
 * @author sebastian
 */
public class CarWheelsSizeDecorator extends CarDecorator {

    private final int wheelsSize;

    /**
     * Constructor
     *
     * @param wheelsSize size of wheels to mount on Car (min. 12, max. 30)
     * @param car Car for decorate
     */
    public CarWheelsSizeDecorator(int wheelsSize, Car car) {
        super(car);
        if (wheelsSize < 12 || wheelsSize > 30) {
            throw new IllegalArgumentException("Unsupported whells size");
        }
        this.wheelsSize = wheelsSize;
    }

    /**
     * Get wheels size
     *
     * @return size of wheels
     */
    @Override
    public int getWheelsSize() {
        return wheelsSize;
    }
}
