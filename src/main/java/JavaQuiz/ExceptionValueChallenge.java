package JavaQuiz;

public class ExceptionValueChallenge {

    static int kratos, zeus, hades;

    public static void main(String... doYourBest) {
        try {
            invokeAGod(kratos = 1, lightningOfZeus(zeus = 2), hades = 3);
        } catch (Exception e) {
            System.out.println(kratos + " " + zeus + " " + hades);
        }
    }

    static int lightningOfZeus(int i) throws Exception {
        throw new StackOverflowError("Wowww!"); // NOT AN EXCEPTION FFS !!
    }

    static int invokeAGod(int a, int b, int c) {
        return a + b + c;
    }

}
/*
Summary
You will learn how Exceptions behave when variables are being assigned and there is an error between them.

Background
Let's analyze the code:

    invokeAGod(kratos = 1, lightningOfZeus(zeus = 2), hades = 3);

In the first parameter, kratos it's fine, the variable will be set to 1.

But in the second parameter, the method lightningOfZeus will be invoked:

    static int lightningOfZeus(int i) throws Exception {
       throw new StackOverflowError("Wowww!");
    }

Note that we are throwing a StackOverflowError so it's not an Exception, it's an Error.
That means that our catch won't catch this error.
Instead, the StackOverflowError will be simply thrown and it will never be handled.

If it was any other Exception that extends Exception, the result would be: 1 2 0 but as we are throwing a StackOverflowError, it won't be caught.

Therefore the result will be:

Exception in thread "main" java.lang.StackOverflowError: Wowww! ......

If you want to go deeper on it, watch the video explanations here:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi
 */