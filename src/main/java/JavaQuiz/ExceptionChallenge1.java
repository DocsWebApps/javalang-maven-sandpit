package JavaQuiz;

import java.io.Closeable;
import java.io.IOException;

public class ExceptionChallenge1 {

    static String marvelHero = "";

    public static void main(String... marvel) throws Exception {
        Logan logan = new Logan();
        new ExceptionChallenge1().executeAction(new PeterParker(), logan);
        // 5. output = ">>#?#2"
        System.out.println(marvelHero + logan.wolverineCloseCount);
    }

    private void executeAction(Closeable spiderMan, AutoCloseable wolverine) throws Exception {
        // 2. Below line executes the close() method on each object after executing the code in the try block, last first so wolverine then spiderMan
        // therefore marvelHero = ">>#", wolverineCloseCount = 2
        try (spiderMan; wolverine) {
            //  1. marvelHero = ">", wolverineCloseCount = 1
            wolverine.close();
        } catch (Exception ignore) {
            // 3. exception thrown twice from 2x execution of wolverine, marvelHero = ">>#?", wolverineCloseCount = 2
            marvelHero += "?";
            // 4. marvelHero = ">>#?#", wolverineCloseCount = 2
            spiderMan.close();
        }
    }

    static class PeterParker implements Closeable {
        public void close() {
            marvelHero += "#";
        }
    }

    static class Logan implements AutoCloseable {
        int wolverineCloseCount = 0;

        public void close() throws IOException {
            marvelHero += ">";
            wolverineCloseCount++;

            if (wolverineCloseCount >= 1) {
                System.out.println("Exception thrown!!");
                throw new IOException();
            }
        }
    }

}

/*
Summary
To use key features from Exceptions.

Background
Let's analyze the key parts from the code.

    new ExceptionChallenge().executeAction(new PeterParker(), logan);

At the code above we are passing Closeable and AutoCloseable objects to the executeAction method.

Then we will be using the try with resources feature:

    try (spiderMan; wolverine) {
        wolverine.close();
    } catch (Exception ignore) {
        marvelHero += "?";
        spiderMan.close();
    }

It's important to emphasize that it's only possible to declare an AutoCloseable object outside the try declaration since Java 9,
it helps to decouple the instance from this block.

The first execution is inside the try block and it will invoke the close method from the wolverine object. Assigning the values:

    marvelHero will be ">"
    wolverineCloseCount will be 1

Then a key aspect from the try with resources feature is that the instances declared last will be closed first.
So, wolverine will be closed first and the following values will be assigned:

    marvelHero will be ">>"
    wolverineCloseCount will be 2

The spiderMan object will be closed concatenating # to the marvelHero variable.

As IOException() was thrown in the close method from wolverine, the catch block will be executed concatenating "?" to marvelHero and executing again the close method from spiderMan concatenating "#".

In the end, the output will be:
    >>#?#2
 */
