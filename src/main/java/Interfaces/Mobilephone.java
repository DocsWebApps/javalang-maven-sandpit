package Interfaces;

public class Mobilephone extends ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("Phone On");
    }

    @Override
    public void turnOff() {
        System.out.println("Phone Off");
    }
}
