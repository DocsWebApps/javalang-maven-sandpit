package JavaQuiz;
import java.util.List;
import java.util.Optional;

public class OptionalChallenge {

    public static void main(String... doYourBest) {
        List<Integer> list = List.of(10, 1, 3, 5, 7, 9);

        Optional<Integer> number =
                list.stream()
                        .takeWhile(i -> i > 5)
                        // Alters List to (10) - take while i > 5,
                        // Since the first element is 10 this gets taken
                        // but as soon as it hits the second element, 1, it stops taking anymore since 1 is not greater than 5
                        // its does not continue iterating over 3, 5, 7 or 9
                        .dropWhile(i -> i > 9)
                        // Since 10 is > 9 this gets dropped
                        // Now have empty List as no members left match criteria
                        .findFirst()
                        .or(() -> Optional.of(777));
        //Output Optional[777] is therefore the output

        System.out.println(number);
    }

}
