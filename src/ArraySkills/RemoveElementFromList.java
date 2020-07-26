package ArraySkills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveElementFromList {
    public static void main(String[] args) {
        List<Integer> aa = new ArrayList<>(Arrays.asList(3, 8, 2, 5));
        List<Integer> toRemove = new ArrayList<>();
        for(int i = 0; i < aa.size(); i++) {
            if(aa.get(i) >= 4) {
                toRemove.add(aa.get(i));
            }
        }
        aa.removeAll(toRemove);
        System.out.println(aa);

        List<Integer> bb = aa.stream().filter(x -> x < 4).collect(Collectors.toList());
        System.out.println(bb);
    }
}
