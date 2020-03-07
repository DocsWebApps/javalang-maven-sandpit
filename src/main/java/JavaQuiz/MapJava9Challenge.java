package JavaQuiz;

import java.util.Map;

public class MapJava9Challenge {
    public static void main (String... args) {
        // Set.of(), List.of(), Map.of() all return immutable objects`
        Map<String,String> map = Map.of("no","bugs","nos","stress");
        map.put("Do","YourBest");
        System.out.println(map);
    }


}
