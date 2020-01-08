package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// ExecutorService: Runnable Task - run a task to completion, no return value
// Shutting down an Executor service is important as they are nodaemon threads and will keep your JVM from shutting down !!
public class ExampleRunnable implements Runnable {
    private final String name;
    private final int len;
    private int sum = 0;

    public ExampleRunnable(String name, int len) {
        this.name = name;
        this.len = len;
    }

    @Override
    public void run() {
        for(int i=0; i< len ; i++) {
            System.out.println(name + ":" + i);
            sum += i;
            try {
                Thread.sleep(100);
            } catch (Exception ignored) {}
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool(); // Uses Cached ThreadPool
        es.execute(new ExampleRunnable("Thread1: ",10));
        es.execute(new ExampleRunnable("Thread2: ",20));

        try {
            es.shutdown(); // Shutdown ExecutorService
            es.awaitTermination(5, TimeUnit.SECONDS); // Wait 5 seconds
            System.out.println("5 seconds later!");
        } catch (InterruptedException ex) {
            System.out.println("Exception: " + ex);
        }
    }
}
