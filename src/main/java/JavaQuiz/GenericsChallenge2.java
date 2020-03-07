package JavaQuiz;

public class GenericsChallenge2 {

    public static void main(String... doYourBest) {
        Archer archer = new Archer();

        archer.attack("->");
        archer.attack(Double.valueOf(1.0));
        archer.attack(Float.valueOf(1));
    }

    static class Archer<T> {
        T t;

        void attack(T t) {
            // this.t = Archer Class t (defined but not initialised), not parameter t passed in !!
            System.out.println(this.t); // prints null from this.t
            System.out.println(t); // prints value passed in as t
        }
    }

}

/*
Summary
How to use generics and create generic components using this knowledge.

Background
Let's analyze the code:

    static class Archer<T> {
        T t;

        void attack(T t) {
            System.out.println(this.t);
        }
    }

The Archer class is receiving a generic type T in a class level.
When we invoke the method attack passing a parameter of any type it works fine.
However, note that the parameter is being passed to the local variable from the method and actually
the instance variable from the class is being printed.

The instance variable was never changed, that's why the result will be always null.
 */

