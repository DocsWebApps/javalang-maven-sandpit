package LambdasAndFunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EligiblePersonExample {

    public static void main(String[] args) {
        // OLD-WAY: Prior to Java 8 functions were wrapped by an object, often an anonymous class implementing a functional interface (1 method interface )
        EligiblePersonExample.roboCallEligible(new EligiblePerson() {
            @Override
            public boolean isEligible(Person p) {
                return p.getAge() > 18;
            }
        });

        EligiblePersonExample.roboCallEligible(new EligiblePerson() {
            @Override
            public boolean isEligible(Person p) {
                return p.getAge() > 50;
            }
        });

//        NEW_WAY: User a lambda expression and a functional interface
        EligiblePersonExample.roboCallEligible((p) -> p.getAge() > 18 );
        EligiblePersonExample.roboCallEligible((p) -> p.getAge() > 50 );

        // NEW_WAY: Using a predefined functional interface called Predicate
        EligiblePersonExample.roboCallPredicate(p -> p.getAge() > 25);
        EligiblePersonExample.roboCallPredicate(p -> p.getAge() > 50);
    }

    public static void roboCallEligible(EligiblePerson eligiblePerson) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person.Builder().setGivenName("Jess").setAge(11).build());
        persons.add(new Person.Builder().setGivenName("Dave").setAge(52).build());
        persons.add(new Person.Builder().setGivenName("Sarah").setAge(49).build());
        persons.add(new Person.Builder().setGivenName("Fraz").setAge(21).build());

        for(Person person:persons) {
            if(eligiblePerson.isEligible(person)) {
                System.out.println(person.getGivenName());
            }
        }
    }

    public static void roboCallPredicate(Predicate<Person> pred) {
        List<Person> var = new ArrayList<>();
        var.add(new Person.Builder().setGivenName("Tom").setAge(10).build());
        var.add(new Person.Builder().setGivenName("Dick").setAge(30).build());
        var.add(new Person.Builder().setGivenName("Harry").setAge(60).build());

        for(Person person : var) {
            if (pred.test(person)) {
                System.out.println(person.getGivenName());
            }
        }
    }
}

interface EligiblePerson {
    boolean isEligible(Person p);
}
