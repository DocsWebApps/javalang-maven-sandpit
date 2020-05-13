package Concurrency;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StartRunDifference extends Thread {
    private String bike;
    private int count=10;

    public static void main(String[] args) {
        StartRunDifference myThread = new StartRunDifference();
        myThread.setBike("Yamaha");
        myThread.start(); // Create new thread
//        myThread.start(); // Can't call start() twice - IllegalThreadStateException thrown !
        myThread.run(); // Executes in existing main method thread
    }

    @Override
    public void run() {
        count++;
        System.out.println("Hello, I am thread " + Thread.currentThread().getName() + " : " + this.bike + this.count);
    }

}
