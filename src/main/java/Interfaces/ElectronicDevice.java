package Interfaces;

// An Abstract class defines a class that can have abstract methods that must then
// be implemented in a subclass. It can also contain concrete static and instance methods.
public abstract class ElectronicDevice {
    public abstract void turnOn();
    public abstract void turnOff();

    public void infoUser() {
        System.out.println("You can also have concrete instance methods in an abstract class");
    }

    public static void infoUserStatic() {
        System.out.println("You can also have concrete static methods in an abstract class");
    }

}
/* Info on Abstract Classes
You can not instantiate an instance of an abstract class - period!!
Some ppl think that this is a way to instantiate an abstract class...

        ElectronicDevice tv1 = new ElectronicDevice() {};
        tv1.infoUser();

...BUT You are not creating an instance of your abstract class here.
Rather you are creating an instance of an anonymous subclass of your abstract class.
And then you are invoking the method on your abstract class reference pointing to subclass object.

This behaviour is clearly listed in the Java Language Specification - Section # 15.9.1: -

    If the class instance creation expression ends in a class body {} or {...},
    then the class being instantiated is an anonymous class.
    Then:

        If T denotes a class, then an anonymous direct subclass of the class named by T is declared. It is a compile-time error if the class denoted by T is a final class.
        If T denotes an interface, then an anonymous direct subclass of Object that implements the interface named by T is declared.
        In either case, the body of the subclass is the ClassBody given in the class instance creation expression.
        The class being instantiated is the anonymous subclass.
 */
