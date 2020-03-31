package JavaQuiz;

public class MethodReferenceChallenge1 {

    public static void main(String... doYourBest) {
        Runnable universeImpactRunnable = () -> new ChuckNorris().roundHouseKick();
        Runnable galaxyImpactRunnable = new ChuckNorris()::roundHouseKick;

        System.out.print("The galaxy is finished = ");

        universeImpactRunnable.run();
        universeImpactRunnable.run();

        galaxyImpactRunnable.run();
        galaxyImpactRunnable.run();
    }

    static class ChuckNorris {
        private static int numberOfKicks;
        private int galaxyDamage;

        ChuckNorris() {
            this.galaxyDamage = numberOfKicks++;
        }

        void roundHouseKick() {
            System.out.print(this.galaxyDamage);
        }
    }

}
/*

Summary
You will learn what is the difference between Method Reference and lambda when they are invoked.

Background
Let's analyze the code:

    Runnable universeImpactRunnable = () -> new ChuckNorris().roundHouseKick();
    Runnable galaxyImpactRunnable = new ChuckNorris()::roundHouseKick;

There is a crucial difference between lambda and method reference.
Lambdas are lazy and it will invoke the class constructor only when the method is invoked.
On the other hand, with method reference, the constructor will be invoked right away only where the method
reference is assigned, not on the method invocation.

So, at this line:
    Runnable universeImpactRunnable = () -> new ChuckNorris().roundHouseKick();
The constructor is not invoked

And, at this line:
    Runnable galaxyImpactRunnable = new ChuckNorris()::roundHouseKick;
The constructor is invoked

With that in mind, let's analyze the invoked methods:

    universeImpactRunnable.run();
    universeImpactRunnable.run();

With lambdas, every time the run method is invoked, the constructor will be invoked,
which means that the numberOfKicks variable will be increased.

So the value from galaxyDamage will be: 12

Then when we invoke those methods:
    galaxyImpactRunnable.run();
    galaxyImpactRunnable.run();

The value will be 0 because remember that the constructor will be only invoked once and it was already invoked
at the moment of the method reference declaration.
By knowing that, and also remembering that the post ++ operator increases a value after the line being processed.

Then the values will be: 00

The final result will be then:
The galaxy is finished = 1200

The solution of this quiz will be in the video as well, stay tuned to the Java Challengers channel to watch all solutions from the quizzes here:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi



 */
