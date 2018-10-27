package seba0.javaszc4.wielowatkowosc.services._2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("START 4");
        ExecutorService service = Executors.newScheduledThreadPool(3);
        List<Future<String>> out = service.invokeAll(Arrays.asList(
                new Counter(100, 1500, 11),
                new Counter(200, 3000, 11),
                new Counter(300, 2000, 11),
                new Counter(400, 1500, 11),
                new Counter(500, 3000, 11),
                new Counter(600, 2000, 11),
                new Counter(700, 1500, 11),
                new Counter(800, 3000, 11),
                new Counter(900, 2000, 11)
        ));
        service.shutdown();
        System.out.println("END ");
        out.parallelStream()
                .map(e -> {
                    try {
                        return e.get();
                    } catch (Exception ex) {
                        return ex.getMessage();
                    }
                }).forEach(System.out::println);
    }
}
