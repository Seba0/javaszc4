package seba0.javaszc4.wzorce.zadania.lancuch.zobowiazan;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author sebastian
 */
public class NominalRequest {

    private final Map<Nominal, Integer> bills = new EnumMap<>(Nominal.class);
    private final int toPay;
    private int leftToPay;

    public NominalRequest(int toPay) {
        this.toPay = toPay;
        this.leftToPay = toPay;
    }

    public Map<Nominal, Integer> getBills() {
        return bills;
    }

    public int getToPay() {
        return toPay;
    }

    public int getLeftToPay() {
        return leftToPay;
    }

    public void setLeftToPay(int leftToPay) {
        this.leftToPay = leftToPay;
    }
}
