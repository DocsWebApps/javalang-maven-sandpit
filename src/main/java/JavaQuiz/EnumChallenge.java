package JavaQuiz;

public class EnumChallenge {

    public static void main(String[] args) {
        DragonBalls dragonBalls[] = DragonBalls.FIRST.invokeShaneLong(); // FIRST has no meaning here other than to create an instance for the invokeShaneLong() method to be executed
        for(DragonBalls dragonBall: dragonBalls) {
            System.out.println(dragonBall);
        }
        System.out.println("\n");

        //1.
        DragonBalls dragonBall1 = DragonBalls.FIFTH;
        DragonBalls dragonBall2 = DragonBalls.SECOND;

        dragonBall2 = DragonBalls.FOURTH;
        dragonBall1 = dragonBall2;

        System.out.println((dragonBall2 == dragonBall1) ? "Same Dragonball" : "New Dragonball");
        System.out.println(dragonBall2);

        //2.
        dragonBall1 = DragonBalls.FIFTH;
        dragonBall2 = DragonBalls.SECOND;

        dragonBall2 = DragonBalls.FOURTH;
        dragonBall2 = dragonBall1;
        System.out.println((dragonBall2 == dragonBall1) ? "Same Dragonball" : "New Dragonball");
        System.out.println(dragonBall2);

        //3.
        dragonBall1 = DragonBalls.FIFTH;
        dragonBall2 = DragonBalls.SECOND;

        dragonBall2 = DragonBalls.FIFTH;

        System.out.println((dragonBall2 == dragonBall1) ? "Same Dragonball" : "New Dragonball");
        System.out.println(dragonBall2);

        //4.
        dragonBall1 = DragonBalls.FIFTH;
        dragonBall2 = DragonBalls.SECOND;

        for (DragonBalls dragonBall : dragonBalls) {
            if (dragonBall1.equals(dragonBall))
            break;
            dragonBall2 = dragonBall1;
        }
        System.out.println((dragonBall2 == dragonBall1) ? "Same Dragonball" : "New Dragonball");
        System.out.println(dragonBall2);

//        for (int i=0; i < dragonBalls.length; i++) {
//            System.out.println(dragonBalls[i].toString());
//        }
    }

    enum DragonBalls implements Invoker {
        FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH;

        public DragonBalls[] invokeShaneLong() {
            return DragonBalls.values();
        }
    }

    interface Invoker {
        DragonBalls[] invokeShaneLong();
    }
}
/*
Summary
How you can use enums to implement interfaces

Background
An enum type is a special data type that enables for a variable to be a set of predefined constants.
The variable must be equal to one of the values that have been predefined for it.
Common examples include compass directions (values of NORTH, SOUTH, EAST, and WEST) and the days of the week.
Because they are constants, the names of an enum type's fields are in uppercase letters.

The first thing to observe is the implementation of the interface Invoker on the Enum.
It’s not very common to do this, but it’s possible.
When we access the Enum reference of the reference it does not make a difference.
The invokeShaneLong() method will be invoked in the same way bringing all the Enums declared on DragonBalls.
When we enter the loop, we are not using brackets ({}) on the “if” command.
This means that only one line will be executed.

Conclusion: Until the Enums are equaled, the looping will continue.
In the end, the iterated Enums will be FIFTH and equal to one another.

The output will be:

Same dragon ball
FIFTH
 */
