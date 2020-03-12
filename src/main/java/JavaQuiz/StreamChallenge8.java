package JavaQuiz;

import java.util.stream.IntStream;

public class StreamChallenge8 {

    public static void main(String... doYourBest) {
        IntStream.iterate(10, i -> i - 2)
                .limit(5) // 10 8 6 4 2
                .skip(1) // 8 6 4 2
                .dropWhile(i -> i < 6) // 8 6 4 2 - first element is not < 6 so process stops
                .sorted() // 2 4 6 8
                .takeWhile(i -> i > 2) // nothing - since the first element is  not > 2 process stops
                .forEach(System.out::println);
    }

}
/*

Summary
You will learn details about working with Streams in Java.

Background
Let's analyze the code, in the first line:

    IntStream.iterate(10, i -> i - 2)

We are basically creating a stream that starts from 10 and subtracts 2 on each iteration.

Then we limit the iteration to 5 elements:
    .limit(5)

Skip one element, the first element.

    .skip(1)

In the dropWhile method, we won't be dropping any element since the condition
is if the element from the stream is lower than 6.
That happens because there is a break in the dropWhile method.
As the first element is 8, the first condition won't be met and all elements will be preserved.

    .dropWhile(i -> i < 6)

The takeWhile method works on a similar way from the dropWhile method, there is also a break.
This means that if the first condition is not met, no element will be taken.
That's exactly what happens on that method. Since the first element 2 is not greater than 2, they are equal,
no element will be taken.

Finally, the result will be nothing. There will be no elements in the IntStream.
 */
