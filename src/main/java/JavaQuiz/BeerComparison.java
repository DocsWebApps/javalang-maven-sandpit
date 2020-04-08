package JavaQuiz;

import java.util.function.*;

public class BeerComparison {

    public static void main(String... doYourBest) {
        Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> number -> number > pivot;
        // This function takes an Integer and transforms it into a predicate
        // Breaking it down therefore as follows
        Predicate<Integer> docsPrd = isGreaterThan.apply(6); // pivot = 6
        System.out.println(docsPrd.test(7)); // should be true // number = 7, 7 > 6 == true

        Supplier<Integer> moeSupplier = () -> { return 5; };
        Consumer<Object> homerConsumer = System.out::println;

        UnaryOperator<Integer> carlOperator = (c) -> Integer.valueOf(c); // return 5 (Integer)
        BinaryOperator<Integer> barneyOperator = Integer::sum; // return 2 + 2 = 4

        var beersSum = carlOperator.apply(5) + barneyOperator.apply(2, 2); // 5 + 4 = 9

        System.out.println(moeSupplier.get()); // return 5
        System.out.println(beersSum); // return 9
        homerConsumer.accept(isGreaterThan.apply(moeSupplier.get()).test(beersSum)); // is 9 > 5, yes true
    }

}
/*

Summary
You will learn in details about how functional interfaces work with Java.

Background
Functional interfaces are very important for Java because it makes code cleaner and easier to understand.

In the following code we will see how to manipulate a Function that returns a function of Predicate
that enables us to pass customized parameters our logic:

    Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> number -> number > pivot;

We first declare what is going to be received by the Function with pivot -> then we declare what is going
to be received for Predicate with number -> and finally we implement our logic with > number > pivot.

The Supplier interface has a function that returns a value or supplies a value, therefore in the below code we are
supplying the number 5:
    Supplier<Integer> moeSupplier = () -> { return 5; };

The Consumer interface contains a function that is void and receives an Object. As this functional method matches the System.out.println method, we can use it as a method reference.
Consumer<Object> homerConsumer = System.out::println;

The UnaryOperator functional interface has a method that receives a value and returns the same value.
UnaryOperator<Integer> carlOperator = (c) -> Integer.valueOf(c);

The BinaryOperator functional interface has a method that receives two values and returns the same value. It's very similar to UnaryOperator.
BinaryOperator<Integer> barneyOperator = Integer::sum;

In the below code we are simply adding two numbers and effectively invoking the functions we defined before, therefore the sum of the functions invocations will be 9.
var beersSum = carlOperator.apply(5) + barneyOperator.apply(2, 2);

moeSupplier will return 5
System.out.println(moeSupplier.get());

beersSum will be 9
System.out.println(beersSum);

Finally it's time to invoke our function of a function, in this code we are firstly using the homerConsumer
to print the information from the isGreaterThan function and then passing the value from moeSupplier into the
isGreaterThan Function, returning a Predicate and only then invoking the test method and passing the number 9.
homerConsumer.accept(isGreaterThan.apply(moeSupplier.get()).test(beersSum));

Therefore as we are comparing if 9 > 5 the result will be true.

The final output will be
5
9
true

Watch the FULL explanation video about this quiz and many more at the Java Challengers channel:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi
 */