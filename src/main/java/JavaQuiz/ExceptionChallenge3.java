package JavaQuiz;
import java.io.FileNotFoundException;

public class ExceptionChallenge3 {
    static String s = "-";

    public static void main(String... doYouBest) {
        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            try {
                try {
                    throw new FileNotFoundException();
                } catch (RuntimeException ex) {
                    s += "run";
                }
                throw new NullPointerException();
            } catch (Exception x) {
                s += "exc";
            } finally {
                s += "fin";
            }
        } finally {
            s += "of";
            try {
                throw new VirtualMachineError("JVMError") {};
            } catch (Error error) {
                s += "error" + error.getMessage();
            }
        }

        System.out.println(s);
    }

}
/*

Summary
Working properly with exceptions is crucial to a high-quality application that users enjoy using.
This quiz reinforces some of the basic concepts of exceptions.

Background
Working properly with exceptions is crucial to a high-quality application that users enjoy using. There are 3 main categories of exceptions:

1. Checked Exceptions: used to handle a business requirement or something that is expected and the system can recover from the error.

2. Unchecked Exceptions: used to handle non-functional errors and errors that can be avoided with an if such as
ArrayOutOfBoundsException, NullPointerException.. All of these exceptions inherit from RuntimeException.

3. Error: Very serious errors that can't be manipulated, they errors such as VirtualMachineError.

In order to answer this challenge, it's necessary to have some knowledge about inheritance too.

Watch the FULL explanation video about several Java quizzes on the Java Challengers channel:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi
 */