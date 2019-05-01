package Arrarys;

// Demostrates the use of lists

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayList {
	
	private List<String> myString=new ArrayList<>(3);
	
	public MyArrayList() {
		myString.add("Dave");
		myString.add("Sarah");
		myString.add("Frazer");
		myString.add("Jess");
	}
	
	public void addString(String str) {
		myString.add(str);
	}
	
	public boolean delString(String str) {
		boolean result=false;
		for(String s:myString) {
			if(s.equals(str)) {
				myString.remove(str);
				result=true;
			}
		}
		return result;
	}
	
	public void printContents() {
		myString.forEach(s -> System.out.println(s));
	}
	
	public void findString(String str) {
		boolean result=false;
		for(String s:myString) {
			if(s.equals(str)) {
				System.out.println("I have found "+str+" using a ForEach loop");
			}
		}
	}

	public void findString1(String str) {
	    myString.stream()
                .filter(s->s.equals(str))
                .forEach(s->System.out.println("I have found "+s.toString()+" using a Stream/Lambda solution"));
    }
	
	public void myInterator() {
		Iterator<String> elements=myString.iterator();
		while(elements.hasNext()) {
			System.out.println(elements.toString());
		}
	}
	
	public static void main(String[] args) {
		// ArrayList
		MyArrayList myArray=new MyArrayList();
		String myStr1="Bob";
		String myStr2="Bob";
		myArray.addString(myStr1);
		myArray.printContents();
		myArray.findString("Dave");
		myArray.findString1("Dave");

	}

}
