package JavaQuiz;

import java.util.Optional;
import java.util.stream.Collectors;


public class OptionalChallenge1 {

    // finalZionValue is not NULL, its a blank String !!
    static String finalZionValue = "";
    static int matrixCount = 0;

    public static void main(String... matrix) {
        Optional<String> optFromMatrix = Optional.ofNullable(finalZionValue);

        var agentSmith = "Virus";

        // Although orElse() is not executed, the method getVisionFromOracle() is evaluated
        // matrixCount gets incremented but finalZionValue stays as "Virus" for some fucking odd reason !
        finalZionValue += Optional.ofNullable(agentSmith).orElse(getVisionFromOracle());
        System.out.println("2: " + finalZionValue);

        finalZionValue += optFromMatrix.orElseGet(OptionalChallenge1::getVisionFromOracle);
        System.out.println("3: " + finalZionValue);

        finalZionValue += matrixCount;
        System.out.println("4: " + finalZionValue);

        String neo = null;
        try {
            Optional.ofNullable(neo).orElseThrow(IllegalArgumentException::new);
        } catch (Exception exception) {
            finalZionValue += Optional.ofNullable(neo).or(() -> Optional.of("theOne")).get();
            System.out.println("5: " + finalZionValue);
        }

        finalZionValue += Optional.of("trinity").stream().map(String::toUpperCase)
                .filter(trinity -> trinity.equals("TRINITY")).collect(Collectors.joining());
        System.out.println("6: " + finalZionValue);
    }

    static String getVisionFromOracle() {
        matrixCount++;
        finalZionValue = "KeyMaker";
        System.out.println("getVisionFromOracle() called: matrixCount, finalZionValue are : " + matrixCount + ", " + finalZionValue);
        System.out.println("1: " + finalZionValue);
        return "Architect";
    }

}
/*
Background
Java 8 introduced the Optional class in java.util package. When using Optional, you are able to specify alternate values to return or to run.
The result is that is more readable since information about the code that were previously hidden are now visible to developers.
Here is a detailed explanation of what happens when the main method is invoked:

In the orElse line:

    finalZionValue += Optional.ofNullable(agentSmith).orElse(getVisionFromOracle());

As agentSmith is not null, the orElse method won't be executed,
but the trick is that the getVisionFromOracle() method will be executed anyway incrementing the matrixCount to 1.

In the orElseGet line:

    finalZionValue += optFromMatrix.orElseGet(OptionalChallenge::getVisionFromOracle);

We are using the orElseGet method that blocks the invocation of the getVisionFromOracle() method invocation. This is the difference between orElse and orElseGet methods.

In the orElseThrow code:

    Optional.ofNullable(neo).orElseThrow(IllegalArgumentException::new);

We are comparing if neo is null, neo is null at this moment so IllegalArgumentException will be thrown.

    finalZionValue += Optional.ofNullable(neo).or(() -> Optional.of("theOne")).get();

As neo is null again, the or method will be invoked returning "theOne".

The last snippet of code will simply transform "trinity" to upper case returning "TRINITY":
finalZionValue += Optional.of("trinity").stream().map(String::toUpperCase)
        .filter(trinity -> trinity.equals("TRINITY")).collect(Collectors.joining());

The final output will be: Virus1theOneTRINITY
 */
