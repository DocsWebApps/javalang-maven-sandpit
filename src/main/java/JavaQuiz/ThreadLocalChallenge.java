package JavaQuiz;

public class ThreadLocalChallenge {

    public static void main(String... doYourBest) throws InterruptedException {
        MarvelThreadLocal wolverine = new MarvelThreadLocal("Wolverine", true);
        startJoinThread(wolverine);
        System.out.println(wolverine.xmanName.get());

        startJoinThread(new MarvelThreadLocal("Xavier", true));
        startJoinThread(new MarvelThreadLocal("Cyclops", false));
    }

    private static void startJoinThread(MarvelThreadLocal marvelThreadLocal) throws InterruptedException {
        marvelThreadLocal.start();
        marvelThreadLocal.join();
    }

    static class MarvelThreadLocal extends Thread {
        ThreadLocal<String> xmanName = new ThreadLocal<>();
        boolean canBeatMagneto;

        MarvelThreadLocal(String name, boolean canBeatMagneto) {
            xmanName.set(name);
            this.canBeatMagneto = canBeatMagneto;
        }

        public void run() {
            if (canBeatMagneto)
                System.out.println(xmanName.get());
            else
                System.out.println("Magneto");
        }

    }

}
/*
Summary
You will learn how to store data isolated by different Threads to avoid collision of data.

Background
The LocalThread class basically isolates one value in the current Thread that is being executed.

Let's analyze the code:

    MarvelThreadLocal wolverine = new MarvelThreadLocal("Wolverine", true);
    startJoinThread(wolverine);
    System.out.println(wolverine.xmanName.get());

Note that when we instantiate the Thread class we are still in the main Thread.
Also, note that we are putting a value into the LocalThread instance when we invoke the constructor.
That means that we are inserting a value in the LocalThread instance in the main Thread.
So, when we start the Thread wolverine, the LocalThread value in the run method will be null.

But when we invoke the LocalThread value in the main Thread, we retrieve the value normally. Therefore the first output will be:
null
Wolverine

Then, let's see this code:

    startJoinThread(new MarvelThreadLocal("Xavier", true));

The same will happen to the Xavier Thread, the LocalThread value will be initialized into the main Thread but when we start another Thread,
the value from the LocalThread won't be retrieved. Then the following value will be printed:

    null

Finally, the almost same will happen to Cyclops, the only difference is that we are passing false, then the output will be the following:

    Magneto

For more, go watch the videos solutions from the quizzes:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi
 */
