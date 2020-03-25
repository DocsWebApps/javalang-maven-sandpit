package JavaQuiz;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashcodeContract {

    public static void main(String... doYourBest) {
        Set<Borat> borats = new HashSet<>();
        borats.add(new Borat(1, "Kazakhstan"));
        borats.add(new Borat(2, "USAndA"));
        borats.add(new Borat(2, "England"));
    }

    static class Borat {
        int id;
        String country;

        Borat(int id, String country) {
            this.id = id;
            this.country = country;
        }

        public int hashCode() {
            System.out.println("hashCode:" + this.id + this.country);
            return this.id;
        }

        public boolean equals(Object obj) {
            System.out.println("equals:" + this.id + this.country);
            return ((Borat) obj).country.equals(this.country);
        }
    }

}
/*

Summary
You will learn how the equals and hashcode contract works in different situations.

Background
The equals and hashcode methods have a contract that should be followed,
If the hashcode method returns true, the equals method might return true or false.
On the other hand, if the hashcode method returns false, the equals method MUST return false.
Let's keep in mind that the hashcode method is a comparator optimizer,
there is no point on verifying the equals method when the hashcode method is already false.
That's the whole point of this quiz.

Let's see why, when we add the first element into it:
    borats.add(new Borat(1, "Kazakhstan"));

Only the hashcode method will be invoked in the HashSet implementation since there is no comparison to make
because it's the first element. Just remember that when adding an element using Set,
the hashcode method of an element will be always invoked.

On the second insertion:
    borats.add(new Borat(2, "USAndA"));

The hashcode is different from the first element, that means that the elements are already different
and the equals method doesn't need to be invoked.

On the third insertion:
    borats.add(new Borat(2, "England"));

The hashcode is the same so that means that the equals method will also be invoked.
That's because the hashcode is only one field but the equals method is full object comparison.

Concluding, the output will be:

    hashCode:1Kazakhstan
    hashCode:2USAndA
    hashCode:2England
    equals:2England
 */
