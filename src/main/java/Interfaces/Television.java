package Interfaces;

public class Television extends ElectronicDevice implements Nameable {

    @Override
    public void turnOn() {
        System.out.println("TV is On");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is Off");
    }

    @Override
    public String name() {
        return "TV";
    }
}
