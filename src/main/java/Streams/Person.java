package Streams;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;

    static PersonBuilder builder() {
        return new PersonBuilder();
    }

    static class PersonBuilder {
        private String name;
        private int age;

        PersonBuilder() {
        }

       PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        Person build() {
            return new Person(name, age);
        }
    }
}
