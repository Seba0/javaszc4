package seba0.javaszc4.tdd.zadania._1;

public class Kalkulator {
    public double dodawanie(double a, double b) {
        return a + b;
    }

    public double odejmowanie(double a, double b) {
        return a - b;
    }

    public double mnozenie(double a, double b) {
        return a * b;
    }

    public double dzielene(double a, double b) {
        if (b == 0) {
            throw new KalkulatorException("Błąd dzielenia przez Zero");
        }
        return a / b;
    }
}
