package CollectionsAndGenerics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyLists {

    public static void main(String[] args) {
        List<Customer> myArrayList = new ArrayList<>(); // can hold duplicates and is ordered
        List<Customer> myLinkedList = new LinkedList<>(); // can hold duplicates and is ordered, good for lots if inserting in the middle of the list

        Customer customer1 = new Customer(1L, "Dave", "Collier", "Hinckley","1234");
        Customer customer2 = new Customer(2L, "Sarah", "Collier", "Hinckley","1234");
        Customer customer3 = new Customer(3L, "Fraz", "Collier", "Hinckley","1234");
        Customer customer4 = new Customer(4L, "Jess", "Collier", "Hinckley","1234");

        // ArrayList
        System.out.println("ArrayList...");
        myArrayList.add(customer1);
        myArrayList.add(customer2);
        myArrayList.add(customer3);
        myArrayList.add(customer4);
        myArrayList.stream().map(Customer::getFirstName).forEach(System.out::println);

        // LinkedList
        System.out.println("\nLinkedList...");
        myLinkedList.add(customer3);
        myLinkedList.add(customer4);
        myLinkedList.add(customer1);
        myLinkedList.add(customer2);
        myLinkedList.add(customer3);
        myLinkedList.add(customer4);
        myLinkedList.stream().map(Customer::getFirstName).forEach(System.out::println);
    }
}
