package Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamExamples {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(Person.builder().name("Dave").age(52).build());
        persons.add(Person.builder().name("Sarah").age(49).build());
        persons.add(Person.builder().name("Fraz").age(21).build());
        persons.add(Person.builder().name("Jess").age(11).build());

        // Print out adults
        persons.stream().filter(p-> p.getAge()>18).forEach(p-> System.out.println(p.getName()));

        // Print out combined age of all adults
        System.out.println(persons.stream().filter(p -> p.getAge()>18).mapToInt(Person::getAge).sum());

        // Print out combined age of adults whose name starts with "D"
        System.out.println(persons
                .stream()
                .filter(p->p.getAge()>18)
                .filter(p->p.getName().startsWith("D"))
                .mapToInt(Person::getAge)
                .sum());
    }
}
