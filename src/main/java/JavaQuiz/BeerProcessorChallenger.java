package JavaQuiz;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BeerProcessorChallenger {
    private static int drunkeness;

    public static void main(String[] args) {
        Supplier<Integer> moeBeerSupplier = () -> drunkeness=5;
        drunkeness = 10;
        Function<Integer,Integer> processBeer = beerProcessor -> drunkeness = (beerProcessor + 2);
        Consumer<Integer> homeBeerConsumer = System.out::println;

        System.out.println(drunkeness);
        System.out.println(moeBeerSupplier.get());
        System.out.println(drunkeness);
        System.out.println(processBeer.apply(drunkeness));

        homeBeerConsumer.accept(moeBeerSupplier.get() + processBeer.apply(drunkeness));
    }
}
