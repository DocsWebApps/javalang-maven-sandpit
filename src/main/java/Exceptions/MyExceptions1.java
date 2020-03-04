package Exceptions;
// All Exceptions are derived from two classes
// 1. Error Class: Server/JVM errors ie. Out of Memory error
// 2. Exception Class:
    // Checked Exceptions: Exceptions that can be handled - try-catch-handle ie. DB or file not available !
    // UnChecked Exceptions: Caused by problems/errors in the code - fix the problem/error ie.division by 0 !

// Try to catch the most specific exception - don't just use Exception all the time - use multiple catches for different Exceptions

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyExceptions1 {
    public static void main(String[] args) throws IOException {
        String soprano = null;

        CloseIt closeIt = new CloseIt();
        // If you don't catch the exception in your code, adding "throws Exception" will
        // throw the exception back to the caller.
        // try-catch-finally
        InputStream in = null;
        try {
            System.out.println("About to open a non-existent file");
            in = new FileInputStream("missing-file.txt");
            System.out.println("File is open!");
            int data = in.read();
        } catch(IOException e) {
            System.out.println("Houston1...we have a problem! " + e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
                System.out.println("File input stream closed!");
            } catch (IOException e) {
                System.out.println("Failed to close file input stream!");
            }
        }

        // try-with-resources-catch - no need for finally as the defined resources will have the
        // autoclose method called on them as they implement the autocloseable Interface
        // JDK 9+ Syntax
        // FileInputStream in2 = new FileInputStream("missing-file.txt");
        // try (in2)
        // JDK 7/8 Syntax
        try (FileInputStream in1 = new FileInputStream("missing-file.txt"))
        {
            System.out.println("About to read file");
            int data = in1.read();
        } catch(IOException e) {
            System.out.println("\nHouston2... we have a problem, but in1 should autoclose (JDK7/8)! " + e.getMessage());
        }

        MyExceptions1 myExceptions1 = new MyExceptions1();

        System.out.println("\nThrow DavesException");
        myExceptions1.throwDavesException();

        try {
            myExceptions1.testThrowException();
        } catch(IOException e) {
            System.out.println("\nCaught IOException from called object.method()");
        }

        try(closeIt) {
            System.out.println(soprano.matches(null));
        } catch (RuntimeException r) {
            try (closeIt) {
                System.out.println("runtime");
                throw new DrDavesException();
//                throw new StackOverflowError();
            } catch (Exception e) {
                System.out.println("exception");
            }
        } catch (Error exception) {
            System.out.println("error");
        } catch (Throwable throwable) {
            System.out.println("throwable");
        }

        System.out.println("\nNot caught IOException from called object.method(), output below!");
        myExceptions1.testThrowException();
    }

    public void testThrowException() throws IOException {
        // In this example the exception is not handled but thrown back to the caller
        try(FileInputStream in = new FileInputStream("missing-file.txt")) {
            System.out.println("Would execute if the file was opened OK");
        }
    }

    public void throwDavesException() {
        int i = 10;
        try {
            System.out.println("Do something!");
            if(i < 20) {
                throw new DavesException("Oh shit!");
            }
        } catch(DavesException e) {
            System.out.println("DavesException Thrown! " + e.getMessage());
        }
    }

    static class CloseIt implements Closeable {

        public void close() {
            System.out.println("close");
        }
    }
}

class DavesException extends Exception {
    DavesException() {}
    DavesException(String message) {super(message);}
    DavesException(String message, Throwable cause) {
        super(message, cause);
    }
}

class DrDavesException extends Exception {
    DrDavesException() {}
    DrDavesException(String message) {super(message);}
    DrDavesException(String message, Throwable cause) {super(message, cause);}
}
