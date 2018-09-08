package seba0.javaszc4.tdd.wydarzenia;

public final class ObliczPole {
    private ObliczPole() {
    }

    public static double prostokata(double wysokosc, double szerokosc) {
        if (wysokosc <= 0 || szerokosc <= 0) {
            throw new IllegalArgumentException("Nieprawidłowa wartość argumentu. Wartość argumentu musi być większa od 0");
        }
        return wysokosc * szerokosc;
    }

    public static double kwadratu(double wysokosc) {
        return prostokata(wysokosc, wysokosc);
    }

    public static double trapezu(double wysokosc, double podstawaA, double podstawaB) {
        if (wysokosc <= 0 || podstawaA <= 0 || podstawaB <= 0) {
            throw new IllegalArgumentException("Nieprawidłowa wartość argumentu. Wartość argumentu musi być większa od 0");
        }
        return (podstawaA + podstawaB) * wysokosc / 2;
    }


    public static double kola(double promien) {
        if (promien <= 0) {
            throw new IllegalArgumentException("Nieprawidłowa wartość argumentu. Wartość argumentu musi być większa od 0");
        }
        return Math.PI * promien * promien;
    }
}
