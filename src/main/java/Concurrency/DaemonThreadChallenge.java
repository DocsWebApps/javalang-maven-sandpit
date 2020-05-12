package Concurrency;

import lombok.SneakyThrows;

public class DaemonThreadChallenge implements Runnable {

    public static void main(String... doYourBest) {
        Thread thread1 = new Thread(new DaemonThreadChallenge());
        Thread thread2 = new Thread(new DaemonThreadChallenge());
        thread1.setDaemon(true);
        thread1.start(); // Daemon - stops when all non daemon threads end like main and thread2 end
        thread2.start(); // Non Daemon - runs forever! Will force thread 1 to also run forever since this thread is non daemon
        System.out.println("Main method ends!");
    }

    @SneakyThrows
    @Override
    public void run() {
        for (; ;) {
            System.out.println(this.hashCode());
            Thread.sleep(1000);
        }
    }
}

/*

Summary
There are two types of threads in Java:
non-daemon: the main method is executed with a non-daemon thread behind the scenes and this thread will be executed until the end.
daemon: it will die if all non-daemon threads have finished.

Background
The amount of time that "Forever" will be printed is indeterminate because it will depend on the time from the main thread execution.
There are two types of threads:
1. Non-daemon: the main method is executed with a non-daemon thread behind the scenes and this thread will be executed until the end.
2. Daemon: it will die if all non-daemon threads have finished.

So in this quiz, if the main method is finished, the daemon thread we created will be finished as well because all daemon threads depend on a non-daemon thread to continue its execution.

 */
