package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class SortingPractice {
    public static void main(String[] args) {
        // problem 1: sort int[] in ascending order
        int[] intA = new int[]{3, 9, 8, 5};
        // method 1
        Arrays.sort(intA);
        System.out.println(Arrays.toString(intA));
        // method 2
        int[] intASort1 = Arrays.stream(intA).sorted().toArray();
        System.out.println(Arrays.toString(intASort1));

        // problem 2: sort int[] in descending order
        int[] intAsort2 = Arrays.stream(intA).boxed().sorted((a, b) -> b - a).mapToInt(x -> x).toArray();
        System.out.println(Arrays.toString(intAsort2));

        // problem 3: sort String[] in descending order
        String[] strA = new String[]{"game", "beat", "ohla", "dog"};

        Arrays.sort(strA, (a, b) -> b.compareTo(a));
        String[] strSort2 = Arrays.stream(strA).sorted((a, b) -> b.compareTo(a)).toArray(x -> new String[x]);
        System.out.println(Arrays.toString(strA));
        System.out.println(Arrays.toString(strSort2));

        // problem 4: sort Integer[] in descending order
        Integer[] aa = new Integer[]{3, 9, 8, 5};
        Comparator<Integer> comp = (a, b) -> b - a;
        Arrays.sort(aa, comp);
//        Arrays.sort(aa, (a, b) -> b - a);
        System.out.println(Arrays.toString(aa));

        // problem 5: sort List of objects by two fields
        BigCat bigCat1 = new BigCat("dubi", 3);
        BigCat bigCat2 = new BigCat("yubi", 3);
        BigCat bigCat3 = new BigCat("rubi", 4);


        List<BigCat> catList = new ArrayList<>();
        catList.add(bigCat1);
        catList.add(bigCat2);
        catList.add(bigCat3);

        List<BigCat> catList1 = catList.stream().sorted((a, b) -> a.getAge() == b.getAge()? b.getName().compareTo(a.getName()) : a.getAge() - b.getAge()).collect(Collectors.toList());
        System.out.println(catList1);

        Collections.sort(catList, (a, b) -> a.getAge() == b.getAge()? b.getName().compareTo(a.getName()) : a.getAge() - b.getAge());
        System.out.println("new catList = " + catList);

        catList = catList.stream().sorted(Comparator.comparing(BigCat::getAge, Collections.reverseOrder()).thenComparing(BigCat::getName, Collections.reverseOrder())).collect(Collectors.toList());
        System.out.println(catList);
        // problem 6:
    }

}

class BigCat {
    private String name;
    private int age;

    public BigCat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BigCat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}