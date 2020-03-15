package JavaQuiz;

public class FlowControlChallenge2 {
    public static void main(String... doYourBest) {

        boolean isHomerFat; //uninitialised
        boolean isBartPrankster = false;

        int result = 0;

        if (isHomerFat = true || (isBartPrankster = true)) {
            result++;
            isHomerFat = false;
            System.out.println("1");
        }

        if (isHomerFat || isBartPrankster && (isBartPrankster = false || isHomerFat)) {
            result++;
            System.out.println("2");
        }

        if (!isHomerFat && !isBartPrankster) {
            result++;
            System.out.println("3");
        }

        System.out.println(String.valueOf(result) + isHomerFat + isBartPrankster);
    }
}
/*
Summary
You will learn details about working with Flow Control in Java.

Background
Understand loop concept

Let's analyse the first condition:

    if (isHomerFat = true || (isBartPrankster = true)) {

isHomerFat will be set to true, since the first condition is true, the second condition won't be executed.
That means that isBartPrankster won't be set but the condition will be fulfilled adding 1 to the result variable.

Let's see the second condition:

    if (isHomerFat || isBartPrankster && (isBartPrankster = false || isHomerFat)) {

isHomerFat is true but isBartPrankster is false. When we use "&&" both conditions must be true. So, if the first condition is false, the final result will be false. It doesn't matter if there is variable assignment, this code: "isBartPrankster = false || isHomerFat" won't be even executed.

Now in the last condition:

    if (!isHomerFat && !isBartPrankster) {

The variable isHomerFat is false and isBartPrankster as well so this condition will be fulfilled adding up 1 to result.

Then we conclude the result:
    2falsefalse
 */