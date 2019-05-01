package OOReview;

public class EmployeeTest {
    // Main method
    public static void main(String[] args) {

        // Static fields / methods
        System.out.println("\nExample of s static field and a static method");
        System.out.println(Employee.whoAmI());
        System.out.println(Manager.whoAmI());

        //Module 3 & 4: Encapsulation and Polymorphism
        System.out.println("\nExample of Encapsulation and Inheritance");
        Employee e1=new Employee(1, "Collier","Dave",25000);
        Employee e2=new Employee(1, "Collier","Dave",25001);
        System.out.println(e1.toString());

        if(e1.equals(e2)) {
            System.out.println("e1 does equal e2");
        } else {
            System.out.println("e1 does not equal e2");
        }

        Manager m1=new Manager(2,"Sarah","Collier",30000, "Family");
        Manager m2=new Manager(2,"Sarah","Collier",30000, "Family1");

        System.out.println(m1.toString());

        if(m1.equals(m2)) {
            System.out.println("m1 does equal m2");
        } else {
            System.out.println("m1 does not equal m2");
        }

        // Virtual method invocation
        System.out.println("\nExample of Virtual Method Invocation");
        Employee e3=new Manager(3,"Frazer","Collier",30000, "Family1");
        System.out.println(e3.toString());

        // Static modifier
        System.out.println("\nExample of Static Modifiers");
        for(int num : Employee.getNum()) {
            System.out.println(num);
        }

        // Final method
        System.out.println("\nExample of Final Method");
        e1.printMessage();
        m1.printMessage();

        // Polymorphism
        System.out.println("\nExample of Polymorphism");
        System.out.println(e1.polymorphismExample());
        System.out.println(e3.polymorphismExample());
    }
}
