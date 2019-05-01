package OOReview;

// Demonstrates the use of Abstract Classes

public class Television extends AbstractElectronicDevice{

	public Television(String name) {
		super.setDeviceName(name);
		System.out.println("You have intiailised a "+this.toString());
	}

	@Override
	public String getField() {
		return "Hello, I'm a concrete implementation of an abstract method defined in an abstract class";
	}
	
	public static void main(String[] args) {
		// Abstract Classes
		AbstractElectronicDevice tv=new Television("Television");
		System.out.println(tv.getField());
		System.out.println(tv.getDeviceName());

		AbstractElectronicDevice radio=new Television("Radio");
		System.out.println(radio.getField());
		System.out.println(radio.getDeviceName());
	}
	
}

// Abstract class
abstract class AbstractElectronicDevice {
	private String deviceName;
	
	//Abstract methods - getfield
	public abstract String getField();

	// Concrete methods - get and set device name
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	@Override
	public String toString() {
		return this.deviceName;
	}
}
