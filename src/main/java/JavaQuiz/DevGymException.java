package JavaQuiz;

public class DevGymException {

    private static IllegalArgumentException illegalArgument;

    public static void main(String... doYourBest) {

        try {
            double exceptionNumber = 2 / 0.0;
            System.out.println(exceptionNumber);
            System.out.println("exceptionNumber");

//            illegalArgument = new IllegalArgumentException();
            throw illegalArgument; // Null pointer/reference, hasn't been instantiated, see above
        } catch (NullPointerException nullPointer) {
            System.out.println("NullPointer");
        } catch (IllegalArgumentException illegalArgument) {
            System.out.println("IllegalArgument");
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            System.out.println("Finally");
        }
    }

}
