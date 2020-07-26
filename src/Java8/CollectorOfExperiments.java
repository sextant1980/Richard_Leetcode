package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorOfExperiments {
    public static void main(String[] args) {
        BigDog bigDog1 = new BigDog(12, "dubi", 3);
        BigDog bigDog2 = new BigDog(8, "yubi", 6);
        BigDog bigDog3 = new BigDog(11, "rubi", 4);
        List<BigDog> dogList1 = new ArrayList<>();
        dogList1.add(bigDog1);
        dogList1.add(bigDog2);
        dogList1.add(bigDog3);

        List<Integer> index = dogList1.stream().filter(x -> x.getId() > 10)
                .collect(Collector.of(ArrayList::new, (resultList, bigDog) -> resultList.add(dogList1.indexOf(bigDog)), (a, b) -> new ArrayList<>()));

        System.out.println(index);

        List<Integer> index2 = dogList1.stream().filter(x -> x.getId() > 10).mapToInt(x -> dogList1.indexOf(x)).boxed().collect(Collectors.toList());
        System.out.println(index2);

    }
}

class BigDog {
    private int id;
    private String name;
    private int age;

    public BigDog(int id, String name, int age) {
        this.id = id;
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
        return "BigDog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}