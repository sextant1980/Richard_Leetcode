package Java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExp {
    public static void main(String[] args) {
        String[][] strA = {{"sed", "goe"}, {"biu"}, {"jiao", "di", "zou"}};
//        String[] strAFlat = Arrays.stream(strA).flatMap(Stream::of).toArray(String[]::new);
//        String[] strAFlat = Arrays.stream(strA).flatMap(x -> Stream.of(x)).toArray(String[]::new);
//        String[] strAFlat = Arrays.stream(strA).flatMap(Arrays::stream).toArray(String[]::new);
        String[] strAFlat = Arrays.stream(strA).flatMap(x -> Arrays.stream(x)).toArray(String[]::new);
        System.out.println(Arrays.toString(strAFlat));

        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("sed", "goe"));
        list.add(Arrays.asList("biu"));
        list.add(Arrays.asList("jiao", "di", "zou"));
        System.out.println(list);
//        List<String> listFlat = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
        List<String> listFlat = list.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(listFlat);
    }
}
