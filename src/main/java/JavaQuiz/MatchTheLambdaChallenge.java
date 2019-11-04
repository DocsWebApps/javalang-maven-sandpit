package JavaQuiz;

import java.util.function.*;

// Advanced !!
public class MatchTheLambdaChallenge {
    public static void main(String[] args) {
        Supplier<String> moeBeerSupplier = () -> "BeerFromMoe";
        Supplier<String> methodReferenceMoeBeerSupplier = String::new;

        Predicate<String> beerQualityTest = (beerQuality)->beerQuality.equals("good");
        Predicate<String> methodReferenceBeerQualityTest = "good"::equals;

        Consumer<String> beerConsumer = (beerBrand) -> System.out.println(beerBrand);
        Consumer<String> methodReferenceConsumer = System.out::println;

        Function<String,String> beerProcessor = (beer)->"Yuk: " + beer;
        Function<String,String> methodReferenceBeerProcessor = "Yuk: "::concat;

        BiFunction<String,String,Object> biBeerProcessor = (beer1,beer2)-> beer1 + beer2;
        BiFunction<String,String,Object> methodReferenceBuBeerProcessor= String::compareTo;

        UnaryOperator<String> pureUniBeerProcessor = pureBeer-> pureBeer.concat("super");
        UnaryOperator<String> methodReferenceUniPureBeerProcessor = String::valueOf;

        BinaryOperator<String> pureBiBeerProcessor = (beer1,beer2)-> beer1 + beer2;
        BinaryOperator<String> methodReferenceBiPureBeerProcessor = String::concat;

        System.out.println(moeBeerSupplier.get());
        String dave = methodReferenceMoeBeerSupplier.get();

        System.out.println(methodReferenceMoeBeerSupplier);
        System.out.println(methodReferenceBeerQualityTest.test("good"));

        beerConsumer.accept("bass");
        methodReferenceConsumer.accept("Lager");

        System.out.println(beerProcessor.apply("Bitter"));
        System.out.println(methodReferenceBeerProcessor.apply("Guiness"));

        System.out.println(biBeerProcessor.apply("Lager","Bitter"));
        System.out.println(methodReferenceUniPureBeerProcessor.apply("Bitter"));

        System.out.println(pureBiBeerProcessor.apply("Bud", "Wiser"));
        System.out.println(methodReferenceBiPureBeerProcessor.apply("Lager","Bitter"));
    }
}
//
//
//
//
//    I create this class.
//        import java.util.function.*;
//
//public class MatchTheLambdaChallenger {
//
//    public static void main(String... doYourBest) {
//        Supplier<String> moeBeerSupplier = null; // Line 6
//        Supplier<String> methodReferenceMoeBeerSupplier = null; // Line 7
//
//        Predicate<String> beerQualityTest = null; // Line 9
//        Predicate<String> methodReferenceBeerQualityTest = null; // Line 10
//
//        Consumer<String> beerConsumer = null; // Line 12
//        Consumer<Integer> methodReferenceConsumer = null; // Line 13
//
//        Function<String, String> beerProcessor = null; // Line 15
//        Function<String,String> methodReferenceBeerProcessor = null; // Line 16
//
//        BiFunction<String, String, Object> biBeerProcessor = null; // Line 18
//        BiFunction<String, String, Object> methodReferenceBiBeerProcessor = null; // Line 19
//
//        UnaryOperator<String> pureUniBeerProcessor = null; // Line 21
//        UnaryOperator<String> methodReferenceUniPureBeerProcessor = null; // Line 22
//
//        BinaryOperator<String> pureBiBeerProcessor = null; // Line 24
//        BinaryOperator<String> methodReferenceBiPureBeerProcessor = null; // Line 25
//
//    }
//
//
//    Match a suitable lambda and method reference to the correspondent line.
//    javac MatchTheLambdaChallenger.java
//
//    java MatchTheLambdaChallenger
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    Choice 1
//
//
//
//
//            () -> "beerFromMoe" // at Line 6
//    String::new; // at Line 7
//
//(beerQuality) -> beerQuality.equals("good"); // at Line 9
//"good"::equals; // at Line 10
//
//(beerBrand) -> System.out.println("Homer consumes the beer:" + beerBrand) ; // at Line 12
//    System.out::println; // at Line 13
//
//    beerBrand -> "Barney drinks the beer:" + beerBrand; // at Line 15
//"Homer drinks the beer: "::concat; // at Line 16
//
//(beer1, beer2) -> beer1 + beer2; // at Line 18
//    String::compareTo; // at Line 19
//
//    pureBeer -> pureBeer.concat("super"); // at Line 21
//    Integer::valueOf; // at Line 22
//
//    beer1 + beer2; // at Line 24
//    String::concat; // at Line 25
//
//
//
//
//
//
//
//
//
//    Choice 2
//
//
//
//
//            "beerFromMoe" // at Line 6
//    String::new; // at Line 7
//
//(beerQuality) -> return beerQuality.equals("good"); // at Line 9
//    String::equals; // at Line 10
//
//(beerBrand) -> System.out.println(beerBrand) ; // at Line 12
//    System.out::println; // at Line 13
//
//(beerBrand) -> return "Barney drinks the beer:" + beerBrand; // at Line 15
//""::concat; // at Line 16
//
//(String beer1, String beer2) -> beer1 + beer2; // at Line 18
//    String::compareTo; // at Line 19
//
//    pureBeer -> pureBeer.concat("super"); // at Line 21
//    Integer::valueOf; // at Line 22
//
//    beer1 + beer2; // at Line 24
//    String::replace; // at Line 25
//
//
//
//
//
//
//
//
//
//    Choice 3
//
//
//
//
//            () -> {return "beerFromMoe"; } // at Line 6
//    String::new; // at Line 7
//
//(beerQuality) -> beerQuality.equals("good"); // at Line 9
//    String::equals; // at Line 10
//
//(beerBrand) -> System.out.println(beerBrand) ; // at Line 12
//    Integer::floatValue; // at Line 13
//
//    beerBrand -> beerBrand; // at Line 15
//    String::strip; // at Line 16
//
//(beer1, beer2) -> { return (beer1 + beer2); } // at Line 18
//    String::valueOf; // at Line 19
//
//    pureBeer -> pureBeer.concat("super"); // at Line 21
//    Integer::valueOf; // at Line 22
//
//    beer1 + beer2; // at Line 24
//    String::concat; // at Line 25
