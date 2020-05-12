package JavaQuiz;


public class AdvancedOverloadingChallenge {
    static String x = "";
    public static void main(String... doYourBest) {
        // 1
        System.out.println("Code Section: 1");
        executeAction(1);
        executeAction(1.0);
        executeAction(Double.valueOf("5"));
        executeAction(1L);
        System.out.println(x);
        /*
        In the first statement, we are invoking the executeAction method with the number 1. It's actually an integer number, it's not short or byte.
        So the widening concept will be used here, an integer will turn to a float:
        First invoked method: executeAction(float var)

        The second method invocation is with 1.0, again, it's double, it's not the float type. The widening will be used.
        Second invoked method:
        static void executeAction(double var)  {x += "f"; }

        The third method invocation is being made with the Wrapper type Double. A Double can't be an Integer but can be an Object. Again, Widening. Double is an Object!

        The third invoked method : static void executeAction(Object var) {x += "c"; }

        The fourth method invocation is going to be widened to float. So, the invoked method will be: static void executeAction(float var) {x += "e"; }
         */

        // 2
        System.out.println("\nCode Section: 2");
        x="";
        executeAction(Float.valueOf(1));
        executeAction(Double.valueOf(1));
        executeAction(new Object());
        executeAction(Float.valueOf(1));
        System.out.println(x);
        /*
        This alternative is incorrect because all of these types are Java Wrappers. All of them will be widened to Object. The only invoked method here is:
        static void executeAction(Object var)  {x += "c"; }
        With the output: cccc
         */

        // 3
        System.out.println("\nCode Section: 3");
        x="";
        executeAction(1F);
        executeAction(1.0D);
        executeAction();
        executeAction(1D);
        System.out.println(x);
        /*
        This alternative would be correct if weren't for the third method invocation.
        On this invocation: executeAction();
        There is no value being passed, so the varArgs method will be invoked: static void executeAction(int ... var) {x += "a"; }
        We can pass 0 or many values when we work with varArgs.
        The final output will be: efae
         */

        // 4
        System.out.println("\nCode Section: 4");
        x="";
        executeAction(1F);
        executeAction(1.0);
        executeAction(new StackOverflowError());
        executeAction(1);
        System.out.println(x);
        /*
        This alternative is correct. We can use letters after a number to make the type explicit. If we put an F or a D after the number we are specifying that the number is float or double.
        As we are declaring explicitly 1F, it's a float number and this is the invoked method: static void executeAction(float var) {x += "e"; } The number 1.0 is a double, so this is the invoked method: static void executeAction(double var) {x += "f"; }​​​​​​​
        The StackOverflowError will be widened to an Object type. static void executeAction(Object var) {x += "c"; }
        There is not a method receiving an int so there will be a widening here. int -> float​​​​​​​ static void executeAction(float var) {x += "e"; }
         */
    }

    static void executeAction(int... var) {x += "a"; }
    static void executeAction(Integer var) {x += "b"; }
    static void executeAction(Object var)  {x += "c"; }
    static void executeAction(short var)   {x += "d"; }
    static void executeAction(float var)   {x += "e"; }
    static void executeAction(double var)  {x += "f"; }
}

/*

*** Summary ***
Learn how to manipulate Advanced Overloading, which allows the JVM will choose the method that results in the best performance.

Background
There are some important concepts here.

The first one is that when we work with advanced overloading, the JVM will choose the method to make the less effort as possible prioritizing performance.

Keep in mind the priorities by the JVM:

1 - Widening
2 - Boxing
3 - Boxing+varargs

When there is widening, the nearest type will be invoked on the method.

byte -> short -> int -> long -> float -> double
             char  ->
 */
