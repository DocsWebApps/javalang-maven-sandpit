package Interfaces;

import java.util.ArrayList;
import java.util.List;

public class RunExamples {
    public static void main(String[] args) {
        ElectronicDevice tv = new Television();
        ElectronicDevice.infoUserStatic();
        tv.infoUser();
        tv.turnOn();
        tv.turnOff();

        ElectronicDevice phone = new Mobilephone();
        ElectronicDevice.infoUserStatic();
        phone.infoUser();
        phone.turnOn();
        phone.turnOff();

        Person person = new Person("Dave");
        Book book = new Book("On the trail of the assassins");

        // Polymorphism at its best, by implementing the interface HasName in the
        // 3 classes Television, Person and Book - I can create a collection of HasName objects (casting TV as it extends ElectronicDevice)
        // and iterate through them all :-)
        List<Nameable> listNames = new ArrayList<>();
        listNames.add(person);
        listNames.add(book);
        listNames.add((Nameable) tv);

        for(Nameable name : listNames) {
            System.out.println("My name property is: " + name.name());
            System.out.println("Default instance method: " + name.aDefaultMethod());
            System.out.println("Interface Constant: " + name.INTERFACE_NAME);
            System.out.println("Static method: " + Nameable.aStaticMethod());
        }
    }
}
