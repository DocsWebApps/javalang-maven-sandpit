package CollectionsAndGenerics;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private Long Id;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNo;

    public Customer() {}

    public Customer(Long Id, String firstName, String lastName, String address, String mobileNo) {
        this.setId(Id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setMobileNo(mobileNo);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId()) &&
                Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getAddress(), customer.getAddress()) &&
                Objects.equals(getMobileNo(), customer.getMobileNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getMobileNo());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    static class CustomerBuilder {
        private Long Id;
        private String firstName;
        private String lastName;
        private String address;
        private String mobileNo;

        CustomerBuilder() {
        }

        public CustomerBuilder id(Long Id) {
            this.Id = Id;
            return this;
        }

        public CustomerBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerBuilder address(String address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder mobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
            return this;
        }

        public Customer build() {
            return new Customer(Id, firstName, lastName, address, mobileNo);
        }

        public String toString() {
            return "Customer.CustomerBuilder(Id=" + this.Id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", address=" + this.address + ", mobileNo=" +this.mobileNo + ")";
        }
    }

    static CustomerService service() {
        return new CustomerService();
    }

    public static class CustomerService {
        private static List customers = new ArrayList<>();

        public CustomerService() {
            loadCustomers();
        }

        public static List getCustomers() {
            return customers;
        }

        public static List<Customer> getCustomers1() {
            return customers;
        }

        private static void loadCustomers() {
            customers.add(Customer.builder().id(1L).firstName("Dave").lastName("Collier").address("19 Hurst Road").mobileNo("1234"));
            customers.add(Customer.builder().id(1L).firstName("Sarah").lastName("Collier").address("19 Hurst Road").mobileNo("1234"));
            customers.add(Customer.builder().id(1L).firstName("Frazer").lastName("Collier").address("19 Hurst Road").mobileNo("1234"));
            customers.add(Customer.builder().id(1L).firstName("Jessica").lastName("Collier").address("19 Hurst Road").mobileNo("1234"));
        }
    }
}
