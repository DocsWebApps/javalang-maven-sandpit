package JavaQuiz;

import java.io.Closeable;

public class ExceptionChallenge2 {
    public static void main(String... doYourBest) {
        String soprano = null;

        CloseIt closeIt = new CloseIt();

        try(closeIt) {
            System.out.println(soprano.matches(null));
        } catch (RuntimeException r) {
            try (closeIt) {
                System.out.println("runtime");
                throw new StackOverflowError();
            } catch (Exception e) {
                System.out.println("exception");
            }
        } catch (Error exception) {
            System.out.println("error");
        } catch (Throwable throwable) {
            System.out.println("throwable");
        }
    }

    static class CloseIt implements Closeable {

        public void close() {
            System.out.println("close");
        }
    }
}
/*

Summary
How to use Exceptions and try with resources.

Background
As we are trying to use a method from a null String, a NullPointerException will be thrown here:

    System.out.println(soprano.matches(null));

When the first try block finishes its execution, the close method will be invoked printing:

    close

Then the second try block will be executed printing:

    runtime

In the next statement, we throw StackOverflowError().

Finally, the second try block will invoke the close method printing:
    close
 */
