import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Map<String, Long> hashMap = new HashMap<>();

        for (String word : args) {

            hashMap = Arrays.stream(word.split(""))
                    .map(String::toLowerCase)
                    .filter(letter -> !letter.equals(" "))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        }

        // convert hashmap into treemap to preserve order
        Map<String, Long> treemap = new TreeMap<>(hashMap);


        printMap(treemap);


    }

    public static <K, V> void printMap(Map<K, V> map) {
        System.out.println("Counted letters:");
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
