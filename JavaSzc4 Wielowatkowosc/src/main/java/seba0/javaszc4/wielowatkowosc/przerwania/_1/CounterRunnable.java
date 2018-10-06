package seba0.javaszc4.wielowatkowosc.przerwania._1;

public class CounterRunnable implements Runnable {
    private final int countTo;
    private final int delayMillis;

    public CounterRunnable(int countTo, int delayMillis) {
        this.countTo = countTo;
        this.delayMillis = delayMillis;
    }

    @Override
    public void run() {
        String name = getClass().getSimpleName();
        try {
            for (int i = 0; i < countTo; i++) {
                if (i % 2 == 0) {
                    System.out.println(name + ": " + i);
                    Thread.sleep(delayMillis);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + ": " + e.getMessage());
        }
    }
}
