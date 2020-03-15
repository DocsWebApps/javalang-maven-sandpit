package JavaQuiz;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MinMaxChallenge {

    public static void main(String... doYourBest) {
        IntStream intStream = List.of(1, 2, 3, 4, 5, 6)
                .stream().mapToInt(n -> n);

        IntStream intStream2 = intStream;

        OptionalInt optIntMin = intStream.min();
        System.out.println(optIntMin);

        OptionalInt optIntMax = intStream2.max();
        System.out.println(optIntMax);

        int sum = optIntMax.orElse(5) + optIntMin.orElse(5);

        System.out.println(sum);
    }

}
/*
Summary
You will learn details about working with Streams in Java.

Background
The trick of this quiz is that once the Stream is used at the intStream.min() invocation,
the same Stream can't be used again to the intStream2.max() method invocation.

Therefore when we try to invoke the  intStream2.max() method,
the an IllegalStateException will be thrown because the stream has already been operated upon or closed.
 */
