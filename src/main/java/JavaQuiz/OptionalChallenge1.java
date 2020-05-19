package JavaQuiz;

import java.util.Optional;
import java.util.stream.Collectors;


public class OptionalChallenge1 {

    // finalZionValue is not NULL, its a blank String !!
    static String finalZionValue = "";
    static int matrixCount = 0;
    static int intCount = 1;

    public static void main(String... matrix) {
        Optional<String> optFromMatrix = Optional.ofNullable(finalZionValue);

        var agentSmith = "Virus";
        displayFinalZionValue("1");
        // Although orElse() is not executed, the method getVisionFromOracle() is evaluated
        // although matrixCount gets incremented but finalZionValue is assigned
        // as "Virus" and not "KeyMakerVirus" (since the method getVisionFromOracle() just evaluated)
        finalZionValue += Optional.ofNullable(agentSmith).orElse(getVisionFromOracle());
        displayFinalZionValue("3");

        finalZionValue += optFromMatrix.orElseGet(OptionalChallenge1::getVisionFromOracle);
        displayFinalZionValue("4");

        finalZionValue += matrixCount;
        displayFinalZionValue("5");

        String neo = null;
        try {
            Optional.ofNullable(neo).orElseThrow(IllegalArgumentException::new);
        } catch (Exception exception) {
            finalZionValue += Optional.ofNullable(neo).or(() -> Optional.of("theOne")).get();
            displayFinalZionValue("6");
        }

        finalZionValue += Optional.of("trinity").stream().map(String::toUpperCase)
                .filter(trinity -> trinity.equals("TRINITY")).collect(Collectors.joining());
        displayFinalZionValue("7");
    }

    static String getVisionFromOracle() {
        matrixCount++;
        finalZionValue = "KeyMaker";
        System.out.println("getVisionFromOracle() called: matrixCount, finalZionValue are : " + matrixCount + ", " + finalZionValue);
        displayFinalZionValue("2");
        return "Architect";
    }

    static void displayFinalZionValue(String myOrder) {
        System.out.println(intCount++ + " : " + myOrder + " : " + finalZionValue);
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
