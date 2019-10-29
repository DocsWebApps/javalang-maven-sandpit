package LambdasAndFunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInLambdas {
    public static void main (String... args) {
        Predicate<Person> over55 = p -> p.getAge()>55;
        Supplier<Person> newPerson = Person::new;
        Consumer<String> printName = System.out::println;
        Function<Person, String> transformToString = p -> p.getYob().toString();

        Person person = newPerson.get();
        person.setYob(1959);
        person.setAge(60);
        printName.accept("Is this person over 55? " + (over55.test(person)? "Yes" :"No"));
        printName.accept("Year of birth is : " + transformToString.apply(person)+"\n");

        List<Person> persons = new ArrayList<>();
        persons.add(Person.builder().setGivenName("Jess").setAge(11).build());
        persons.add(Person.builder().setGivenName("Dave").setAge(52).build());
        persons.add(Person.builder().setGivenName("Sarah").setAge(49).build());
        persons.add(Person.builder().setGivenName("Fraz").setAge(21).build());

        // 1: Using a Predicate
        // In an aggregate
        System.out.println("People over 40 are:");
        Predicate<Person> over40 = p -> p.getAge()>40;
        persons.stream().filter(over40).forEach(p-> System.out.println(p.getGivenName()));

        // In a loop
        for(Person p:persons) {
            if(over40.test(p)) {
                System.out.println(p.getGivenName());
            }
        }

        // 2: Consumer
        Person me = persons.get(0);
        printName.accept(me.getGivenName());

        persons.stream().filter(p->p.getAge()<25).forEach(p->printName.accept(p.getGivenName()));

    }
}
