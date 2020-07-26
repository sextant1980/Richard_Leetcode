package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConversionPrac {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(3, 9, 8, 2);
        long count = a.stream().count();
    }
}
