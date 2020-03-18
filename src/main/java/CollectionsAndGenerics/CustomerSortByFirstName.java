package CollectionsAndGenerics;

import java.util.Comparator;

public class CustomerSortByFirstName implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        int result = o1.getFirstName().compareTo(o2.getFirstName());
        if (result > 1) {
            return 1; // order o1,o2
        } else if (result <1) {
            return -1; // order o2,o1
        } else {
            return 0; // order o1,o2 as the same
        }
    }
}
