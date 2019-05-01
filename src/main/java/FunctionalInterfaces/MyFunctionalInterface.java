package FunctionalInterfaces;

// Demonstrates the use of Functional Interfaces

public class MyFunctionalInterface {

	public static void main(String[] args) {
		// Using a defined external Functional Interface implementation
		FunctionalInterface fi=new FunctionalInterface() {
			@Override
			public void doWork() {
				System.out.println("Implement DoWork() using a defined class that implements the FunctionaI Interface");
			}
		};
		carryOutWork(fi);
		//End
		
		// Using an anonymous inner class to implement a Functional Interface
		carryOutWork(new FunctionalInterface() {
			@Override
			public void doWork() {
				System.out.println("Implement DoWork() using an anonymous inner class  that implements the FunctionaI Interface");
			}}); 
		//End
		
		// Using a lambda to implement a Functional Interface
		carryOutWork(() -> System.out.println("Implement DoWork() using a lambda that implements the FunctionaI Interface"));
		//End
	}
	
	public static void carryOutWork(FunctionalInterface  fi) {
		fi.doWork();
	}
	
}

// This interface can also be defined in a seperate file as public
interface FunctionalInterface {
	  public void doWork();
	}
