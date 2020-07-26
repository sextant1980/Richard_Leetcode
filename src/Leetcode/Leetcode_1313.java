package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class Leetcode_1313 {
    public int[] decompressRLElist(int[] nums) {
        LinkedList<Integer> LL = new LinkedList<>();
        for(int i = 0; i < nums.length; i = i + 2){
            for(int j = 0; j < nums[i]; j++){
                LL.add(nums[i + 1]);
            }
        }
        Integer[] aa = LL.toArray(new Integer[LL.size()]);
        return Arrays.stream(aa).mapToInt(Integer::intValue).toArray();
    }
}
