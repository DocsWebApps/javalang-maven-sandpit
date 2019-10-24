package JavaQuiz;

// T1 is printed first since i=addOne() is executed after the first iteration of the loop, T2 is then printed and i++ returned to end the loop
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
