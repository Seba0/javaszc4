package seba0.javaszc4.java8.utils;

public final class TimeCounter {
    public static long watch(Runnable runnable) {
        System.out.println("Watch: START\n");
        long start = System.currentTimeMillis();
        runnable.run();
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("\nWatch: STOP. Elapsed " + elapsed + " millis");
        return elapsed;
    }

    public static long watch(int count, Runnable runnable) {
        System.out.println("Watch: START. Loop " + count + " times.");
        long start = System.currentTimeMillis();
        while (count-- > 0)
            runnable.run();
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Watch: STOP. Elapsed " + elapsed + " millis");
        return elapsed;
    }
}
