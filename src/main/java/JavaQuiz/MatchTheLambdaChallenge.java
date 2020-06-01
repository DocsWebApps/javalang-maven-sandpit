package JavaQuiz;

import java.util.function.*;

// Advanced !!
public class MatchTheLambdaChallenge {
    public static void main(String[] args) {
//        Supplier<String> moeBeerSupplier = () -> "BeerFromMoe"; // Line 6
//        Supplier<String> methodReferenceMoeBeerSupplier = String::new; // Line 7
//        System.out.println("Supplier example.......");
//        System.out.println(moeBeerSupplier.get());
//        System.out.println(methodReferenceMoeBeerSupplier.get().concat("BeerFromMoe"));
//
//        System.out.println("\nPredicate example.......");
//        Predicate<String> beerQualityTest = (beerQuality) -> beerQuality.equals("good"); // Line 9
//        Predicate<String> methodReferenceBeerQualityTest = "good"::equals; // Line 10
//        System.out.println(beerQualityTest.test("good") ? "Beer is good":"Beer is bad");
//        System.out.println(methodReferenceBeerQualityTest.test("yuk!")?"Beer is good":"Beer is bad");
//
//        System.out.println("\nConsumer example.......");
//        Consumer<String> beerConsumer = (beerBrand) -> System.out.println(beerBrand); // Line 12
//        Consumer<Integer> methodReferenceConsumer = System.out::println; // Line 13
//        beerConsumer.accept("Bass");
//        methodReferenceConsumer.accept(3);
//
//        System.out.println("\nFunction example.......");
//        Function<String, String> beerProcessor = (beer) -> "Yuk: " + beer; // Line 15
//        Function<String,String> methodReferenceBeerProcessor = "Yuk: "::concat; // Line 16
//        System.out.println(beerProcessor.apply("Guiness"));
//        System.out.println(methodReferenceBeerProcessor.apply("Stout"));
//
//        System.out.println("\nBiFunction example.......");
//        BiFunction<String, String, Object> biBeerProcessor = (beer1, beer2) -> beer1 + beer2; // Line 18
//        BiFunction<String, String, Object> methodReferenceBiBeerProcessor = String::compareTo; // Line 19
//        System.out.println(biBeerProcessor.apply("Lager", "Bitter"));
//        System.out.println(methodReferenceBiBeerProcessor.apply("Lager","Bitter"));

        // Choice 1 - Compiles OK
        Supplier<String> moeBeerSupplier = () -> "beerFromMoe";
        Supplier<String> methodReferenceMoeBeerSupplier = String::new;

        Predicate<String> beerQualityTest = (beerQuality) -> beerQuality.equals("good");
        Predicate<String> methodReferenceBeerQualityTest = "good"::equals;

        Consumer<String> beerConsumer = (beerBrand) -> System.out.println("Homer consumes the beer:" + beerBrand);
        Consumer<Integer> methodReferenceConsumer = System.out::println;

        Function<String, String> beerProcessor = beerBrand -> "Barney drinks the beer:" + beerBrand;
        Function<String, String> methodReferenceBeerProcessor = "Homer drinks the beer: "::concat;

        BiFunction<String, String, Object> biBeerProcessor = (beer1, beer2) -> beer1 + beer2;
        BiFunction<String, String, Object> methodReferenceBiBeerProcessor = String::compareTo;

        UnaryOperator<String> pureUniBeerProcessor = pureBeer -> pureBeer.concat("super");
        UnaryOperator<Integer> methodReferenceUniPureBeerProcessor = Integer::valueOf;

        BinaryOperator<String> pureBiBeerProcessor = (beer1, beer2) -> beer1 + beer2;
        BinaryOperator<String> methodReferenceBiPureBeerProcessor = String::concat;

        // Choice 2 - Won't compile
//        Supplier<String> moeBeerSupplier = () -> "beerFromMoe";
//        Supplier<String> methodReferenceMoeBeerSupplier = String::new;
//
//        Predicate<String> beerQualityTest = (beerQuality) -> beerQuality.equals("good");
//        Predicate<String> methodReferenceBeerQualityTest = String::equals;
//
//        Consumer<String> beerConsumer = (beerBrand) -> (beerBrand) -> System.out.println(beerBrand) ;
//        Consumer<Integer> methodReferenceConsumer = System.out::println;
//
//        Function<String, String> beerProcessor = (beerBrand) -> return "Barney drinks the beer:" + beerBrand;
//        Function<String,String> methodReferenceBeerProcessor = ""::concat;
//
//        BiFunction<String, String, Object> biBeerProcessor = (String beer1, String beer2) -> beer1 + beer2;
//        BiFunction<String, String, Object> methodReferenceBiBeerProcessor = String::compareTo;
//
//        UnaryOperator<String> pureUniBeerProcessor = pureBeer -> pureBeer.concat("super");
//        UnaryOperator<Integer> methodReferenceUniPureBeerProcessor = Integer::valueOf;
//
//        BinaryOperator<String> pureBiBeerProcessor = beer1 + beer2;
//        BinaryOperator<String> methodReferenceBiPureBeerProcessor = String::replace;

        // Choice 3 - Won't compile
//        Supplier<String> moeBeerSupplier = () -> {return "beerFromMoe"; };
//        Supplier<String> methodReferenceMoeBeerSupplier = String::new;
//
//        Predicate<String> beerQualityTest = (beerQuality) -> beerQuality.equals("good");
//        Predicate<String> methodReferenceBeerQualityTest = String::equals;
//
//        Consumer<String> beerConsumer = (beerBrand) -> (beerBrand) -> System.out.println(beerBrand);
//        Consumer<Integer> methodReferenceConsumer = Integer::floatValue;
//
//        Function<String, String> beerProcessor = beerBrand -> beerBrand;
//        Function<String,String> methodReferenceBeerProcessor = String::strip;
//
//        BiFunction<String, String, Object> biBeerProcessor = (beer1, beer2) -> { return (beer1 + beer2); };
//        BiFunction<String, String, Object> methodReferenceBiBeerProcessor = String::valueOf;
//
//        UnaryOperator<String> pureUniBeerProcessor = pureBeer -> pureBeer.concat("super");
//        UnaryOperator<Integer> methodReferenceUniPureBeerProcessor = Integer::valueOf;
//
//        BinaryOperator<String> pureBiBeerProcessor = beer1 + beer2; // at Line 24
//        BinaryOperator<String> methodReferenceBiPureBeerProcessor = String::concat;
    }
}

/*

Summary
Match the correspondent lambda and method reference to each functional interface and learn how to define your functions to perform the action you need.

Background
Let's analyze in detail how to build lambdas and method references for the main functional interfaces from Java.

The Supplier functional interface supplies a value. It's basically a lazy getter. We can use here therefore Supplier<String> moeBeerSupplier = () -> "beerFromMoe";

The method reference is similar is the instantiation of String. As this supplier supplies a String, the method reference for a String constructor fits perfectly into it:
Supplier<String> methodReferenceMoeBeerSupplier = String::new;

The Predicate functional interface receives any parameter and checks if logic is true or false. As in the first example, we are receiving a String and then comparing if it equals to good, that fits perfectly into the Predicate interface.
Predicate<String> beerQualityTest = (beerQuality) -> beerQuality.equals("good"); // Line 9

It's also possible to use method reference from created instances. On this method reference, we are using a String instance and checking if it's true or false.
Predicate<String> methodReferenceBeerQualityTest = "good"::equals; // Line 10

The Consumer will consume a parameter and process it. It's suitable to use the System.out.println on this functional interface since it also receives one parameter and is void:
Consumer<String> beerConsumer = (beerBrand) -> System.out.println("Homer consumes the beer:" + beerBrand); // Line 12

We can use System.out.println method reference since it receives one parameter and process it:
Consumer<Integer> methodReferenceConsumer = System.out::println; // Line 13

A Function receives one parameter and return one value. As we are doing exactly that with our lambda, it works perfectly:
Function<String, String> beerProcessor = (beerBrand) -> "Barney drinks the beer:" + beerBrand; // Line 15

Here, we are using a method reference that also receives one parameter and returns a value, so it works:
Function<String, String> methodReferenceBeerProcessor = "Homer drinks the beer: "::concat; // Line 16

A BiFunction receives two parameters and returns one value, as we are doing that with our lambda, it works:
BiFunction<String, String, Object> biBeerProcessor = (String beer1, String beer2) -> beer1 + beer2; // Line 18

This case is a bit different but also works. In this case, when we invoke this lambda, we will be passing the instance from a String, then the parameter for the compareTo method and then it will return the value:
BiFunction<String, String, Object> methodReferenceBiBeerProcessor = String::compareTo; // Line 19

The UnaryOperator has just one type for the receiving parameter and the return. Therefore, our lambda works fine since we are receiving a String and returning a String:
UnaryOperator<String> pureUniBeerProcessor = pureBeer -> pureBeer.concat("super"); // Line 21

This method reference receives an Integer and returns an Integer, it's exaclty what our functional interface expects, so it works:
UnaryOperator<Integer> methodReferenceUniPureBeerProcessor = Integer::valueOf; // Line 22

The BinaryOperator is similar to BiFunction, the difference is that it has only one type for the parameters and the return. As we are doing exactly that in our lambda, we are receiving two Strings and returinig a concatenated String, it works fine:
BinaryOperator<String> pureBiBeerProcessor = (beer1, beer2) -> beer1 + beer2; // Line 24

On this method reference, we are using the concat method. Even though the concat method receives only one method, it also does logic by using the instance of the String class. Therefore, it's necessary to pass the instance of the String class. So, that's why this code works, when we invoke this lambda, we will have to pass two parameters anyway because of the String instance.
BinaryOperator<String> methodReferenceBiPureBeerProcessor = String::concat; // Line 25

Watch the FULL explanation video about this quiz and many more at the Java Challengers channel:
 */
