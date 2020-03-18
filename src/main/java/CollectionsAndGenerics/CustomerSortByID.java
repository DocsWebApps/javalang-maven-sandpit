package CollectionsAndGenerics;

import java.util.Comparator;

public class CustomerSortByID implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        int result  = o1.getId().compareTo(o2.getId());
        if (result > 1) {
            return 1;
        } else if (result < 1) {
            return -1;
        } else {
            return 0;
        }
    }
}
