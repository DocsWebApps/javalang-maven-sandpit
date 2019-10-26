package Loops;

public class Person {
    private final String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    static PersonBuilder build() {
        return new PersonBuilder();
    }

    static class PersonBuilder {
        private String name;

        PersonBuilder() {}

        PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        Person build() {
            return new Person(this.name);
        }
    }
}
