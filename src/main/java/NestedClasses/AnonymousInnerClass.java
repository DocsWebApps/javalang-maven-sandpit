package NestedClasses;

// Example of anonymous inner, inner and static inner classes - TBC!!
public class AnonymousInnerClass {
	  public static void main(String[] args) {
	    new Thread(new Runnable() {
	      @Override
	      public void run() {
	        System.out.println("A thread created and running as an anonymous inner class...");
	      }
	    }).start();
	  }
}
