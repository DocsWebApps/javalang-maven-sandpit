package java8;

public class MySingleton {
	
	// 3 things to define a singleton
	private MySingleton() {} // private constructor - can't be instantiated by anything else
	
	private static final MySingleton reference=new MySingleton(); //static final reference, gets set when the class loads and can't be changed
	
	public static MySingleton getReference() { // Accessor method to return the reference to the Singleton
		return reference;
	}
	// End
	
	public String hello() {
		return "I'm a  Singleton";
	}
	
	public static void main(String[] args) {
		// Singletons
		MySingleton mySingle=MySingleton.getReference();
		System.out.println(mySingle.hello());
	}

}
