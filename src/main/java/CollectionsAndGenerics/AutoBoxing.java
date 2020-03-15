package CollectionsAndGenerics;

public class AutoBoxing {
    public static void main(String[] args) {
        Integer myInt = 10;
        System.out.println(myInt);
        System.out.println(Integer.parseInt("100"));

        int unboxed = myInt;
        System.out.println(unboxed);
    }
}
