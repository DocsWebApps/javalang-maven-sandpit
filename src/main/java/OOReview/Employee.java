package OOReview;
// Demonstrates the use of encapsulation, polymorphism and Inheritance and also the use of static modifiers, final methods, final variables and static variables
// Final classes may not be extended
// Final methods can not be overridden
// Final variables can not be changed once set
// Static modifier - executes when the class loads
// Static method - can be called from the Class without and instance
// Static variable - gets assigned when the class loads
// New Manager class inherits from Employee - Java has single class inheritance

// public class Employee extends Object by default
// Object has some methods all objects inherit: toString(), equals() and hasCode()
// You should try and override these methods in your classes !!!!
public class Employee {

    // Static member variable / object initialisation
    private static int[] num=new int[10];

    // Static modifier - executes when the class loads
    static {
        for(int i=0; i<10;i++) {
            num[i]=i;
        }
    }

    // Static getter for num[]
    public static int[] getNum() {
        return num;
    }

    // Member variables
    private String firstName;
    private String lastName;
    private double salary;

    // Final variable - once set cannot be changed
    private final int id;

    // Static variable - gets assigned when the class loads
    private static  String WHOAMI="Employee Class";

    // Static method - can be called from the Class without and instance
    public static String whoAmI() {
        return "I am an static method defined in the " + WHOAMI;
    }

    public String polymorphismExample() {
        return "I am the polymorphismExample() method from an object of type Employee";
    }

    // Constructor
    public Employee(int id, String firstName, String lastName,double salary) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.salary=salary;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double increase) {
        this.salary+=increase;
    }

    // Public methods
    public final void printMessage() { // Final method - cannot be overridden in the subclass
        System.out.println("This is a final method");
    }

    // Override equals() method - defined in Object
    @Override
    public boolean equals(Object o) {
        boolean result=false;
        if ( o instanceof Employee) {
            Employee emp=(Employee) o;
            if(this.getId()==emp.getId() && this.getFirstName()==emp.getFirstName() && this.getLastName()==emp.getLastName()
                    && this.getSalary()==emp.getSalary()) {
                result=true;
            }
        }
        return result;
    }

    // Override toString() method - defined in Object
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("Employee details: ");
        sb.append(this.id+", ");
        sb.append(this.firstName+", ");
        sb.append(this.lastName+", ");
        sb.append(this.salary);
        return sb.toString();
    }
}


// New Manager class inherits from Employee - Java has single class inheritance
class Manager extends Employee{

    // Member variable
    private String department;

    // Constructor
    public Manager(int id, String firstName, String lastName, double salary, String department) {
        super(id, firstName, lastName, salary); // Call the superclass constructor
        this.department=department;
    }

    // Getter
    public String getDepartment() {
        return this.department;
    }

    // Setter
    public void setDepartment(String department) {
        this.department=department;
    }

    @Override
    public String polymorphismExample() {
        return "I am the polymorphismExample() method from an object of type Manager";
    }

    // Override toString() from Object
    @Override
    public boolean equals(Object o) {
        boolean result=false;
        if ( o instanceof Manager) {
            Manager emp=(Manager) o;
            if(this.getId()==emp.getId() && this.getFirstName().equals(emp.getFirstName()) && this.getLastName().equals(emp.getLastName())
                    && this.getSalary()==emp.getSalary() && this.getDepartment().equals(emp.getDepartment())) {
                result=true;
            }
        }
        return result;
    }

    // Override equals() from Object
    @Override
    public String toString() {
        return super.toString()+", "+this.department;
    }
}

