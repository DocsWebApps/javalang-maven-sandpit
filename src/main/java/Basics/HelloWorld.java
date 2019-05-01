package Basics;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

// javac .\src\main\java\Basics\HelloWorld.java : Compile
// java -classpath .\src\main\java Basics.HelloWorld : Run from Class file
// cd src\main\java && jar cf .\Basics\HelloWorld.jar .\Basics\HelloWorld.class : Make Jar
// cd src\main\java && java -cp .\Basics\HelloWorld.jar Basics.HelloWorld : Run from Jar
