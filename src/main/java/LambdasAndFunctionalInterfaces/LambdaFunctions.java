package LambdasAndFunctionalInterfaces;
// Demonstrates the use of Lambda functions
public class LambdaFunctions {
	
	public static void main(String[] args) {
		// Implementation of a function defined by a functional interface and wrapped in an anonymous class
		SimpleFunction innerClassGreeting = new SimpleFunction() {
			public void anyFunction() {
				System.out.println("Hello World from Greeting");
			}};

		// Implementation of a function defined by a functional interface and a lambda expression
		SimpleFunction greetingFunction = () -> System.out.println("Hello World from Lambda");
		AddTwoNumbers add2numbers1 = (int a, int b) -> a + b;
		AddTwoNumbers add2numbers2 = Integer::sum;
		AddTwoNumbers add2numbers3 = (a, b) -> a + b; // Infer type from method definition

		SimpleFunction moreComplexExample = () -> {
			int result = 10*40;
			String output = "The product of my numbers is as follows: " + result;
			System.out.println(output);
		};

		ReturnString myTest1 = () -> "Duke";
		ReturnString myTest2 = () ->  { return "Duke";};

		// Display output
		innerClassGreeting.anyFunction();
		greetingFunction.anyFunction();
		moreComplexExample.anyFunction();
		myTest1.test();
		myTest2.test();
		System.out.println(add2numbers1.add(3, 4));
		System.out.println(add2numbers2.add(3, 4));
		System.out.println(add2numbers3.add(3, 4));
	}
}

// functional interfaces
interface SimpleFunction {
	void anyFunction();
}

interface AddTwoNumbers{
	int add(int a, int b);
}

interface ReturnString {
	String test();
}
