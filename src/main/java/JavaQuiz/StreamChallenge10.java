package JavaQuiz;

import java.util.List;

public class StreamChallenge10 {
    public static void main(String... doYourBest) {
        List<Simpson> simpsonList = List.of(new Simpson("Homer", 35),
                new Simpson("Margie", 35),
                new Simpson("Bart", 8),
                new Simpson("Bart", 10),
                new Simpson("Lisa", 8));

        // methods below are lazy so only executed if necessary
        System.out.println("\nforEach()...");
        simpsonList.stream()
                // Original stream: Homer, Margie, Bart, Lisa
                // The filter below is applied on each member of the stream above sequentially
                .filter(simpson -> simpson.getName().equals("Bart"))
                // When it gets to the 2 Bart's, the original stream blocks
                // and a new stream gets created containing only the 2 Bart's from the above filter
                .filter(simpson -> simpson.getAge() > 9)
                // After applying the filter above, new stream gets created containing only the 1 Bart(10)
                .forEach(System.out::println);
                // Method above is only executed on Bart(10),
                // then top stream above continues again with last member Lisa
                // since the terminal operation is forEach()

        System.out.println("\nfindFirst()...");
        simpsonList.stream()
                // Original stream: Homer, Margie, Bart, Lisa
                // The filter below is applied on each member of the stream above sequentially
                .filter(simpson -> simpson.getName().equals("Bart"))
                // When it gets to the 2 Bart's, the original stream blocks
                // and a 2nd stream gets created containing only the 2 Bart's from the above filter
                .filter(simpson -> simpson.getAge() > 9)
                // After applying the filter above, a 3rd stream gets created containing only the 1 Bart(10)
                .findFirst();
                // Once findFirst() is satisfied, all processing is stopped and the original stream is closed
                // without Lisa being used
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
