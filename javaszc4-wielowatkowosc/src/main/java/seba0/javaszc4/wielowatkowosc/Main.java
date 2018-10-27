package seba0.javaszc4.wielowatkowosc;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter(1000, 100);
        Counter counter2 = new Counter(1000, 90);
        System.out.println("Start");
        counter.start();
        counter2.start();
        counter.interrupt();
        System.out.println("Stop");
    }
}
