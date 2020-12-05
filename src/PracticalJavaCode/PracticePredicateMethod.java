package PracticalJavaCode;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PracticePredicateMethod {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("Busi", "Doki", "Luci", "Darcy");
        myList = myList.stream().filter(judgeString()).collect(Collectors.toList());
        System.out.println(myList);
    }

    public static Predicate<String> judgeString() {
        return str -> str.length() == 4;
    }
}
