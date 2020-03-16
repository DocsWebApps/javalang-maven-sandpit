package JavaQuiz;

import java.util.Set;

public class StreamDistinctChallenge1 {

    public static void main(String... doYourBest) {
        Set<Warrior> warriors = Set.of(new Warrior("Ezio"), new Warrior("Ezio"),
                new Warrior("Kratos"), new Warrior("Cloud"), new Warrior("Alucard"));

        warriors.stream()
                .distinct()
                .forEach(w -> System.out.println(w.name));
    }

    static class Warrior {
        private String name;
        Warrior(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return this.name.length();
        }

        @Override
        public boolean equals(Object obj) {
            return this.name.equals(((Warrior)obj).name);
        }
    }
}
/*
Summary
You will learn details about working with Streams in Java.

Background
The catch of this quiz is the Set.of factory method. Note that we are passing an Object that will be equal and will have the same hashcode number.

        Set.of(new Warrior("Ezio"), new Warrior("Ezio"),
            new Warrior("Kratos"), new Warrior("Cloud"), new Warrior("Alucard"));

The problem is that when we use two objects that are equal, the Set.of method will throw an IllegalArgumentException
since the Set interface doesn't allow duplicated elements.

Pay attention also that if we were using the factory method List.of, the IllegalArgumentException wouldn't be thrown. Then the output would be:

Ezio
Kratos
Cloud
Alucard
 */
