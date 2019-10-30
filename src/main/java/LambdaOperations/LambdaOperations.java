package LambdaOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaOperations {
    public static void main(String... args) {
        List<Book> books = new ArrayList<>();
        books.add(BookImpl.builder().title("On the trail of the Assassins").author("Jim Garrison").published(1988).build());
        books.add(BookImpl.builder().title("JFK: Not in your Lifetime").author("Tony Summers").published(1981).build());
        books.add(BookImpl.builder().title("The Last Investigation").author("Gaeton Fonzi").published(1980).build());
        books.add(BookImpl.builder().title("Best Evidence").author("David Lifton").published(1978).build());
        books.add(BookImpl.builder().title("JFK: Assasination Handbook").author("JMike Davis").published(2018).build());

        // Book operations
        books.stream().filter(b->b.getPublished()>1985).forEach(b-> System.out.println(b.bookInfo()));
        System.out.println(books.stream().filter(b->b.getPublished()>1980).mapToInt(b->b.getPublished()).min());
        System.out.println(books.stream().filter(b->b.getPublished()>1980).mapToInt(b->b.getPublished()).max());
        OptionalInt maxYear = books.stream().filter(b->b.getPublished()>1980).mapToInt(b->b.getPublished()).max();
        if (maxYear.isPresent()) {
            System.out.println(maxYear.getAsInt());
        }

        List<String> alpha = Arrays.asList("a","b","c","d");

        // Use a traditional for loop to create a new List of upper case letters
        List<String> alphaUpper = new ArrayList<>();
        for(String s: alpha) {
            alphaUpper.add(s.toUpperCase());
        }
        alphaUpper.forEach(System.out::println);

        // Using collect to create a new List of upper case letters
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);

        List<Integer> singleList = Arrays.asList(1,2,3,4,5,6,7,8,9);

        // Create list o ints * 2
        List<Integer> times2List = singleList.stream().map(i->i*2).collect(Collectors.toList());
        System.out.println(times2List);
        times2List.forEach(System.out::println);

        List<String> bookTitles = books.stream().map(b->b.getTitle()).collect(Collectors.toList());
        bookTitles.forEach(System.out::println);
        // Also
        List<String> bookTitles1 = books.stream().map(Book::getTitle).peek(t-> System.out.println("Peeking Title: " + t)).collect(Collectors.toList());
        bookTitles1.forEach(System.out::println);
        // Bad use of peek()
        // Use peek() to peek inside a running stream but beware that you can change the underlying items in a collection if you call a method on that object
        // that changes its state using peek().
        books.stream().peek(t->t.changeMe()).forEach(b->System.out.println(b.getTitle()));

        // FindFirst - stops processing after finding 16
        Optional over15 = times2List.stream().filter(i->i>15).findFirst();
        if(over15.isPresent()) {
            System.out.println(over15.get());
        }

        Stream.of("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday").filter(d->d.startsWith("S")).forEach(System.out::println);

        Path file = new File("C:\\MyCode\\Java\\javalang-maven-sandpit\\src\\main\\java\\LambdaOperations\\tempest.txt").toPath();
        try {
           Long count = Files.lines(file).flatMap(line->Stream.of(line.split(" "))).count();
           System.out.println("Number of words in tempest file: " + count);
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // View your stream datq output 1st using forEach(System.out::println) then build your filters and maps etc.
            // Use peek() also to help debug your streams
            Files.lines(file).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
