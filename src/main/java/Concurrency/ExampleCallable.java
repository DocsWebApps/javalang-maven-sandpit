package Concurrency;

import java.util.concurrent.*;

// ExecutorService: Callable Task - returns a value when thread is completed and throws checked Exception
// Shutting down an Executor service is important as they are nodaemon threads and will keep your JVM from shutting down !!
public class ExampleCallable implements Callable {
    private final String name;
    private final int len;
    private int sum = 0;

    public ExampleCallable(String name, int len) {
        this.name = name;
        this.len = len;
    }

    @Override
    public Object call() throws Exception {
        for(int i=0; i< len ; i++) {
            System.out.println(name + ":" + i);
            sum += i;
            try {
                Thread.sleep(100);
            } catch (Exception ignored) {}
        }
        return "sum:" + sum;
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4); // Uses Fixed Thread Pool
        Future<String> f1 = es.submit(new ExampleCallable("Thread1: ",10));
        Future<String> f2 = es.submit(new ExampleCallable("Thread2: ",20));

        try {
            es.shutdown(); // Shutdown ExecutorService
            es.awaitTermination(5, TimeUnit.SECONDS);
            String result1 = f1.get(); // Block until thread f1 finishes, needs the return value
            System.out.println("Result of one: " + result1);
            String result2 = f2.get(); // Block until thread f2 finishes, needs the return value
            System.out.println("Result of two: " + result2);
        } catch (ExecutionException | InterruptedException ex) {
            System.out.println("Exception: " + ex);
        }
    }
}
