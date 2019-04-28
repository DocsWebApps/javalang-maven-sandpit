package java8;

// Demonstrates the use of encapsulation and Inheritence and also the use of static modifiers, final variables and static variables

public class Employee {
	
	private static int[] num=new int[10];
	
	// Static modifier - executes when the class loads
	static {
		for(int i=0; i<10;i++) {
			num[i]=i;
		}
	}
		
	public static int[] getNum() {
		return num;
	}
	
	private String firstName;
	private String lastName;
	private double salary;
	
	// Final variable - once set cannot be changed
	private final int id;
	
	// Static variable - gets assigned when the class loads
	private static  String WHOAMI="Employee Class";
	
	// Static method - can be called from the Class without and instance
	public static String whoAmI() {
		return WHOAMI;
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
	
	// Main method
	public static void main(String[] args) {
			
			// Static fields / methods
			System.out.println(Employee.whoAmI());
			System.out.println(Manager.whoAmI());
			
			//Module 3 & 4: Encapsulation and Polymorphism
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
			Employee e3=new Manager(3,"Frazer","Collier",30000, "Family1");
			System.out.println(e3.toString());
			
			// Static modifier
			for(int num : Employee.getNum()) {
				System.out.println(num);
			}
	}
	
}


// New Manager class inherits from Employee
class Manager extends Employee{
	
	// Property
	private String department;
	
	// Getter
	public String getDepartment() {
		return this.department;
	}
	
	// Setter
	public void setDepartment(String department) {
		this.department=department;
	}
	
	// Override toString() from Object
	@Override
	public boolean equals(Object o) {
		boolean result=false;
		if ( o instanceof Manager) {
			Manager emp=(Manager) o;
			if(this.getId()==emp.getId() && this.getFirstName()==emp.getFirstName() && this.getLastName()==emp.getLastName() 
					&& this.getSalary()==emp.getSalary() && this.getDepartment()==emp.getDepartment()) {
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
	
	// Constructor
	public Manager(int id, String firstName, String lastName, double salary, String department) {
		super(id, firstName, lastName, salary);
		this.department=department;
	}

}
