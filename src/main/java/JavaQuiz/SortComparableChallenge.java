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

        // Option 1
        List list = new ArrayList<>(set);
        Collections.reverse(list);
        Collections.sort(list);

        list.forEach(System.out::println);
        System.out.println("\n");

        // Option 2
        List list1 = new ArrayList<>();
        list1.addAll(set);
        Collections.reverse(list1);
        Collections.reverse(list1);
        Collections.reverse(list1);

        list1.forEach(System.out::println);
        System.out.println("\n");

        // Option 3
        List list2 = new ArrayList<>();
        list2.addAll(set);
        Collections.sort(list2);

        list2.forEach(System.out::println);
        System.out.println("\n");

        // Option 4
        List list3 = new ArrayList<>();
        list3.addAll(set);
        Collections.reverse(list3);

        list3.forEach(System.out::println);
        System.out.println("\n");
    }

    static class Simpson implements Comparable<Simpson> {
        String name;

        public Simpson(String name) {
            this.name = name;
        }

        public int compareTo(Simpson simpson) {
            System.out.println("Called: " + simpson + " & " + this.name);
            return simpson.name.compareTo(this.name);
        }

        public String toString() {
            return this.name;
        }

    }
}
