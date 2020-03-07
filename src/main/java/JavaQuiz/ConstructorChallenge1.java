package JavaQuiz;

public class ConstructorChallenge1 {
    public static void main(String... doYourBest) {
        Simpson simpson = new Simpson("Bart", 8);
        System.out.println(simpson.name + "," + simpson.age);
    }
    static abstract class Character {
        String name;
        int age = 35;
        static { System.out.println("D'oh"); }
        Character(String name, int age) {
            this.name = "Homer";
            this.age = this.age;
            System.out.println("c2");
        }
    }
    static class Simpson extends Character {
        Simpson(String name, int age) {
            super(name, age);
            System.out.println("c1");
        }
    }
}
/*
Summary
How to manipulate classes with constructors.

Background
Le's analyze the code:

We are invoking the Simpson class here with the values, "Bart" and age 8.

    Simpson simpson = new Simpson("Bart", 8);

One important thing to note is that static variables will be always executed first so the
first value to be printed will be:

    D'oh

Another important point of this quiz is that constructors have to invoke a super constructor before
executing its actions:

    Simpson(String name, int age) {
        super(name, age);

            // .....
    }

Then, note that we are assigning Homer to the name variable.

In the age variable, we are assigning the own instance variable as we are using "this".

    this.name = "Homer";
    this.age = this.age;

We will be printing c2 as well in this constructor.

After this constructor finishes its process the other one from the subclass will print c1.

Then the final result will be:
    D'oh
    c2
    c1
    Homer,35
 */
