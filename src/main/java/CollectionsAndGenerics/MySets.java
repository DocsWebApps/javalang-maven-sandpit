package CollectionsAndGenerics;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MySets {

    public static void main(String[] args) {
        Set<Customer> myHashSet = new HashSet<>();
        Set<Customer> myLinkedHasSet = new LinkedHashSet<>();
        Set<Customer> myTreeSet = new TreeSet<>(); // Have to implement a compare method or comparator to produce an ordered Set

        Customer customer1 = new Customer(1L, "Dave", "Collier", "Hinckley","1234");
        Customer customer2 = new Customer(2L, "Sarah", "Collier", "Hinckley","1234");
        Customer customer3 = new Customer(3L, "Fraz", "Collier", "Hinckley","1234");
        Customer customer4 = new Customer(4L, "Jess", "Collier", "Hinckley","1234");

        // HashSet
        System.out.println("HashSet...");
        myHashSet.add(customer1);
        myHashSet.add(customer2);
        myHashSet.add(customer3);
        myHashSet.add(customer4);
        myHashSet.add(customer1); // Not added as its a duplicate
        myHashSet.add(customer4); // Not added as its a duplicate
        myHashSet.stream().map(Customer::getFirstName).forEach(System.out::println);

        // LinkedHashSet
        System.out.println("\nLinkedHashSet...");
        myLinkedHasSet.add(customer1);
        myLinkedHasSet.add(customer2);
        myLinkedHasSet.add(customer3);
        myLinkedHasSet.add(customer4);
        myLinkedHasSet.add(customer2); // Not added as its a duplicate
        myLinkedHasSet.add(customer3); // Not added as its a duplicate
        myLinkedHasSet.stream().map(Customer::getFirstName).forEach(System.out::println);

        // TreeSet
        System.out.println("\nTreeSet...");
        myTreeSet.add(customer3);
        myTreeSet.add(customer4);
        myTreeSet.add(customer1);
        myTreeSet.add(customer2);
        myTreeSet.add(customer2); // Not added as its a duplicate
        myTreeSet.add(customer3); // Not added as its a duplicate
        myTreeSet.stream().map(Customer::getFirstName).forEach(System.out::println); // Sorted by ID

        for(Customer customer:myTreeSet) {
            System.out.println(customer.getFirstName()+" lives in " + customer.getAddress());
        }

        // No duplicates - IllegalArgumentException
        Set<Customer> noDuplicates = Set.of(new Customer(1L, "Dave", "Collier", "Hinckley","1234"),
                new Customer(1L, "Dave", "Collier", "Hinckley","1234"));

    }
}
