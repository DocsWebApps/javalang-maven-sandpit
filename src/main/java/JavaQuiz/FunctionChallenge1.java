package JavaQuiz;

import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FunctionChallenge1 {

    public static void main(String ... doYourBest) {
        String starWars = "Luke DarthVader ObiWan QuiGonJinn Palpatine";

        Function<String, Stream<String>> lineSplitter =
                l -> Pattern.compile(" ").splitAsStream(l); // Line 11

        Stream.of(starWars)
                .flatMap(lineSplitter)
                .sorted(((o1, o2) -> o2.compareTo(o1)))
                .forEachOrdered(System.out::println);
    }

}
/*
Summary
How to use Functions and use their methods.

Background
Let's analyse the code:

    Function<String, Stream<String>> lineSplitter =
            l -> Pattern.compile(" ").splitAsStream(l);

At this code statement, we are splitting the Stream in separated Strings.
In simple words, for each line of the Stream, store a String into the List of String.
Then we are going to use the Function we defined and sort the String elements:

    Stream.of(starWars)
            .flatMap(lineSplitter)
            .sorted(((o1, o2) -> o2.compareTo(o1)))
            .forEachOrdered(System.out::println);

In the flatMap method, we are passing the Function with the logic we implemented and then we are going
to sort the elements based on the Strings we declared in the code. But note that the sorting logic is inverted:

    o2.compareTo(o1)

For that reason, the elements will be sorted in an inverted order. In the last code statement, we will be only printing all the elements.
 */
