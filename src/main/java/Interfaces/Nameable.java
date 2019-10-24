package Interfaces;

public interface Nameable {
    static final String INTERFACE_NAME="NAMEABLE";

    String name();

    default String aDefaultMethod() {
        return "I'm a default method in the Interface Nameable";
    }
}
