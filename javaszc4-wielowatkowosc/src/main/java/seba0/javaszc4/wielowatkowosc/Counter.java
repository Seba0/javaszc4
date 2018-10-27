package seba0.javaszc4.wielowatkowosc;

public class Counter extends Thread {
    private final int countTo;
    private final int sleep;

    public Counter(int countTo, int sleep) {
        this.sleep = sleep;
        this.countTo = countTo;
    }

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        for (int i = 0; i < countTo; i++) {
            String loop = name + " " + i;
            if(isInterrupted()) {
                loop += " interrupted";
            }
            System.out.println(loop);
        }
    }
}