package LambdasAndFunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;

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
        EligiblePersonExample.roboCallEligible((Person p) -> p.getAge() > 18 );
        EligiblePersonExample.roboCallEligible((Person p) -> p.getAge() > 50 );
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
}

interface EligiblePerson {
    boolean isEligible(Person p);
}
