package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamElementSumAverageCount {
    public static void main(String[] args) {
        // problem 1: count negative elements in an array
        int[] aa = new int[]{-8, 6, -9, 7};
        System.out.println(IntStream.of(aa).filter(x -> x < 0).count());

        // problem 2: summing positive number in a list
        List<Integer> bb = Arrays.asList(8, -6, -9, 7);
        System.out.println(bb.stream().mapToInt(x -> x).filter(x -> x > 0).sum());

        // problem 3: averaging negative number in a list
        System.out.println(bb.stream().mapToInt(x -> x.intValue()).filter(x -> x < 0).average().getAsDouble());

        int[] cc = new int[]{8, 6, 9, 7};
        List<Integer> dd = new ArrayList<>(Arrays.asList(8, 6, 9, 7));

        double ccD = IntStream.of(cc).average().getAsDouble();
        double ddD = dd.stream().mapToDouble(x -> x).average().getAsDouble();
        System.out.println(ccD);
        System.out.println(ddD);

    }
}
