package Basics;

public class HelloWorld {
    public static void main(String[] args) {
        // can use var for local variables as the type is inferred from the new statement in Java 10+
        var message = new String("Hello World!!");
        System.out.println(message);
    }
}

// javac .\src\main\java\Basics\HelloWorld.java : Compile
// java -classpath .\src\main\java Basics.HelloWorld : Run from Class file
// cd src\main\java && jar cf .\Basics\HelloWorld.jar .\Basics\HelloWorld.class : Make Jar
// cd src\main\java && java -cp .\Basics\HelloWorld.jar Basics.HelloWorld : Run from Jar
