package Loops;

import java.util.ArrayList;
import java.util.List;

public class WhileLoops {
    public static void main(String... args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person.Builder().setName("Dave").build());
        persons.add(new Person.Builder().setName("Sarah").build());
        persons.add(new Person.Builder().setName("Fraz").build());
        persons.add(new Person.Builder().setName("Jess").build());

        int i = 0;
        while (i < persons.size()) {
            System.out.println(persons.get(i).getName());
            i++;
        }
    }
}
