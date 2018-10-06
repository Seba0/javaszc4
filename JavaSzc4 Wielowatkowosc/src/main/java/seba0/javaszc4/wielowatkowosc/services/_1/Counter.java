package seba0.javaszc4.wielowatkowosc.services._1;

public class Counter extends Thread {

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
    public void run() {
        try {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < countTimes; i++) {
                System.out.println(thread.getName() + ": " + count++);
                thread.sleep(sleepTimeInMills);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Integer integer = 10;

        Counter c1 = new Counter(integer, 2000);
        Counter c2 = new Counter(integer, 2000);

        c1.start();
        c2.start();

    }
}
