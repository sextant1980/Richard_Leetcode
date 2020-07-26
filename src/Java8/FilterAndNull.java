package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndNull {
    public static void main(String[] args) {
        List<Integer> aa = new ArrayList<>(Arrays.asList(3, 8, 9, 2));

        List<Integer> aaF = aa.stream().filter(x -> x > 10).collect(Collectors.toList());
        System.out.println(aaF.isEmpty());

        long count = aa.stream().filter(x -> x > 6).count();
        System.out.println(count);
    }
}
