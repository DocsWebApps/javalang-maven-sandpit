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
