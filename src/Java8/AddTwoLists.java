package Java8;

import oracle.jdbc.internal.XSCacheOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddTwoLists {
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>(Arrays.asList(3, 8, 5));
        List<Integer> listB = new ArrayList<>(Arrays.asList(5, 11, 7));

//        int a = listA.stream().max().get();

        // method 1
        List<Integer> listAdd = IntStream.range(0, listA.size()).map(i -> listA.get(i) + listB.get(i)).boxed().collect(Collectors.toList());
//        List<Integer> listAdd = IntStream.range(0, listA.size()).mapToObj(i -> listA.get(i) + listB.get(i)).collect(Collectors.toList());
        System.out.println(listAdd);

        // method 2
        List<Integer> listAdd2 = listA.stream().map(x -> x + listB.get(listA.indexOf(x))).collect(Collectors.toList());
        System.out.println(listAdd2);

        // method 3
        List<Integer> listAdd3 = new ArrayList<>();
        IntStream.range(0, listA.size()).forEach(i -> listAdd3.add(listA.get(i) + listB.get(i)));
        System.out.println(listAdd3);

        // method 4
        List<Integer> listAdd4 = new ArrayList<>();
        listA.forEach(x -> listAdd4.add(x + listB.get(listA.indexOf(x))));
        System.out.println(listAdd4);
    }

}
