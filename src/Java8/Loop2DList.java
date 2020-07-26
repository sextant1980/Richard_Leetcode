package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loop2DList {
    public static void main(String[] args) {
        List<List<Integer>> aa = new ArrayList<>();
        aa.add(new ArrayList<>(Arrays.asList(3, 8, 9)));
        aa.add(new ArrayList<>(Arrays.asList(2, 7)));

        for(List<Integer> list : aa){
            System.out.println(list.get(0));
        }
    }
}
