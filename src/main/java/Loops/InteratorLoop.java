package Loops;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InteratorLoop {

    public static void main(String... args) {
        List<Person> persons = new ArrayList<>();
        persons.add(Person.build().name("Dave").build());
        persons.add(Person.build().name("Sarah").build());
        persons.add(Person.build().name("Fraz").build());
        persons.add(Person.build().name("Jess").build());

        Iterator<Person> personsIterator = persons.iterator();
        while(personsIterator.hasNext()) {
            System.out.println(personsIterator.next().getName());
        }
    }
}
