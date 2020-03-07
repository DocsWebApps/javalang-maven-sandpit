package JavaQuiz;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalInterfaceChallenge1 {

    static BiFunction<Integer, Integer, Integer> heisenberg =
            (a, b) -> a + b;

    static Function<Integer, Integer> jesse = a -> a - 2;

    static BiFunction<Integer, Integer, Integer> saul =
            heisenberg.andThen(jesse);

    // a=2, b=4 so (a + 2 / b + 2) equates to 2 + 2 / 4 + 2
    // Remember that the arithmetic priority is division,
    // so 2 / 4 will be executed first and evaluated to 0 - using ints not decimals
    // therefore 2 + 0 + 2 = 4
    static BiConsumer<Integer, Integer> gustavo =
            (a, b) -> System.out.println(a + 2 / b + 2);

    public static void main(String[] breakingBad) {
        var firstLaunder = saul.apply(2, 2);
        System.out.println(firstLaunder);

        heisenberg.andThen(jesse);

        System.out.println(firstLaunder);

        var secondLaunder = heisenberg.apply(2, 2);

        System.out.println(firstLaunder + " : " + secondLaunder);

        gustavo.accept(firstLaunder, secondLaunder);
    }

}
/*

Summary
To use key features from Functions.

Background
At the first line of code we are basically joining two Functions. The BiFunction saul will receive heisenberg and jesse Functions.

    var firstLaunder = saul.apply(2, 2);

The first result from firstLaunder will be 2.

There is a trick at this line:

    heisenberg.andThen(jesse);

The Functions are being joined but there is nothing being assigned, so this line process will be lost. Remember, Functional programming doesn't keep any state.

At this line:

    var secondLaunder = heisenberg.apply(2, 2);

Only the heisenberg function will be executed, the result here will be 4.

Finally let's analyse the last part of the code:

    gustavo.accept(firstLaunder, secondLaunder);

The gustavo BiConsumer will receive 2 and 4 from the previous functions and will execute this code:

System.out.println(a + 2 / b + 2);

Remember that the arithmetic priority is division, so 2 / 4 will be executed first.
As we are performing a division with int numbers, we will be returning only in numbers as well.
If we were using decimal numbers like 4.0 and 2.0 we would be having a result of 0.5.
But as an int, we have the result as an int so it will be 0.

Then the remaining numbers will be 2 + 2, the final result will be 4.
 */

