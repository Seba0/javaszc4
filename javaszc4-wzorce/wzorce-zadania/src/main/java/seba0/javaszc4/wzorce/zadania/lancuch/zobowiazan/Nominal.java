package seba0.javaszc4.wzorce.zadania.lancuch.zobowiazan;

/**
 *
 * @author sebastian
 */
public enum Nominal {
    _10(10), _20(20), _50(50), _100(100), _200(200), _500(500);

    private final int value;

    private Nominal(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
