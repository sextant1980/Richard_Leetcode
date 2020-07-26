package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListSumElements {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result1 = IntStream.range(0, startTime.length).map(i -> queryTime >= startTime[i] && queryTime <= endTime[i]? 1 : 0).boxed().collect(Collectors.summingInt(Integer::intValue));
        int result2 = IntStream.range(0, startTime.length).map(i -> queryTime >= startTime[i] && queryTime <= endTime[i]? 1 : 0).sum();

        int[] aa = new int[]{8, 6, 9, 7};
        List<Integer> bb = new ArrayList<>(Arrays.asList(8, 6, 9, 7));

        int aaSum = IntStream.of(aa).sum();
        int bbSum = bb.stream().mapToInt(x -> x).sum();
        int bbSum2 = bb.stream().collect(Collectors.summingInt(Integer::valueOf));

        return result1;
    }
}
