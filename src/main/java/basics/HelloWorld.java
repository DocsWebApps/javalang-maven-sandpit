package basics;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

// javac .\src\main\java\basics\HelloWorld.java : Compile
// java -classpath .\src\main\java basics.HelloWorld : Run from Class file
// jar cf .\basics\HelloWorld.jar .\basics\HelloWorld.class : Make Jar
// java -cp .\basics\HelloWorld.jar basics.HelloWorld : Run from Jar
