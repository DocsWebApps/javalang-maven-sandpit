package JavaQuiz;
import java.util.function.*;

public class JediDarkSideFight {
    public static void main(String... args) {
        String useSaber = "useSaber";
        Supplier<String> useForce = () -> "useForce";

        UnaryOperator<String> concatAfterUseSaber = useSaber::concat;
        System.out.println(concatAfterUseSaber.apply("Dave"));

        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("Dave"));

        BiFunction<UnaryOperator<String>, UnaryOperator<String>, Function<String, String>>
                attackDarkSide = Function::andThen;
        Function<String, String> finalAttack = attackDarkSide.apply(concatAfterUseSaber, toUpperCase);
        System.out.println(finalAttack.apply("Dave"));

        String finalFinalAttack = finalAttack.apply(useForce.get());
        Consumer<String> consumeForce = System.out::println;
        consumeForce.accept(finalFinalAttack);
    }
}
