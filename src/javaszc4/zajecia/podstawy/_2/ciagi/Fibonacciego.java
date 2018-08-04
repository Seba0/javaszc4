package javaszc4.zajecia.podstawy._2.ciagi;

import java.util.Scanner;

public class Fibonacciego {

    public static int wartosc(int krok) {
        if (krok < 1) {
            throw new ArithmeticException();
        } else if (krok < 3) {
            return 1;
        }
        return wartosc(krok - 1) + wartosc(krok - 2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("Podaj element ciągu: ");
            int i = s.nextInt();
            System.out.println(i + ": " + wartosc(i));
        }
    }
}
