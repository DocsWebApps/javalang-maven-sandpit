package JavaQuiz;

public class TheSoldierResucerChallenge {
//    public static void main(String... doYourBest) {
//        StringBuilder yield = new StringBuilder(); // Line 4
//        yield.append(rescueSokolov("BigBoss"));
//        yield.append(rescueMeryl("SolidSnake"));
//        yield.append(rescueMeryl("LiquidSnakeX"));
//        System.out.println(yield);
//    }

//    static Object rescueSokolov(String eliteSoldier){
//        return switch (eliteSoldier){
//            case "BigBoss": yield  "S";
//            case "Ocelot": yield  "O";
//            default : yield  "D";
//        };
//    }
//
//    static <T extends String>  T rescueMeryl(T eliteSoldier){
//        return switch ((String) eliteSoldier){
//            case "SolidSnake" -> (T) "S";
//            case "LiquidSnake"->  {
//                yield (T) "L";
//            }
//            case "MetalGear": yield (T) "?"; // Line 25
//                default -> (T) "D";
//        };
//    }
}

/*

Summary
You will learn how to use a switch case statement with Java 13 making use of lambdas and the reserved word yield.

Background
Understand loop concept

Let's analyze the code:

In Java, we can't use keywords for naming variables.
It's tempting to say that when 'yield' is being declared there will be a compilation error but actually,
JVM architects decided to use reserved words instead of keywords, that's why it's possible to use yield as a variable name.
This code block will compile just fine.

public static void main(String... doYourBest) {
    StringBuilder yield = new StringBuilder();
    yield.append(rescueSokolov("BigBoss"));
    yield.append(rescueMeryl("SolidSnake"));
    yield.append(rescueMeryl("LiquidSnakeX"));
    System.out.println(yield);
}

The main difference between Java 12 and Java 13 is that now instead of using the break keyword, now we can only use yield.
This method will compile and run fine.

static Object rescueSokolov(String eliteSoldier){
    return switch (eliteSoldier){
        case "BigBoss": yield  "S";
        case "Ocelot": yield  "O";
        default : yield  "D";
    };
}

On this method, there is a problem, it won't compile because at line 25 we are using a different switch case statement,
the compile error message is the following:
Error:(25, 13) java: different case kinds used in the switch

Remember that in Java 13 switch case statement we can't mix lambdas with non-lambdas statements.

static <T extends String>  T rescueMeryl(T eliteSoldier){
    return switch ((String) eliteSoldier){
        case "SolidSnake" -> (T) "S";
        case "LiquidSnake"->  {
            yield (T) "L";
        }
        case "MetalGear": yield (T) "?"; // Line 25
        default -> (T) "D";
    };
}

Final answer:
It won't compile at line 25
 */
