package JavaQuiz;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CompletableFutureChallenge {
    static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String... oracleCodeOneAdventure) {
        CompletableFuture<List<String>> adventureStart = new CompletableFuture<>();

        Supplier<List<String>> sanFranSightSupplier = () ->
                List.of("Alcatraz", "Cable Car", "Golden Gate", "Lombard Street");

        adventureStart.completeAsync(sanFranSightSupplier, executor)
                .thenCompose(sights -> {
                    return CompletableFuture.supplyAsync(() -> sights.stream()
                            .map(String::length)
                            .collect(Collectors.toList()));
                })
                .thenAccept(ratings -> {
                    var rating = ratings.stream()
                            .dropWhile(sightRating -> sightRating <= 12)
                            .findFirst()
                            .orElse(0);
                    System.out.print("Rating: " + rating + " ");
                });
        System.out.print("time to go home :( ");
    }

}
/*

Summary
You will learn how to use CompletableFuture asynchronously with two Threads.

Background
Let's analyze the code:

At first, we are populating a Supplier instance with a list.

    Supplier<List<String>> sanFranSightSupplier = () ->
        List.of("Alcatraz", "Cable Car", "Golden Gate", "Lombard Street");

Then the whole process will be made asynchronously.
Basically what will happen in this piece of code is that the stream of String from sanFranSightSupplier will be transformed
into the length of each String.

    adventureStart.completeAsync(sanFranSightSupplier, executor)
        .thenCompose(sights -> {
            return CompletableFuture.supplyAsync(() -> sights.stream()
                    .map(String::length)
                    .collect(Collectors.toList()));
        })

Then all Strings that are lower or equal to 12 will be dropped. In the end, the length of Lombard Street will remain into the list.

.thenAccept(ratings -> {
    var rating = ratings.stream()
            .dropWhile(sightRating -> sightRating <= 12)
            .findFirst()
            .orElse(0);
    System.out.print("Rating: " + rating + " ");
});

Therefore, the output will be: time to go home :( Rating: 14

If you want to see the detailed explanation in video, go to the Java Challengers channel:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi
 */
