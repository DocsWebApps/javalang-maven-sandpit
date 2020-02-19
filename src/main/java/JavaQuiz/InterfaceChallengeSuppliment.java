package JavaQuiz;

import java.util.function.Function;

public interface InterfaceChallengeSuppliment {
    String MASTER = "Yoda";

    // jedi = "Luke" from jump() and is a delimiter in String.join()
    // userSaber(0)= "S", userForce()="F" therefore result from attack() is "SLukeF"
    default String attack() {
        return jump(jedi -> String.join(jedi, useSaber(), useForce()));
    }

    private String jump(Function<String, String> function) {
        return function.apply("Luke");
    }

    private static String useSaber() {
        return "S";
    }

    default String useForce() {
        return "F";
    }
}
