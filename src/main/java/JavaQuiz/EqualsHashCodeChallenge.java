package JavaQuiz;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeChallenge {

    public static void main(String... doYourBest) {
        System.out.println(new Simpson("Bart").equals(new Simpson("Bart")));

        Simpson overriddenHomer = new Simpson("Homer") {
            public int hashCode() {
                return (43 + 777) + 1;
            }
        };

        System.out.println(new Simpson("Homer").equals(overriddenHomer));

        var set = new HashSet(Set.of(new Simpson("Homer"), new Simpson("Marge")));
        set.add(new Simpson("Homer"));
        set.add(overriddenHomer);

        System.out.println(set.size());
    }

    static class Simpson {
        String name;

        Simpson(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            Simpson otherSimpson = (Simpson) obj;
            return this.name.equals(otherSimpson.name) &&
                    this.hashCode() == otherSimpson.hashCode();
        }

        @Override
        public int hashCode() {
            return (43 + 777);
        }
    }

}
/*

Summary
You will learn how to compare if objects are equals and manipulate the hashcode method.

Background
In the first equals() method comparison, the result is true because the state of the object is exactly
the same and the hashcode() method returns the same value for both objects.

In the second equals() method comparison, the hashcode() method is being overridden for the
overridenHomer variable. The name is “Homer” for both Simpson objects, but the hashcode() method returns
a different value for overriddenHomer. In this case, the final result from the the equals()method will be
false because the method contains a comparison with the hashcode.

You might notice that the size of the collection is set to hold three Simpson objects.
Let’s check this in a detailed way.

The first object in the set will be will be inserted normally:

    new Simpson("Homer");

The next object will be inserted normally, as well, because it holds a different value from the previous object:

    new Simpson("Marge");

Finally,  the following Simpson object has the same value as the first object.
In this case the object won’t be inserted:

    set.add(new Simpson("Homer"));

As we know, the overridenHomer object uses a different hashcode value from the normal Simpson(“Homer”) instantiation.
For this reason, this element will be inserted into the collection:

    overriddenHomer;

Final Answer

The answer to this Java challenger is B. The output would be:

    true
    false
    3
 */


