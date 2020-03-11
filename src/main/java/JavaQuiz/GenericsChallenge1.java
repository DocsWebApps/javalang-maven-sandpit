package JavaQuiz;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class GenericsChallenge1 {
    public static void main(String... doYourBest) {
        SimpsonFactory<Simpson> simpsonFactory =
                new SimpsonFactory<>(new Simpson("Homer"));

        List list = simpsonFactory.addToList(new ArrayList<>(),
                new ArrayList());
        System.out.println(((List<Simpson>) list).get(0).name);
//
//        List<SubSimpson> subSimpson = new ArrayList<SubSimpson>();
//        subSimpson .add(new SubSimpson("Dave"));
//
//        List list1 = simpsonFactory.addToList(new ArrayList<>(), Collections.singletonList(subSimpson));
    }
    static class Simpson {
        String name;
        public Simpson(String name) { this.name = name; }
    }

    static class SubSimpson {
        String name;
        public SubSimpson(String name) {this.name = name;}
    }

    static class SimpsonFactory<T> {
        T t;

        public SimpsonFactory(T t) { this.t = t; }

        public List<T> addToList(List<T> simpson1,
                                 List<? super Simpson> simpson2) {
            simpson1.add(t);
            simpson2.add(new Simpson("Maggie")); // 26
            return simpson1;
        }
    }
}
/*

Summary
You will learn details about working with Generics in Java.

Background
Let's analyze the code, in the first line:

SimpsonFactory<Simpson> simpsonFactory = new SimpsonFactory<>(new Simpson("Homer"));

We are passing the Simpson instance to the T generic type, T will become Simpson type.

Then we are going to invoke this method:

    simpsonFactory.addToList(new ArrayList<>(), new ArrayList());

Since we already passed the generic type in the constructor before it doesn't matter that we
are not passing the type in the ArrayLists.
The elements will be added into the list normally.
In simpson1 there will be only "Homer" and in simpson2 "Maggie".

Finally, "Homer" will be shown since simpson1 only element contains "Homer".
 */