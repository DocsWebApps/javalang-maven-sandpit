package JavaQuiz;

import java.util.ArrayList;
import java.util.List;

public class ListRemoveIfChallenge {

    public static void main(String... dungeonsAndDragons) {
        List<Integer> list = new ArrayList<>();

        list.add(22);
        list.add(12);
        list.add(14);
        list.add(128);

        Integer prestoAge = 14;
        Integer dungeonMasterAge = 128;

        list.removeIf(e -> e == new Integer(12)
                || e == dungeonMasterAge
                || e == prestoAge
                || e.equals(new Integer(22)));

        System.out.println(list);
    }
}
/*
Summary
You will learn details about working with Wrappers in Java.

Background
The result will be [12, 128], let's see why.

There are very important concepts to explore with wrappers, it's caching.
The JDK developers created a rule that integer numbers from -128 to 127 will be cached.
That means that every variable created within this range will be cached, that means that a new object won't be created in the memory heap.

When we use the '==' operator we are comparing if the object reference is pointing to the same object.

So, in the first comparison:

    e == new Integer(12)

This condition will be false because when we use the new operator, we are forcing the creation of a new object in the memory heap. Caching won't work in this case.

In the second comparison:
    e == dungeonMasterAge

The 14 number will be cached normally, so this condition will be true.

In the third comparison:

    e == prestoAge

We are using here the number 128. Remember that the caching goes only until 127? So, this comparison will be false, this number will continue on the list.

In the fourth comparison:

    e.equals(new Integer(22))

This condition will be true because we are using the equals method that compares the value of the object not the reference of the object.
 */
