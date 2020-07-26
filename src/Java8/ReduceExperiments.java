package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReduceExperiments {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(3, 8, 9, 2, 5);
        int product = a.stream().reduce((x, y) -> x * y).get();

        int sum = a.stream().mapToInt(x -> x).sum();

        List<String> b = Arrays.asList("good", "Niu", "Bi", "68");
        String str = b.stream().reduce((x, y) -> x + y).get();
        System.out.println(str);

        BigDog bigDog1 = new BigDog(12, "dubi", 3);
        BigDog bigDog2 = new BigDog(8, "yubi", 6);
        BigDog bigDog3 = new BigDog(11, "rubi", 4);
        List<BigDog> dogList1 = new ArrayList<>();
        dogList1.add(bigDog1);
        dogList1.add(bigDog2);
        dogList1.add(bigDog3);

        String str2 = dogList1.stream().filter(x -> !x.getName().startsWith("y")).map(x -> x.getName()).reduce((x, y) -> x + y).get();
        System.out.println(str2);

        char[] aa = "HowAreYou".toCharArray();
        String str3 = String.valueOf(aa);
        String str4 = IntStream.range(0, aa.length).mapToObj(i -> String.valueOf(aa[i])).reduce((x, y) -> x + y).get();

        System.out.println(str3);
        System.out.println(str4);

        String str5 = Character.toString('a') + String.valueOf('b');
        System.out.println(str5);
    }
}
