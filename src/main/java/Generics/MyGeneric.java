package Generics;

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
		MyGeneric <Integer> myInteger=new MyGeneric<>();
		
		myString.setT(new String("Hello"));
		myInteger.setT(new Integer(100));
		
		System.out.println(myString.toString());
		System.out.println(myInteger.toString());
	}
}
