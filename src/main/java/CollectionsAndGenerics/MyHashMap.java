package CollectionsAndGenerics;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyHashMap {
    public static void main(String[] args) {

        Map<String, Customer> myHashMap = new HashMap<>();  //Not thread safe
        Map<String, Customer> myConHashMap = new ConcurrentHashMap<>(); // Thread safe

        Customer customer1 = new Customer(1L, "Dave", "Collier", "Hinckley","1234");
        Customer customer2 = new Customer(2L, "Sarah", "Collier", "Hinckley","1234");

        myHashMap.put(customer1.getFirstName(), customer1);
        myHashMap.put(customer2.getFirstName(), customer2);

        myConHashMap.put(customer1.getFirstName(), customer1);
        myConHashMap.put(customer2.getFirstName(), customer2);

        System.out.println("Customer 1 is : " + myHashMap.get("Dave").getFirstName()
                + " who lives in " + myHashMap.get("Dave").getAddress());

        System.out.println("Customer 1 is : " + myConHashMap.get("Dave").getFirstName()
                + " who lives in " + myConHashMap.get("Dave").getAddress());
    }
}
