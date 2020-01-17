package JavaQuiz;

import java.util.Arrays;
import java.util.List;

public class ListChallenge {

    public static void main(final String... doYourBest) {
        // despite being final, Arrays.asList() returns an immutable List collection
        final List<String> soldiers = Arrays.asList("Tyrion", "Arya", "John");

        if (soldiers.size() > 3) {
            soldiers.add("Cersei");
        } else {
            soldiers.add("Bran");
        }

        System.out.println(soldiers);
    }

}
