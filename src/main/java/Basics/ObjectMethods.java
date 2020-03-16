package Basics;

public class ObjectMethods {
    private String name;
    private int age;

    ObjectMethods(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ObjectMethods)) return false;
        final ObjectMethods other = (ObjectMethods) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.name;
        final Object other$name = other.name;
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.age != other.age) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ObjectMethods;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.name;
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + this.age;
        return result;
    }

    public String toString() {
        return "ObjectMethods(name=" + this.name + ", age=" + this.age + ")";
    }

    public static void main(String[] args) {
        ObjectMethods objectMethods1 = new ObjectMethods("Dave", 53);
        ObjectMethods objectMethods2 = new ObjectMethods("David", 53);
        ObjectMethods objectMethods3 = new ObjectMethods("Dave", 53);
        ObjectMethods objectMethods4 = objectMethods2;

        System.out.println(objectMethods1.toString());
        System.out.println(objectMethods1.hashCode());
        System.out.println(objectMethods1.equals(objectMethods2)); // false
        System.out.println(objectMethods1.equals(objectMethods3)); // true
        System.out.println(objectMethods2.equals(objectMethods4)); // true
    }
}
