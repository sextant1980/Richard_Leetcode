
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode_1431_GreatestCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxC = IntStream.of(candies).max().getAsInt();
        return IntStream.of(candies).mapToObj(x -> x + extraCandies >= maxC).collect(Collectors.toList());
//        for(int i = 0; i < candies.length; i++){
//            if(candies[i] + extraCandies >= maxC){
//                result.add(true);
//            } else {
//                result.add(false);
//            }
//        }
//        return result;
    }
}
