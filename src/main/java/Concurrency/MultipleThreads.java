package Concurrency;

public class MultipleThreads {
    public static void main(String[] args) {
        Thread myThread1 = new Thread() {
            public void myMethod() {
                System.out.println("MyMethod from Thread 1");
            }
            public void run() {
                for(int i=0; i<50; i++){
                    System.out.println("Hello I am Thread1");
                    this.myMethod();
                    try {
                        Thread.sleep(100);
                    } catch (Exception ignored) {}
                }
            }
        };

        Thread myThread2 = new Thread() {
            public void myMethod() {
                System.out.println("MyMethod from Thread 2");
            }

            public void run() {
                for(int i=0; i<50; i++){
                    System.out.println("Hello I am Thread2");
                    this.myMethod();
                    try {
                        Thread.sleep(100);
                    } catch (Exception ignored) {}
                }
            }
        };

        myThread1.start();
        myThread2.start();
    }

}
