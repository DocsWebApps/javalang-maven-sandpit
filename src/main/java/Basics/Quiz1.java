package Basics;

public class Quiz1 {
    public static void main(String[] args) {
        for(int i=0; i<1; i=addOne(i)) {
            System.out.println("T1");
        }
    }

    private static int addOne(int i) {
        System.out.println("T2");
        return ++i;
    }
}
