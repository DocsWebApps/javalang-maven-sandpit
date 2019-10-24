package Interfaces;

public class Book implements Nameable {
    private final String name;

    Book(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    public void myType() {
        System.out.println("I'm a Book class");
    }
}
