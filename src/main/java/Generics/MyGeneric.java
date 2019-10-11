package Generics;
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
		// Generics
		MyGeneric<String> myString=new MyGeneric<>();
		MyGeneric<Integer> myInteger=new MyGeneric<>();
		
		myString.setT(new String("Hello"));
		myInteger.setT(new Integer(100));
		
//		System.out.println(myString.toString());
//		System.out.println(myInteger.toString());

		// Basic RAW List Type - No Generics
		System.out.println("No Generics...");
		Customer.CustomerService customerService = Customer.service();
		List customers = customerService.getCustomers();

		customers.forEach(System.out::println);

		for(Object cust : customers) {
			System.out.println((cust).toString());
		}

		// Using Generics
		System.out.println("\nUsing Generics...");
		List<Customer> customers1 = customerService.getCustomers1();
		customers.forEach(System.out::println);

	}
}
