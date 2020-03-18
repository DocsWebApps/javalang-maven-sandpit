package JavaQuiz;

import java.util.List;

public class StreamChallenge10 {
    public static void main(String... doYourBest) {
        List<Simpson> simpsonList = List.of(new Simpson("Homer", 35),
                new Simpson("Margie", 35),
                new Simpson("Bart", 8),
                new Simpson("Maggie", 2),
                new Simpson("Bart", 10),
                new Simpson("Lisa", 8),
                new Simpson("Bart", 20));


        // methods below are lazy so only executed if necessary
        // Homer.getName()->Margie.getName()->Bart.getName()->Maggie.getName()->Bart.getName()->Lisa.getName()->Bart.getName()
        //                                  ->Bart.getAge(8)                  ->Bart.getAge(10)               ->Bart.getAge(20)
        //                                                                    ->SOUT(Bart(10))                ->SOUT(Bart(20))
        System.out.println("\nforEach()...");
        simpsonList.stream()
                // Top stream: Homer, Margie, Bart, Maggie, Bart, Lisa, Bart
                // The filter below is applied on each member of the stream above sequentially
                .filter(simpson -> simpson.getName().equals("Bart"))
                // When it gets to any Bart, a new stream gets created and the filter below is applied
                .filter(simpson -> simpson.getAge() > 9)
                // After applying the filter above a new stream gets created for any Bart > 9
                .forEach(System.out::println);
                // The method above is only executed if Bart > 9
                // then top stream above continues with next member since the terminal operation is forEach()

        // Homer.getName()->Margie.getName()->Bart.getName()->Maggie.getName()->Bart.getName()
        //                                  ->Bart.getAge(8)                  ->Bart.getAge(10)
        //                                                                    ->findFirst(Bart(10))
        //
        System.out.println("\nfindFirst()...");
        simpsonList.stream()
                // Top stream: Homer, Margie, Bart, Maggie, Bart, Lisa, Bart
                // The filter below is applied on each member of the stream above sequentially
                .filter(simpson -> simpson.getName().equals("Bart"))
                // When it gets to any Bart, a new stream gets created and the filter below is applied
                .filter(simpson -> simpson.getAge() > 9)
                // After applying the filter above a new stream gets created for any Bart > 9
                .findFirst();
                // The method above is only executed if Bart > 9
                // Since the terminal method is findFirst(), once satisfied further members of the top stream are discarded

        System.out.println("\nforEach() - parallel()...");
        // Unpredictable output
        simpsonList.stream().parallel()
                .filter(simpson -> simpson.getName().equals("Bart"))
                .filter(simpson -> simpson.getAge() > 9)
                .forEach(System.out::println);

        System.out.println("\nfindFirst() - parallel()...");
        // Unpredictable output - findFirst() makes no sense here
        simpsonList.stream().parallel()
                .filter(simpson -> simpson.getName().equals("Bart"))
                .filter(simpson -> simpson.getAge() > 9)
                .findFirst();

    }

    static class Simpson {
        private String name;
        private int age;

        public Simpson(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            System.out.println(name);
            return name;
        }
        public int getAge() {
            System.out.println(age);
            return age;
        }
    }
}
/*

Summary
You will learn details about working with Streams in Java.

Background
One very important thing to keep in mind with streams is that they are lazy.
That means that the JVM will make less effort as possible to execute the methods for a stream.

On this first line of the stream:
    simpsonList.stream().filter(simpson -> simpson.getName().equals("Bart"))

The getName method will run until Bart is found. That's why those three names will be printed:
    Homer
    Margie
    Bart

Once Bart is found, there is no reason to search ends for this line of code.

Now we have only Bart in the stream so only the age of Bart will be printed:
.filter(simpson -> simpson.getAge() > 9)

The final output will be:
Homer
Margie
Bart
10

 */
