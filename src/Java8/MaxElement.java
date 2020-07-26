package Java8;

import oracle.jdbc.internal.XSCacheOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MaxElement {
    public static void main(String[] args) {
        int[] aa = new int[]{8, 6, 9, 7};
        List<Integer> bb = new ArrayList<>(Arrays.asList(8, 6, 9, 7));

        int aaMax1 = Arrays.stream(aa).max().getAsInt();
        int aaMax2 = IntStream.of(aa).max().getAsInt();

        int bbMax1 = bb.stream().max((a, b) -> a - b).get();
        int bbMax2 = bb.stream().mapToInt(x -> x).max().getAsInt();

        System.out.println(aaMax1);
        System.out.println(aaMax2);
        System.out.println(bbMax1);
    }


}
