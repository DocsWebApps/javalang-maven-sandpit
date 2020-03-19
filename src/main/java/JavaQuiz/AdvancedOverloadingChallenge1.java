package JavaQuiz;

public class AdvancedOverloadingChallenge1 {

    static String finalResult = "";

    public static void main(String... doYourBest) {
        executeAction(1, true);
        executeAction();
        executeAction(new int[]{1, 2, 3}, 1);
        executeAction(1L);
        executeAction(1);
        executeAction(Double.valueOf(1));

        System.out.println(finalResult);
    }

    static void executeAction(Object o) { finalResult += "1"; }
    static void executeAction(Object... o) { finalResult += "2";}
    static void executeAction(StackOverflowError... i) { finalResult += "3";}
    static void executeAction(Long l) { finalResult += "4";}
    static void executeAction(double d) { finalResult += "5";}

}
// My Guess: 222451
// Answer: 232551
/*
Summary
You will learn details about working with Overloading in Java.

Background
Let's analyze the code, at the first method invocation:
    executeAction(1, true);

This method will be invoked:
    static void executeAction(Object... o) { ... }

At this line:
    executeAction();

This method will be invoked because it's the most specific type:
    static void executeAction(StackOverflowError... i) { ... }

At this line:
    executeAction(new int[]{1, 2, 3}, 1);

This method will be invoked since we are passing more than one value:
    static void executeAction(Object... o) { finalResult += "2";}

Then at those method invocations:
    executeAction(1L);
    executeAction(1);

This method will be invoked because it's easier to the JVM to wide 1L as long and 1 as int to a double
than autoboxing them:
    static void executeAction(double d) { finalResult += "5";}

Then at this line:
    executeAction(Double.valueOf(1));

This method will be invoked because a Double will be widened to Object.
    static void executeAction(Object o) { finalResult += "1"; }
 */