package Interfaces;

public class Person implements Nameable {
    private final String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    public void type() {
        System.out.println("I'm a Person class");
    }
}
