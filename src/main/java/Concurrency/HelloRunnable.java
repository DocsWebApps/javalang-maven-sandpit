package Concurrency;

public class HelloRunnable implements Runnable {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total RAM is: " + rt.totalMemory());
        (new Thread(new HelloRunnable())).start();
    }

    @Override
    public void run() {
        System.out.println("Hello from another Thread !");

        // For long running threads occasionally sleep from time to time to allow other threads to run
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
