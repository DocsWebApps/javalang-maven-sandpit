package CollectionsAndGenerics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RawTypes {
    public static void main(String[] args) {
        // DON'T USE RAW TYPES.... USE GENERICS !!

        List rawList = new ArrayList<>();
        rawList.add(10); // Java autobox's this to Integer type
        rawList.add(new String("Dave"));
        rawList.add(new String("Sarah"));

        Iterator elements = rawList.iterator();
        // Works OK since toString() method is common to Integer and String types
        System.out.println("toString() works...");;
        while(elements.hasNext()) {
            System.out.println(elements.next().toString());
        }

        elements = rawList.iterator();
        System.out.println("\nintValue() does not since we have to cast each element to Integer to invoke intValue()");
        while(elements.hasNext()) {
            System.out.println(((Integer) elements.next()).intValue()); // ClassCast exception
        }
    }
}
