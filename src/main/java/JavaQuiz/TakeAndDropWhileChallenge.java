package JavaQuiz;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class TakeAndDropWhileChallenge {

    public static void main(String... castleVania) {
        List<Integer> alucardHits = List.of(9, 7, 1, 8, 5);
        Set<Integer> draculaHits = Set.of(9, 6, 5, 7, 8);

        Stream<Integer> alucardPerformedHits = alucardHits.stream()
                .takeWhile(i -> i > 5)
                .dropWhile(i -> i > 8);

        Stream<Integer> draculaPerformedHits = draculaHits.stream()
                .takeWhile(i -> i > 1)
                .dropWhile(i -> i > 7);

        Stream.of(alucardPerformedHits, draculaPerformedHits).flatMap(h -> h)
                .forEach(System.out::print);
    }

}
/*
Let's analyze the first stream:

List<Integer> alucardHits = List.of(9, 7, 1, 8, 5);

Stream<Integer> alucardPerformedHits = alucardHits.stream()
        .takeWhile(i -> i > 5)
        .dropWhile(i -> i > 8);

The trick of the takeWhile and dropWhile methods is that there is a break when the condition is not true.
So in this example, the takeWhile method will take numbers 9, 7 and it will break right after it.

In the dropWhile method, the numbers taken from the takeWhile method will be dropped if the condition is fulfilled.
Therefore, 9 will be dropped and we will have only 7 from this stream.

Let's analyze the second stream now:

Set<Integer> draculaHits = Set.of(9, 6, 5, 7, 8);

Stream<Integer> draculaPerformedHits = draculaHits.stream()
        .takeWhile(i -> i > 1)
        .dropWhile(i -> i > 7);

The trick on the second stream is that we are using a Set. Set is an unordered Collection.
So, numbers will be always ordered in a random way. The numbers sequence will be always random.
 */
