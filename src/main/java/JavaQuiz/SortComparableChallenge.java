package JavaQuiz;

import java.util.*;

public class SortComparableChallenge {
    public static void main(String... doYourBest) {
        Set set = new TreeSet<>();
        set.add(new Simpson("Homer"));
        set.add(new Simpson("Marge"));
        set.add(new Simpson("Lisa"));
        set.add(new Simpson("Bart"));
        set.add(new Simpson("Maggie"));

        // Order of Set is: Marge, Maggie, Lisa, Homer, Bart since the definition of compareTo() produces a reverse order
        System.out.println("Original order:");
        set.forEach(simpson -> {
            System.out.println(simpson);
        });
        System.out.println("\n");

        // Goal is to Print out: Bar, Homer, Lisa, Maggie, Marge

        // Option 1: Wrong
        List list = new ArrayList<>(set);
        Collections.reverse(list); // reverses list which produces the correct order
        Collections.sort(list); // but then uses sort() which uses compareTo() which reverses the order again

        list.forEach(System.out::println);
        System.out.println("\n");

        // Option 2: Correct
        List list1 = new ArrayList<>();
        list1.addAll(set);
        Collections.reverse(list1); // order is reversed and OK
        Collections.reverse(list1); // order is put back to original order, no good
        Collections.reverse(list1); // order is reversed again to OK

        list1.forEach(System.out::println);
        System.out.println("\n");

        // Option 3: Wrong
        List list2 = new ArrayList<>();
        list2.addAll(set);
        Collections.sort(list2); // order starts reversed and is kept reversed by the sort() which calls compareTo()

        list2.forEach(System.out::println);
        System.out.println("\n");

        // Option 4: Correct
        List list3 = new ArrayList<>();
        list3.addAll(set);
        Collections.reverse(list3); // reverses original order - OK

        list3.forEach(System.out::println);
        System.out.println("\n");
    }

    static class Simpson implements Comparable<Simpson> {
        String name;

        public Simpson(String name) {
            this.name = name;
        }

        public int compareTo(Simpson simpson) {
//            System.out.println("Called: " + simpson + " & " + this.name);
            return simpson.name.compareTo(this.name); // Produces reverse order !
        }

        public String toString() {
            return this.name;
        }

    }
}
