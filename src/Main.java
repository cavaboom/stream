import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("A", "B", "C", "D", "F");
        Comparator<String> comparator = Comparator.comparing(String::length);
        BiConsumer<String, String> consumer = (x, y) -> System.out.println(x + " " + y);

        findMinMax(stream, comparator, consumer);
        evenNumbers(List.of(45, 88, 102, 33));
    }

    public static <T> void findMinMax(
            Stream <? extends T> stream,
            Comparator <? super T> order,
            BiConsumer <? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());
        if(list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static void evenNumbers(List<Integer> list) {
        Stream<Integer> stream = list.stream();
        Predicate<Integer> predicate = (n) -> (n % 2) == 0;
        Stream<Integer> resStream = stream.filter(predicate);
        System.out.println(resStream.count());
    }
}