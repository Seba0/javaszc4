package seba0.javaszc4.tdd.kalkulator;

public class Kalkulator {
    public double dodawanie(double a, double b) {
        return a + b;
    }

    public double odejmowanie(double a, double b) {
        return a - b;
    }

    public double dzielenie(double a, double b) throws KalkulatorException {
        if (b == 0) {
            throw new KalkulatorException("Błąd dzielenia przez Zero");
        }
        return a / b;
    }
}
