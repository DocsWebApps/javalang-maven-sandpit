package JavaQuiz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GenericsChallenge3 {

    public static void main(String... doYourBest) {
        List<String> firstResult =  GenericsChallenge3.<String>get
                (new ArrayList<>(), new String("1")); // Line 9

        List<Object> secondResult = GenericsChallenge3.
                get("Homer", Double.valueOf("4"));

        Stream<Object> stream = Stream.concat(firstResult.stream(),
                secondResult.stream());
        stream.forEach(System.out::println);
    }

    public static <T> List<T> get(List<T> list, T t) {
        list.add(t);
        return list;
    }

    // When different types are received T defaults to String
    public static <T, R extends T> List<T> get(T type1, R type2) {
        List<T> list = new ArrayList<>();
        list.add(type1);
        list.add(type2); // Line 27
        return list;
    }
}

/*
Summary
How to use generics and create generic components using this knowledge.

Background
Let's analyse the code:

    List<String> firstResult =  GenericsChallenge3.<String>get
        (new ArrayList<>(), new String("1"));

In the line above, we are invoking the get method passing an ArrayList and a String as parameters.
It's going to work fine, T will be a String.
Even though we are passing an ArrayList without a type,
Java will implicitly pass a String since the second type is String.
If the second type was Integer, the type of the ArrayList would be Integer as well.

Then we invoke this other method:

    List<Object> secondResult = GenericsChallenge3.
        get("Homer", Double.valueOf("4"));

Note that we are passing two different types to those generic parameters:

    public static <T, R extends T> List<T> get(T type1, R type2) {

T will become an Object since we are passing two different types.
In order to make T compatible with the different types we are passing,
the JVM will transform T into an object so that the elements can be inserted into the ArrayList.

All the code will run fine and then will print:

    1
    Homer
    4.0
 */
