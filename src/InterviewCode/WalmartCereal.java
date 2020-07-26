package InterviewCode;

import java.util.HashSet;
import java.util.stream.IntStream;

public class WalmartCereal {
    public static int getPrice(int[] array) {
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];
        if(array.length == 2) return Math.max(array[0], array[1]);

        HashSet<Integer> hs = new HashSet<>();
        int n = array.length;
        for(int i = 2; i <= n - 1; i++) {
            int[] subArray = new int[i];
            for(int j = 0; j <= n-i; j++) {
                System.arraycopy(array, j, subArray, 0, subArray.length);
                hs.add(IntStream.of(subArray).min().getAsInt());
            }
        }
        int result = hs.stream().mapToInt(x -> x).max().getAsInt();
        return result;
    }

    public static void main(String[] args) {
        int[] array = {8, 2, 4, 3, 6};
        int result = getPrice(array);
        System.out.println("result is: " + result);
    }
}

