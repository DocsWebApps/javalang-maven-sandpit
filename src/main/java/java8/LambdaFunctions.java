package java8;

// Demonstrates the use of Lambda functions

public class LambdaFunctions {
	
	public static void main(String[] args) {
		
		// Interface implementation as an inner class
		SimpleFunction innerClassGreeting=new SimpleFunction() {
			public void anyFunction() {
				System.out.println("Hello World from Greeting");
			}};
		
		// Lambda functions using functional interfaces
		SimpleFunction greetingFunction=() -> System.out.println("Hello World from Lambda");
		AddTwoNumbers add2numbers=(int a, int b) -> a + b;
		
		// Display output
		innerClassGreeting.anyFunction();
		greetingFunction.anyFunction();
		System.out.println(add2numbers.add(3, 4));
	}

}

// Local Functional interfaces - can be defined in the same file. If public, define in their own files.
interface SimpleFunction {
	void anyFunction();
}

interface AddTwoNumbers{
	int add(int a, int b);
}
