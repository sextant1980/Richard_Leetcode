package PracticalJavaCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DebuggingStreamChain {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("Busi", "Doki", "Luci", "Darcy");
        myList = filterList(myList);
        System.out.println(myList);
    }

    public static List<String> filterList(List<String> myList) {
        return myList.stream().filter(x -> x.startsWith("D")).map(x -> x + "X").sorted().collect(Collectors.toList());
    }
}
