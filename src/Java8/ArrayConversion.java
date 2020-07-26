package Java8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayConversion {
    public static void main(String[] args) {
        // problem 1: convert int[] to integer[]
        int[] aa = new int[]{3, 9, 8, 2};

        // int array -> integer array
        // method 1:
        Integer[] aaI1 = Arrays.stream(aa).boxed().toArray(Integer[]::new);
        Integer[] aaI2 = Arrays.stream(aa).boxed().toArray(x -> new Integer[x]);

        // method 2:
        Integer[] aaI3 = Arrays.stream(aa).mapToObj(x -> x).toArray(x -> new Integer[x]);
        Integer[] aaI3_2 = Arrays.stream(aa).mapToObj(x -> Integer.valueOf(x)).toArray(x -> new Integer[x]);

        // method 3:
        Integer[] aaI4 = new Integer[aa.length];
        IntStream.range(0, aa.length).forEach(i -> aaI4[i] = aa[i]);


        // problem 2: convert int[] to String[]
        String[] bb1 = Arrays.stream(aa).mapToObj(x -> String.valueOf(x)).toArray(String[]::new);
//        String[] bb2 = Arrays.stream(aa).boxed().toArray(String[]::new);
        System.out.println("the String[] is " + Arrays.toString(bb1));

        // problem 3: convert Integer[] to int[]
        Integer[] cc = new Integer[]{3, 9, 8, 2};

        int[] ccIntArray1 = Arrays.stream(cc).mapToInt(x -> x).toArray();
        int[] ccIntArray2 = Arrays.stream(cc).mapToInt(x -> x.intValue()).toArray();
        int[] ccIntArray3 = Arrays.stream(cc).mapToInt(Integer::intValue).toArray();

        // problem 4: convert String[] to int[]
        String[] dd = new String[]{"3", "9", "8", "2"};

        int[] ddA1 = Arrays.stream(dd).mapToInt(x -> Integer.parseInt(x)).toArray();
        int[] ddA2 = Arrays.stream(dd).mapToInt(Integer::parseInt).toArray();

        // problem 5: convert Integer[] to String[]
        String[] ccS1 = Arrays.stream(cc).map(x -> String.valueOf(x)).toArray(String[]::new);
        System.out.println("problem 5 String[] is: " + Arrays.toString(ccS1));

        // problem 6: convert String[] to Integer[]
        Integer[] ddI1 = Arrays.stream(dd).map(x -> Integer.parseInt(x)).toArray(Integer[]::new);
        Integer[] ddI2 = Arrays.stream(dd).map(x -> Integer.parseInt(x)).toArray(x -> new Integer[x]);
        System.out.println("problem 6 Integer[] is: " + Arrays.toString(ddI1));

        // problem 6: convert a List of Integer to int[]
        List<Integer> aList = new ArrayList<>(Arrays.asList(3, 9, 8, 2));

        int[] aArray1 = aList.stream().mapToInt(x -> x).toArray();
        int[] aArray2 = aList.stream().mapToInt(x -> x.intValue()).toArray();

        // problem 7: convert a List of String to int[]
        List<String> bList = new ArrayList<>(Arrays.asList("3", "9", "8", "2"));

        int[] bArray1 = bList.stream().mapToInt(x -> Integer.parseInt(x)).toArray(); // auto unboxing involved

        // problem 8: convert int[] to a List
        int[] array1 = new int[]{3, 9, 8, 2};
        List<Integer> list1 = Arrays.stream(array1).boxed().collect(Collectors.toList());

        // problem 9: convert String to char List
        String str = "goodNiu";
        List<Character> charL = str.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
        System.out.println("problem 9 char List is: " + charL);
    }
}
