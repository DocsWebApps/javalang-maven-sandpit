package CollectionsAndGenerics;
import java.util.List;

public class MyGeneric <T> {
	
	private T t;
	
	MyGeneric(){}
	
	public void setT(T t) {
		this.t=t;
	}
	
	public T getT() {
		return this.t;
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
	
	public static void main(String[] args) {
		// 1. Basic RAW List Type - No Generics
		System.out.println("No Generics...");
		Customer.CustomerService customerService = Customer.service();
		List customers = customerService.getCustomers();
//		Customer c = (Customer) customers.get(1); // Have to cast as List has no type information

		customers.forEach(System.out::println);
		// OR
		for(Object cust : customers) {
			System.out.println((cust).toString());
		}

		// 2. Same as above but using generics
		System.out.println("\nUsing Generics...");
		List<Customer> customers1 = customerService.getCustomers1();
		customers.forEach(System.out::println);

		// ---------------------------------------------

		// 3. Using MyGeneric
		MyGeneric<String> myString=new MyGeneric<>();
		MyGeneric<Integer> myInteger=new MyGeneric<>();
		
		myString.setT(new String("Hello"));
		myInteger.setT(new Integer(100)); // Intellij is complaining since autoboxing now applies
		// and the constructor is deprecated
		myInteger.setT(100);
		
		System.out.println(myString.getT());
		System.out.println(myInteger.getT().toString());

	}
}
