package JavaQuiz;

import java.util.ArrayList;
import java.util.List;

public class ArrayOutputChallenge {
    public static void main(String... doYourBest) {
        List<String> list = new ArrayList<>();

        list.add("Arya");
        list.add("Tyrion");
        list.add("Cersei");
        list.add("Daenerys");
        list.add("Jaime");

        doProcess(list);

        System.out.println(list.size());
    }

    static void doProcess(List<String> list) {
        for (String character : list) {
            if(character.equals("Cersei")) {
                System.out.println("We get to here, then BOOM !!");
                list.remove(character);
            }
        }
    }
}

/*
Summary
You will learn how to delete an element of an array within a looping.

Background
Note that in the middle of the looping we are trying to remove an element but as this ArrayList is being iterated we can't remove an element.

If we do that:

    for (String character : list) {
       if(character.equals("Cersei")) {
          list.remove(character);
       }
    }

We will get a ConcurrentModificationException because the element of the array can't be removed on its own iteration.

On the other hand if you use the class CopyOnWriteArrayList,
this example would work and it would remove the element with the value "Cersei" normally.

If you want more, go to the Java quizzes explanation videos:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi
 */
