package Concurrency;

public class ThreadChallenge {
    private static int wolverineAdrenaline = 10;

    public static void main(String... doYourBest) throws InterruptedException {
        // Main thread starts here !
        ThreadChallenge thread = new ThreadChallenge();

        // Which one will print out Yamaha YZF 13?

//        //1. No - throws IllegalThreadStateException, can run start() multiple times on same thread
//        Motorcycle yamaha = new Motorcycle("Yamaha YZF");
//        yamaha.start();
//        yamaha.start();
//        yamaha.start();

////        //2. Yes - using join holds main thread while other threads finish in order
//        new Motorcycle("Harley Davidson").start(); // wolverineAdrenaline=11
//
//        Motorcycle fastBike = new Motorcycle("Dodge Tomahawk");
//        fastBike.setPriority(Thread.MAX_PRIORITY);
//        fastBike.setDaemon(false);
//        fastBike.start(); // wolverineAdrenaline=12
//        fastBike.join(); // Hold the main thread here until fastBike thead has finished
//
//        Motorcycle yamaha = new Motorcycle("Yamaha YZF");
//        yamaha.setPriority(Thread.MIN_PRIORITY);
//        yamaha.start(); //wolverineAdrenaline=13, bikeName = yamaha
//        yamaha.join(); // Hold the main thread here until yamaha thead has finished
//
//        //3. Yes - using join holds main thread while other threads finish in order
        Motorcycle harley = new Motorcycle("Harley Davidson");
        harley.start();
        harley.join(); // Hold the main thread here until harley thead has finished
        System.out.println(thread.wolverineAdrenaline);

        Motorcycle fastBike = new Motorcycle("Dodge Tomahawk");
        fastBike.setPriority(Thread.MAX_PRIORITY);
        fastBike.setDaemon(false);
        fastBike.start();
        fastBike.join(); // Hold the main thread here until fastBike thead has finished
        System.out.println(thread.wolverineAdrenaline);

        Motorcycle yamaha = new Motorcycle("Yamaha YZF");
        yamaha.setPriority(Thread.MIN_PRIORITY);
        yamaha.start();
        yamaha.join(); // Hold the main thread here until yamaha thead has finished
//
//        //4. No - IllegalThreadStateException thrown as can't setDaemon() after start()
//        Motorcycle harley = new Motorcycle("Harley Davidson");
//        harley.start();
//        harley.setDaemon(false);
//
//        Motorcycle fastBike = new Motorcycle("Dodge Tomahawk");
//        fastBike.setPriority(Thread.MAX_PRIORITY);
//        fastBike.setDaemon(false);
//        fastBike.start();
//        fastBike.setDaemon(false);
//
//        Motorcycle yamaha = new Motorcycle("Yamaha YZF");
//        yamaha.setPriority(Thread.MIN_PRIORITY);
//        yamaha.start();
//        yamaha.setDaemon(false);
//
        System.out.println(thread.wolverineAdrenaline);
    }

    static class Motorcycle extends Thread {
        Motorcycle(String bikeName) { super(bikeName); }

        @Override public void run() {
            wolverineAdrenaline++;
            if (wolverineAdrenaline == 13) {
                System.out.println(this.getName());
            }
        }
    }
}
