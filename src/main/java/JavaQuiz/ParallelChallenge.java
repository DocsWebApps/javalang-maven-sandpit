package JavaQuiz;

import java.util.List;

public class ParallelChallenge {
    public static void main(String... doYourBest) {
        List<Simpson> simpsons = List.of(new Simpson(10),
                new Simpson(15), new Simpson(11), new Simpson(20),
                new Simpson(22));

        simpsons.stream().parallel()
                .filter(s -> s.age > 10)
                .map(s -> s + ",")
                .forEachOrdered(System.out::print);

        System.out.println();

        simpsons.stream().parallel()
                .filter(s -> s.age > 10)
                .map(s -> s + ",")
                .forEach(System.out::print);
    }

    static class Simpson {
        int age;
        public Simpson(int age) {
            this.age = age;
        }
        public String toString() {
            return ""+ this.age;
        }
    }
}
/*
Summary
How to use Streams with the parallel method.

Background
Let's analyze both Streams.

    simpsons.stream().parallel()
            .filter(s -> s.age > 10)
            .map(s -> s + ",")
            .forEachOrdered(System.out::print);

The parallel method means that the Stream will iterate the elements
concurrently for improving performance.

Then it will filter all simpsons objects that have an age greater than 10.

Map each age with a "," and then if we use the forEachOrdered method the elements
will be printed in the order that the Stream started.

The output from the first Stream will always be:
    15,11,20,22,

In the second Stream:

    simpsons.stream().parallel()
            .filter(s -> s.age > 10)
            .map(s -> s + ",")
            .forEach(System.out::print);

The only difference is that we are printing the elements without any order.
When we use the parallel method the order of the elements will be changed,
that's because it's a parallel process on which elements are processed at the same
time for better performance. So the second  Stream will be always random.
 */
