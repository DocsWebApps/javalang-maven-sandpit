package Loops;

import java.util.ArrayList;
import java.util.List;

public class ForLoops {
    public static void main(String... args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person.Builder().setName("Dave").build());
        persons.add(new Person.Builder().setName("Sarah").build());
        persons.add(new Person.Builder().setName("Fraz").build());
        persons.add(new Person.Builder().setName("Jess").build());

        for(int i=0; i < persons.size(); i++) {
            System.out.println("1: "+persons.get(i).getName());
        }

        for(Person p : persons) {
            System.out.println("2: "+p.getName());
        }

        persons.forEach(p -> System.out.println("3: "+p.getName()));

    }
}


