package JavaQuiz;

import java.util.List;
import java.util.function.Predicate;

public class NeoSearch {
    public static void main(String[] args) {
        List<String> ls = List.of("Neo","Morpheus","Oracle","Trinity","Neo");

        Predicate<String> neoSearch = str -> {
            System.out.println("Agent Smith is looking for Neo...");
            return str.contains("Neo");
        };
//        ls.forEach(neoSearch::test);

        var binaryNumbers  = List.of(1,0,1,1).stream();
        Integer binarySum = binaryNumbers.reduce(Integer::sum).orElseThrow(StackOverflowError::new);
//        System.out.println(binarySum);

//        ls.stream().filter(str-> str.length() >= 3).forEach(System.out::println);
        boolean neoFound = ls.stream().filter(str-> str.length() >= binarySum).allMatch(neoSearch);
        System.out.println(neoFound);
        // This one filters through the list looking for strings of greater or equal length than 3. Since they are all greater than or equal than three
        // none are filtered out. However, the allMatch() terminal operation quits after 2 times since when it gets to Morpheus it can determine
        // that the strings are not ALL "Neo" and therefore its false with 2 prints of "Agent Smith is looking for Neo..." !
    }
}
