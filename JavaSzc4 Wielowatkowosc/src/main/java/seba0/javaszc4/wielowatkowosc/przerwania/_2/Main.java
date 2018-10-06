package seba0.javaszc4.wielowatkowosc.przerwania._2;

public class Main {
    public static void main(String[] args) {
        Thread t = new CounterThread(100);
        t.start();
        t.interrupt();
    }
}
