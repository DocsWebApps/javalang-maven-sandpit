package JavaQuiz;

import java.util.List;
import java.util.stream.Stream;

public class OfNullableChallenge1 {

    public static void main(String... args) {
        Soprano soprano = null;

        Stream.ofNullable(soprano)
                .filter(s -> s.guns.get(0) == null)
                .forEach(s -> System.out.println(s.guns.size()));
    }

    static class Soprano {
        List<String> guns;

        public Soprano(List<String> guns) {
            this.guns = guns;
        }
    }

}
/*

Summary
You will learn how to manipulate Stream that might be null in a safe way.

Background
Let's analyze the code:

    Stream.ofNullable(soprano)

Note that we are using the ofNullable method from Java 9. With this method, it's possible to avoid
a NullPointerException in case a null object is passed.

Now let's analyse the method implementation from ofNullable:

     public static<T> Stream<T> ofNullable(T t) {
            return t == null ? Stream.empty()
                             : StreamSupport.stream(new Streams.StreamBuilderImpl<>(t), false);
        }

If the object is null a Stream.empty() will be returned, with that a NullPointerException will be avoided as mentioned
before, therefore, the output will be empty. The Stream pipeline won't even continue after that.

But if we were using the method Stream.of() like that for example:

    Stream.of(soprano)
            .filter(s -> s.guns.get(0) == null)
            .forEach(s -> System.out.println(s.guns.size()));

We would have a NullPointerException since the Stream.of method doesn't handle null objects.

If you want to see the detailed explanation in video, go to the Java Challengers channel:
https://www.youtube.com/playlist?list=PL3py5YSIGvPMgKXOVqnYn9nBoT_zvsvsi
 */
