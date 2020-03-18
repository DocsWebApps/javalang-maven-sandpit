package CollectionsAndGenerics;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MyMaps {
    public enum Name {
        Dave, Sarah
    }

    public static void main(String[] args) throws InterruptedException {
        Map<String, Customer> myHashMap = new HashMap<>();  //Not thread safe
        Map<String, Customer> myConHashMap = new ConcurrentHashMap<>(); // Thread safe
        Map<Long, Customer> myHashTable = new Hashtable<>(); // Thread safe
        Map<Long, Customer> myTreeMap = new TreeMap<>(); // Ordered by key
        Map<String, Customer> myLinkedHashMap = new LinkedHashMap<>(); // Maintains insert order, good for intensive inserting in the middle of the map
        Map<Name, Customer> myEnumHasMap = new EnumMap<Name, Customer>(Name.class);
        Map<Long, Customer> myWeakHashMap = new WeakHashMap<>(); // Allows GC to clean up elements without a strong reference
//        Map<Long, Customer> mySoftHashMap = new SoftHashMap<>(); Deprecated ??

        Customer customer1 = new Customer(1L, "Dave", "Collier", "Hinckley","1234");
        Customer customer2 = new Customer(2L, "Sarah", "Collier", "Hinckley","1234");

        // HashMap
        System.out.println("HashMap...");
        myHashMap.put(customer1.getFirstName(), customer1);
        myHashMap.put(customer2.getFirstName(), customer2);
        System.out.println("Customer 1 is : " + myHashMap.get("Dave").getFirstName()
                + " who lives in " + myHashMap.get("Dave").getAddress());
        myHashMap.keySet().forEach(key -> {
            System.out.println(key + " lives in " + myHashMap.get(key).getAddress());
        });

        // Alternative iteration
        for (String key:myHashMap.keySet()) {
            System.out.println(myHashMap.get(key).getFirstName() + " lives in " + myHashMap.get(key).getAddress());
        }

        // Concurrent Hash Map
        System.out.println("\nConcurrentHashMap...");
        myConHashMap.put(customer1.getFirstName(), customer1);
        myConHashMap.put(customer2.getFirstName(), customer2);
        System.out.println("Customer 1 is : " + myConHashMap.get("Dave").getFirstName()
                + " who lives in " + myConHashMap.get("Dave").getAddress());
        myConHashMap.keySet().forEach(key -> {
            System.out.println(key + " lives in " + myHashMap.get(key).getAddress());
        });

        // Hash Table
        System.out.println("\nHashTable...");
        myHashTable.put(customer1.getId(), customer1);
        myHashTable.put(customer2.getId(), customer2);
        System.out.println("Customer 1 is : " + myHashTable.get(1L).getFirstName()
                + " who lives in " + myHashTable.get(1L).getAddress());
        myHashTable.keySet().forEach(key -> {
            System.out.println(myHashTable.get(key).getFirstName() + " lives in " + myHashTable.get(key).getAddress());
        });

        // Tree Map
        System.out.println("\nTreeMap...");
        myTreeMap.put(customer2.getId(), customer2);
        myTreeMap.put(customer1.getId(), customer1);
        System.out.println("Customer 1 is : " + myTreeMap.get(1L).getFirstName()
                + " who lives in " + myTreeMap.get(1L).getAddress());
        myTreeMap.keySet().forEach(key -> {
            System.out.println(myTreeMap.get(key).getFirstName() + " lives in " + myTreeMap.get(key).getAddress());
        });

        // Linked Hash Map
        System.out.println("\nLinkedHashMap...");
        myLinkedHashMap.put(Name.Dave.toString(), customer2);
        myLinkedHashMap.put(Name.Sarah.toString(), customer1);
        System.out.println("Customer 1 is : " + myLinkedHashMap.get("Dave").getFirstName()
                + " who lives in " + myLinkedHashMap.get("Sarah").getAddress());
        myLinkedHashMap.keySet().forEach(key -> {
            System.out.println(myLinkedHashMap.get(key).getFirstName() + " lives in " + myLinkedHashMap.get(key).getAddress());
        });

        // Enum Map
        System.out.println("\nEnumMap...");
        myEnumHasMap.put(Name.Dave, customer2);
        myEnumHasMap.put(Name.Sarah, customer1);
        System.out.println("Customer 1 is : " + myEnumHasMap.get(Enum.valueOf(Name.class, "Dave")).getFirstName()
                + " who lives in " + myEnumHasMap.get(Name.Sarah).getAddress());
        myEnumHasMap.keySet().forEach(key -> {
            System.out.println(myEnumHasMap.get(key).getFirstName() + " lives in " + myEnumHasMap.get(key).getAddress());
        });

        // Weak Hash Map
        System.out.println("\nWeakHashMap...");
        myWeakHashMap.put(1L, customer2);
        myWeakHashMap.put(2L, customer1);
        myWeakHashMap.put(3L, new Customer(3L, "Fraz", "Collier", "Hinckley","1234"));
        myWeakHashMap.put(4L, new Customer(4L, "Jess", "Collier", "Hinckley","1234"));
        System.out.println("Customer 1 is : " + myWeakHashMap.get(1L).getFirstName()
                + " who lives in " + myWeakHashMap.get(2L).getAddress());
        myWeakHashMap.keySet().forEach(key -> {
            System.out.println(myWeakHashMap.get(key).getFirstName() + " lives in " + myWeakHashMap.get(key).getAddress());
        });

        System.out.println(myWeakHashMap.size());
        System.gc();
        Thread.sleep(5000);
        System.out.println(myWeakHashMap.size());

        // create easy immutable Map of upto 10 (max) key, value pairs - no nulls
        Map<Integer, String> myMap = Map.of(1,"Dave",2,"Sarah");
    }
}
