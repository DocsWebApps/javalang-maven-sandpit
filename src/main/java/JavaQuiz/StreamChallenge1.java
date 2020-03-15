package JavaQuiz;

import java.util.stream.Stream;

public class StreamChallenge1 {

    public static void main(String... doYourBest) {
        String sopranos = "<Tony,Junior,Christopher>";

        Stream.of(sopranos) // stream has 1 component <Tony,Junior,Christopher>
                .dropWhile(s -> !s.contains("<")) // result = <Tony,Junior,Christopher>
                .takeWhile(s -> !s.contains(">")) // Takes nothing since > is in the element
                .forEach(System.out::print); //Prints nothing
    }

}
/*
Summary
You will learn details about working with Streams in Java.

Background
At the following line of code, nothing will be dropped since the String does have "<".
The condition !s.contains("<") will be false.

    Stream.of(sopranos).dropWhile(s -> !s.contains("<"))

At the next line of code, we would take if the String does not contain ">" on which is not true because
the String does contain ">". The condition will be false and nothing will be taken.

    .takeWhile(s -> !s.contains(">"))

So nothing will be printed.
 */
