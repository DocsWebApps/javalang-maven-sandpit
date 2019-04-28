package java8;

import java.util.ArrayList;
import java.util.List;

// Working with ArrayLists
public class MyArrayList2 {

    public static void main(String[] args) {
        List<Person> people=new ArrayList<>(5);
        people.add(new Person("Dave","Collier",50));
        people.add(new Person("Sarah","Collier",47));
        people.add(new Person("Frazer","Collier",19));
        people.add(new Person("Jess","Collier",9));

        // Print all people
        System.out.println("All people");
        people.forEach(p->System.out.println(p.toString()));

        // Print all adults
        System.out.println("\nAll adults");
        people.stream()
                .filter(p->p.getAge()>18)
                .forEach(p-> System.out.println(p.toString()));

        // Add Person
        System.out.println(("\nAdded John Doe"));
        people.add(new Person("John","Doe",90));
        people.stream()
                .filter(p->p.getFirstName().equals("John")&&p.getLastName().equals("Doe"))
                .forEach(p->System.out.println(p.toString()));
    }
}
