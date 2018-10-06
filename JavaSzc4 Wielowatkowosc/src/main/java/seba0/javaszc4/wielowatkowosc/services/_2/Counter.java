package seba0.javaszc4.wielowatkowosc.services._2;

import java.util.concurrent.Callable;

public class Counter implements Callable<String> {

    private Integer count;
    private final int sleepTimeInMills;
    private final int countTimes;

    public Counter(Integer count, int sleepTimeInMills) {
        this.count = count;
        this.sleepTimeInMills = sleepTimeInMills;
        this.countTimes = 10;
    }

    public Counter(Integer count, int sleepTimeInMills, int countTimes) {
        this.count = count;
        this.sleepTimeInMills = sleepTimeInMills;
        this.countTimes = countTimes;
    }

    @Override
    public String call() {
        Thread thread = Thread.currentThread();
        try {
            for (int i = 0; i < countTimes; i++) {
                System.out.println(thread.getName() + ": " + count++);
                thread.sleep(sleepTimeInMills);
            }
        } catch (InterruptedException e) {
            System.out.println(thread.getName() + ": " + e.getMessage());
        }
        return "WINNER: " + thread.getName() + " - " + count;
    }
}
