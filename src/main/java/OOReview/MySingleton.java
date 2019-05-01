package OOReview;

public class MySingleton {
	
	// 3 things to make a singleton
	//	1. Private constructor to restrict instantiation of the class from other classes.
	//	2. Private static variable of the same class that is the only instance of the class.
	//	3. Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class.
	private MySingleton() {} // 1. Private constructor - can't be instantiated by anything else
	
	private static final MySingleton reference=new MySingleton(); // 2. Static final reference, gets set when the class loads and can't be changed
	
	public static MySingleton getReference() { // Accessor method to return the reference to the Singleton
		return reference;
	} // 3. Static getter to return reference to singleton
	// End
	
	public String hello() {
		return "I'm a Singleton Dummy !!";
	}
	
	public static void main(String[] args) {
		// Singletons
		MySingleton mySingle=MySingleton.getReference();
		System.out.println(mySingle.hello());
	}

}
