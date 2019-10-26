package Loops;

import java.util.ArrayList;
import java.util.List;

public class WhileLoops {
    public static void main(String... args) {
        List<Person> persons = new ArrayList<>();
        persons.add(Person.build().name("Dave").build());
        persons.add(Person.build().name("Sarah").build());
        persons.add(Person.build().name("Fraz").build());
        persons.add(Person.build().name("Jess").build());

        int i = 0;
        while (i < persons.size()) {
            System.out.println(persons.get(i).getName());
            i++;
        }
    }
}
