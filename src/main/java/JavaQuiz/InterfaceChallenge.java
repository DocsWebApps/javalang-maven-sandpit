package JavaQuiz;

import java.util.function.Function;

public class InterfaceChallenge {

    interface Jedi {
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

        private String useForce() {
            return "F";
        }
    }

    public static void main(String... starWars) {
        System.out.println(new Jedi() {
            // after attack() = "SLukeF"
            // after Jedi.userSaber() = "SLukeFS"
            // after Jedi.MASTER = "SLukeFSYoda"
            public String useForce() { return "X"; } }.attack() + Jedi.useSaber() + Jedi.MASTER);

        // Doesn't seem to override userForce() in the interface ??
        Jedi dave = new Jedi() {private String useForce() { return "X"; }};
        System.out.println(dave.useForce());

        InterfaceChallengeSuppliment dave1 = new InterfaceChallengeSuppliment() {
            public String useForce() { return "X"; }
        };
        System.out.println(dave1.useForce());

        // Does seem to override userForce() in the interface ??
        System.out.println(new InterfaceChallengeSuppliment() {
            // after attack() = "SLukeF"
            // after Jedi.userSaber() = "SLukeXS"
            // after Jedi.MASTER = "SLukeXSYoda"
            public String useForce() { return "X"; } }.attack() + Jedi.useSaber() + Jedi.MASTER);
    }
}

/*
Let's analyse this code:

    System.out.println(new Jedi() {
        public String useForce() {
            return "X";
        }
     }.attack() + Jedi.useSaber() + Jedi.MASTER);

Note that the useForce method is being overridden inside an anonymous inner class.
An anonymous inner class is basically a class that doesn't have a name implementing in our case the Jedi interface.
Then we are invoking the attack method.

    default String attack() {
        return jump(jedi -> String.join(jedi, useSaber(), useForce()));
    }

There is a trick here in the join method. The first argument of the join method is a delimiter.
As we are returning Luke in this code:

    private String jump(Function<String, String> function) {
        return function.apply("Luke");
    }

Luke will be the delimiter, and the useSaber, useForce methods are going to simply return a String.
So the first part of the String will be: SLukeF

Then the Jedi.useSaber() method will be invoked, and note that this method is being invoked in a static way.
So the method we overrode won't be invoked, this method will return S.

Finally, the constant Jedi.MASTER will be printed with the final input: SLukeFSYod
 */
