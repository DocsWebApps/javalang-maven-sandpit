package Concurrency;

public class HelloThread extends Thread {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("Avail CPUS's: " + rt.availableProcessors());
        // start() method does some housekeeping for the thread and then executes the code in the run method
        // in a separate thread
        (new HelloThread()).start();
    }

    // JVM gets/creates a thread from the OS and runs the code below on it if you use start()
    // If you just call the run() method from main then it runs in the main thread
    @Override
    public void run() {
        System.out.println("Hello from a thread !");
    }
}
