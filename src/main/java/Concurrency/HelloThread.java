package Concurrency;

public class HelloThread extends Thread {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("Avail CPUS's: " + rt.availableProcessors());
        // start() method does some housekeeping for the thread and then executes the code in the run method
        (new HelloThread()).start();
    }

    // JVM gets/creates a thread from the OS and runs the code below on it.
    @Override
    public void run() {
        System.out.println("Hello from a thread !");
    }
}
