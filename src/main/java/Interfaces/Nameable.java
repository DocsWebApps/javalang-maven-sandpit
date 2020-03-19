package Interfaces;

public interface Nameable {
    static final String INTERFACE_NAME="NAMEABLE";

    String name();

    static String aStaticMethod() {
        return "An interface can have static methods";
    }

    default String aDefaultMethod() {
        return "I'm a default instance method in the Interface Nameable";
    }
}
