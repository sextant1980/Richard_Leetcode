package Leetcode;

import java.util.stream.IntStream;

public class Leetcode_1461_MaxProduct {
    public int maxProduct(int[] nums) {
//        int globalMax = (nums[0] - 1) * (nums[1] - 1);
//        for(int i = 2; i < nums.length; i++) {
//            for(int j = 0; j < i; j++) {
//                if((nums[j] - 1) * (nums[i] - 1) > globalMax) {
//                    globalMax = (nums[j] - 1) * (nums[i] - 1);
//                }
//            }
//        }
//        return globalMax;
        nums = IntStream.of(nums).sorted().toArray();
        return (nums[nums.length-2] - 1) * (nums[nums.length-1] - 1);
    }

    public static void main(String[] args) {
        Leetcode_1461_MaxProduct tryout = new Leetcode_1461_MaxProduct();
        int result = tryout.maxProduct(new int[]{3,4,5,2});
        System.out.println(result);
    }
}
