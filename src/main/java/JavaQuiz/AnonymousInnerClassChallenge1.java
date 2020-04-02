package JavaQuiz;

import java.util.function.Predicate;

public class AnonymousInnerClassChallenge1 {

    public static void main(String... silentHill) {
        var newSlay = "---";
        var jamesShot = "---";

        Predicate<String> pyramidHeadAttack = new Predicate<String>() {
            @Override
            public boolean test(String pyramidHeadSlay) {
                /*
                The method intern() creates an exact copy of a String object in the heap memory and stores it in the String constant pool.
                Note that, if another String with the same contents exists in the String constant pool,
                then a new object won't be created and the new reference will point to the other String.
                 */
                return newSlay == new String(pyramidHeadSlay).intern(); // pyramidHeadSlay = "---": since using intern() result = true
            }
        }
        .and(new PyramidHead()) // axeAttack = "---": result = false
        .or(james -> james.equals(jamesShot)) // james = "---": result = true
        .negate(); // apply NOT to whole logic

        // !(true && false || true) -> !(false || true) -> !(true) = false
        System.out.println(pyramidHeadAttack.test("---"));

        System.out.println("\nMyStuff...");

        Predicate<String> doc1 = new Predicate<String>() {
            @Override
            public boolean test(String pyramidHeadSlay) {
                return newSlay == new String(pyramidHeadSlay).intern(); // pyramidHeadSlay="---": result = true
            }
        };

        Predicate<String> doc2 = new PyramidHead();

        Predicate<String> doc3 = james -> james.equals(jamesShot);

        System.out.println(doc1.test("---"));
        System.out.println(doc2.test("---"));
        System.out.println(doc3.test("---"));
    }

    static class PyramidHead implements Predicate<String> {
        @Override
        public boolean test(String axeAttack) {
            return axeAttack.equals("--!");
        }
    }
}
/*
Summary
You will learn how to manipulate the Predicate interface.
You will also learn the difference between lambda, the anonymous inner class, and normal instances.

Background
Let's analyze the code:

    new Predicate<String>() {
        @Override
        public boolean test(String pyramidHeadSlay) {
            return newSlay == new String(pyramidHeadSlay).intern();
        }
    }

Note that this 'interface instantiation' is actually an anonymous inner class.
Anonymous inner class is basically an instance with no name that implements the Predicate interface.
Why do we have this concept? Because we don't need to specify a name for it since we just want to reuse the method logic.
It can be easily replaced by lambda.

In the block of code, we have a static inner class that implements Predicate:

    static class PyramidHead implements Predicate<String> {
        @Override
        public boolean test(String axeAttack) {
            return axeAttack.equals("--!");
        }
    }

It's doing almost the same as the anonymous inner class, the only difference is that we have a name for this inner class.
Then we just have to instantiate this inner class into the predicate chain.

Finally, we are using the lambda concept that came to Java to facilitate our lives by using more succinct code.
With lambdas, it's possible to purely define our method/function and that's it, it's going to do what we want. Check it out:

It's far more simple than an anonymous inner class:
    james -> james.equals(jamesShot)

When we execute this line of code:
    System.out.println(pyramidHeadAttack.test("---"));

The first condition will be true since we are using the intern method that puts the String into the pool.

In the second condition, it will be false since "---" is different from "--!".

In the third condition, it will be true since "---" is equals to "---".

Then, the final condition will be !(true && false || true) -> !(false || true) -> !(true) = false

The solution of this quiz will be in the video as well, stay tuned to the Java Challengers channel to watch all solutions from the quizzes here:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi
 */