package CollectionsAndGenerics;

import java.util.*;

public class CustomerSortExample {
    public static void main(String[] args) {
        Comparator<Customer> sortByFirstName = new CustomerSortByFirstName();
        Comparator<Customer> sortById = new CustomerSortByID();

        List<Customer> customerList = Arrays.asList(
                new Customer(3L, "Frazer", "Collier", "Hinckley","1234"),
                new Customer(1L, "Dave", "Collier", "Hinckley","1234"),
                new Customer(2L, "Sarah", "Collier", "Hinckley","1234"),
                new Customer(4L, "Jessica", "Collier", "Hinckley","1234")
        );

        System.out.println("List Unsorted...");
        customerList.forEach(System.out::println);

        System.out.println("\nList Sorted by FirstName...");
        Collections.sort(customerList, sortByFirstName);
        customerList.forEach(System.out::println);

        System.out.println("\nList Sorted by Id...");
        Collections.sort(customerList, sortById);
        customerList.forEach(System.out::println);

        Set<Customer> customerSet = new HashSet<>();
        customerSet.addAll(Set.of(
                new Customer(3L, "Frazer", "Collier", "Hinckley","1234"),
                new Customer(1L, "Dave", "Collier", "Hinckley","1234"),
                new Customer(2L, "Sarah", "Collier", "Hinckley","1234"),
                new Customer(4L, "Jessica", "Collier", "Hinckley","1234")
        ));

        System.out.println("\nSet Unsorted");
        customerSet.forEach(System.out::println);
    }
}
