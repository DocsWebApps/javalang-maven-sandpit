package JavaQuiz;

public class AbstractChallenge {
    static final int FORCE = 10;

    public static void main(String... doYourBest) {
        DarthVader darthVader = new DarthVader() {
            public int getNumber(int number) {
                return number;
            }
        };

        // Method signatures are determined by their name and parameters only, not return type
        // So the override below overrides the LukeSkywalker getNumber(int number) method,
        // not the MasterYoda getNumber(Integer number)
        // In essence, MasterYoda has 2 getNumber() methods with the 2 different parameters
        MasterYoda masterYoda = new AbstractChallenge().new MasterYoda() {
            public int getNumber(int number) {
                return number;
            }
        };


        System.out.println(darthVader.getNumber(FORCE) + ":" + masterYoda.getNumber(FORCE) + ":" + masterYoda.getNumber(Integer.valueOf(FORCE)));

        System.out.println("The stronger Jedi is: " + (darthVader.getNumber(FORCE) >
                masterYoda.getNumber(FORCE) ? "Darth Vader" : "Master Yoda"));

        System.out.println("The stronger Jedi is: " + (darthVader.getNumber(FORCE) >
                masterYoda.getNumber(Integer.valueOf(FORCE)) ? "Darth Vader" : "Master Yoda"));
    }

    // Overloading - same method name but different signature
    // Does not override the LukeSkywalker getNumber(int number) method
    abstract class MasterYoda implements LukeSkywalker {
        int getNumber(Integer force) {
            return force + 10;
        }
    }

    // Overriding - same method name and signature
    // Overrides DarthVader getNumber(in number) method
    interface LukeSkywalker extends DarthVader {
        int getNumber(int force);
    }

    interface DarthVader {
        int getNumber(int force);
    }
}
/*
On the first blocks of code we are creating an inner class that implements those interfaces and also overriding their methods:

DarthVader darthVader = new DarthVader() {
    public int getNumber(int number) {
        return number;
    }
};

MasterYoda masterYoda = new AbstractChallenge().new MasterYoda() {
    public int getNumber(int number) {
        return number;
    }
};

There is a trick on the MasterYoda method override.
Actually, the method that is being overridden is from the LukeSkywalker interface because we are using the int primitive type in the arguments.

Now, let's analyse the output code:

System.out.println(darthVader.getNumber(FORCE) + masterYoda.getNumber(Integer.valueOf(FORCE)));

When we are invoking the darthVader.getNumber(FORCE) method we will be passing 10 and the overridden method
in the DarthVader interface implementation will be invoked will return 10.

The other trick is when we invoke the masterYoda.getNumber(Integer.valueOf(FORCE);

Analyzing this method invocation, we can realize that an Integer wrapper type is being passed to the method.
Now overloading concepts are involved as well. As we overridden only the LukeSkyWalker method, the MasterYoda method will be invoked as the following code shows:

int getNumber(Integer force) {
    return force + 10;
}

On this method invocation, 20 will be returned.

In the last block of the quiz is only to confirm that Master Yoda is the double more powerful than Darth Vader!

System.out.println("The stronger Jedi is: " + (darthVader.getNumber(FORCE) > masterYoda.getNumber(FORCE) ? "Darth Vader" : "Master Yoda"));
 */
