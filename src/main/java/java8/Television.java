package java8;

// Demonstrates the use of Abstract Classes

public class Television extends AbstractElectronicDevice{

	public Television(String name) {
		super.setDeviceName(name);
		System.out.println("You have intiailised a "+this.toString());
	}

	@Override
	public String getField() {
		return "Hello";
	}
	
	public static void main(String[] args) {
		// Abstract Classes
		AbstractElectronicDevice tv=new Television("Television");
		System.out.println(tv.getField());
		System.out.println(tv.getDeviceName());
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
