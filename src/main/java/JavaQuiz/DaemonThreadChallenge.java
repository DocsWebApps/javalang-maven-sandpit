package JavaQuiz;

public class DaemonThreadChallenge implements Runnable {

    public static void main(String... doYourBest) {
        Thread thread = new Thread(new DaemonThreadChallenge());
//         ##REPLACE##
    }

    @Override
    public void run() {
        for (;;) {
            System.out.println("For ever");
        }
    }
}
/* ## REPLACE ## which one will run forever
1. Will not run forever - its a daemon thread
    thread.setDaemon(true);
    thread.start();

There are two types of Threads, non-daemon, and daemon.

The Thread of the main method is non-daemon, that means that the instructions inside this method will be executed until the end.

When we define a daemon Thread it means that this Thread may or may not be fully executed.
The JVM just execute this Thread but it doesn't matter if this method will be finished or not.

What matters is that all non-daemon Threads be finished.

With that said, the looping will not be executed forever.

2. Will run forever - non daemon thread
    thread.setDaemon(false);
    thread.start();

We are setting up this instance of a Thread to non-daemon.
In that case, the for looping will be executed forever.

3. Will run forever, see below
    thread.setDaemon(true);
    thread.run();

There is a trick here. Although the instance of this Thread is a daemon, there is no Thread being started,
there is no second process being executed. we are only invoking the run that is inside the main Thread.
The looping from the run method will be executed forever.

4. Will not run forever

thread.setDaemon(true);
thread.start();
thread.start();

The IllegalThreadStateException will be thrown. The same Thread can't be started twice. There is no way of the same Thread being executed twice. It wouldn't make sense. In order to execute the same Thread again, we would have to instantiate a new Thread.

Thread thread = new Thread(new DaemonThreadChallenge());
thread.start();
Thread thread2 = new Thread(new DaemonThreadChallenge());
thread2.start();

Summary

You will learn how to manipulate daemon Threads and non-daemon Threads.

Background

Threads are basically parallelized processes. We can create simultaneous java processes in order take advantage of the hardware performance. In a simple way, Threads could be two methods being executed at the same time.

Also, there are two types of Threads, non-daemon, and daemon.

Non-daemon Threads: executes the instructions until the end.
Daemon Thread: may or may not be fully executed. The JVM just execute this Thread but it doesn't matter if this method will be finished or not.

What matters is that all non-daemon Threads be finished and daemon maybe.
 */
