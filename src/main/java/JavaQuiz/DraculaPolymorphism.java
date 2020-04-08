package JavaQuiz;


public class DraculaPolymorphism {
    public static void main(String... doYourBest) {
        // In the example below:
        // Attribute and static methods come from the reference class,  Dracula
        // While instance methods come from the instance's class, Alucard
        Dracula dracula = new Alucard();

        System.out.println(dracula.name + dracula.getName()); // Dracula since attribute + Alucard from instance method
        System.out.println(dracula.metamorphosis()); // static method so werewolf from Dracula
    }

    static class Dracula {
        String name = "Dracula";

        static String metamorphosis() { return "werewolf";}

        String getName(){
            return this.name;
        }
    }

    static class Alucard extends Dracula {
        String name = "Alucard";

        static String metamorphosis() { return "bat";}

        String getName(){
            return this.name;
        }
    }
}

/*
Summary
Learn what happens when using Polymorphism with static methods and attributes that have the same name in the
parent and child classes.

Background
Polymorphism is one of the most important concepts in Object-Oriented programming, maybe event the most important.
A key thing to remember about polymorphism is that the object that is being instantiated will execute the method in the end.

Let's analyze the code:

The very first thing to notice is that we are using polymorphism on that line of the code, we are declaring the
parent class but instantiating it with the child class, which enables us to use polymorphic methods:
    Dracula dracula = new Alucard();

Then we will be using the name attribute but remember that attributes will never be overridden and there is no
polymorphism with attributes, only with instance methods. Therefore the name that will be printed will be from the
Dracula class since we declared the dracula variable with the type of Dracula. And the getName method will be from the Alucard class since we are using polymorphism and getName is an instance method:
System.out.println(dracula.name + dracula.getName());

Therefore it will print: DraculaAlucard

Finally, we are invoking the static method, keep in mind that a static method is not an instance method,
it's a class method and it doesn't depend on an instance to work. For that reason, polymorphism won't happen even
though we are using the same method name with the child class.
The invoked method will be from the class we declared the dracula instance, therefore it will be the Dracula class:

System.out.println(dracula.metamorphosis());

The information from the Dracula class will be printed then: werewolf

In conclusion, the final output will be:
DraculaAlucard
werewolf

Watch the FULL explanation video about this quiz and many more on the Java Challengers channel:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi
 */
