package seba0.javaszc4.wielowatkowosc.prerwania._2;

public class CounterThread extends Thread {
    private final int countTo;

    public CounterThread(int countTo) {
        this.countTo = countTo;
    }

    @Override
    public void run() {
        String name = getClass().getSimpleName();
        for (int i = 0; i < countTo; i++) {
            if (Thread.interrupted()) {
                System.out.println(name + ": interrupted");
            } else {
                System.out.println(name + ": normal");
            }
        }
    }
}
