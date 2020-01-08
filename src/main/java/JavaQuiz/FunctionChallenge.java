package JavaQuiz;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings(value = "all")
public class FunctionChallenge {

    public static void main(String... doYourBest) {
        int firstResult;
        int secondResult;

        BiFunction<Integer, Integer, Integer> func;
        BiFunction<Integer, Integer, Integer> func2;
        Function<Integer,Integer> func3;

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        Function<Integer, Integer> sub = (a) -> a - 2;
        Function<Integer, Integer> mult = (a) -> a * 3;

        BiConsumer<Integer, Integer> consumer = (a, b)
                -> System.out.println(a + 2 + b + 2);

        // Which of the 4 below produces: 6 ?

        //1.
        func = add.andThen(sub).andThen(sub).andThen(sub);

        firstResult = func.apply(2, 2); // -2
        secondResult = add.apply(2, 2); // 4
        consumer.accept(firstResult, secondResult); //6

        //2.
        func = add.andThen(sub).andThen(sub).andThen(sub);
        firstResult = func.apply(2, 2); // -2
        secondResult = mult.apply(2); // 6
        sub.apply(2);
        consumer.accept(firstResult, secondResult); // 8

        //3.
        func = add.andThen(sub).andThen(sub).andThen(sub);
        firstResult = func.apply(2, 2); // -2

        func2 = add.andThen(sub).andThen(mult).andThen(sub);
        secondResult = func2.apply(2, 2); // 4
        consumer.accept(firstResult, secondResult); // 6

        //4.
        func3 = sub.andThen(sub).andThen(sub);
        firstResult = func3.apply(2); // -4
        secondResult = mult.apply(2); // 6
        consumer.accept(firstResult, secondResult); // 6
    }

}

