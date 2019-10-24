package Interfaces;

// Abstract class defines a class that can have abstract methods that can then be implemented in many different ways in many different sub classes
public abstract class ElectronicDevice {
    public abstract void turnOn();
    public abstract void turnOff();

    void infoUser() {
        System.out.println("You can also have concrete instance methods in an abstract class");
    }

    static void infoUserStatic() {
        System.out.println("You can also have concrete static methods in an abstract class");
    }
}
