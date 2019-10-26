package Loops;

public class Person {
    private final String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    static class Builder {
        private String name;

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Person build() {
            return new Person(this.name);
        }
    }
}
