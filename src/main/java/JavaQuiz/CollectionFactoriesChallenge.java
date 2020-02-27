package JavaQuiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionFactoriesChallenge {
    public static void main(String... doYourBest) {
        final Collection<Object> finalDcCharacters = new ArrayList<>();
        List<String> dcHeroes = List.of();
        Set<String> dcVillains = Set.of();

        try {
            dcHeroes.add("Deadpool");
        } catch (UnsupportedOperationException e) {
            System.out.print("no space for Marvel heros here!|");
        }

        try {
            dcVillains.stream().collect(Collectors.toList())
                    .add("Harley Quinn");
            finalDcCharacters.addAll(new ArrayList<>(dcVillains));
        } catch (UnsupportedOperationException | IllegalArgumentException e) {
            System.out.print("no space for villains");
            System.exit(0);
        }

        try {
            var villains = Set.copyOf(dcVillains);
            finalDcCharacters.addAll(List.of(villains,
                    Set.of("Joker", "Riddler", "Joker")));
        } catch (IllegalArgumentException e) {
            System.out.print("Where are the villains?");
        }
        finalDcCharacters.forEach(System.out::println);
    }
}
/*
Summary
To use Collections in a more practical way with Collections Factory.

Background
Let's analyze the code. At the first line, we are trying to add an element to an immutable list.

    dcHeros.add("Deadpool");

We can see that the method List.of() returns an immutable list:

    static <E> List<E> of() {
        return ImmutableCollections.emptyList();
    }

When we try to add an element into an immutable list we get an Exception. So the first output will be:

"no space for Marvel heros here!|"

Then at this line:

    dcVillains.stream().collect(Collectors.toList()).add("Harley Quinn");

We are trying to add an element to list that was returned from the stream that was never stored anywhere ,
so the element "Harley Quinn" will be lost.

The following line of code is adding the elements from dcVillains normally into the finalDcCharacters
list since finalDcCharacters is not an immutable list.

    finalDcCharacters.addAll(new ArrayList<>(dcVillains));

Then we will be adding the copy of the dcVillains list into a var:

    var villains = Set.copyOf(dcVillains);

At the addAll code, we are adding a List.of and then a Set.of but note that we are passing Joker twice into a Set. We will have an IllegalArgumentException because of that.

finalDcCharacters.addAll(List.of(villains,
        Set.of("Joker", "Riddler", "Joker")));

Then this we will have the output:
    "Where are the villains?"

Therefore, the final result will be:

    no space for Marvel heroes here!|Where are the villains?
 */
