package Loops;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InteratorLoop {

    public static void main(String... args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person.Builder().setName("Dave").build());
        persons.add(new Person.Builder().setName("Sarah").build());
        persons.add(new Person.Builder().setName("Fraz").build());
        persons.add(new Person.Builder().setName("Jess").build());

        Iterator<Person> personsIterator = persons.iterator();
        while(personsIterator.hasNext()) {
            System.out.println(personsIterator.next().getName());
        }
    }
}
