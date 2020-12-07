package Leetcode;

import java.util.Arrays;

public class Lintcode_0609_TwoSum5 {
    /* Given an array of integers, find how many pairs in the array such that
    their sum is less than or equal to a specific target number. Please return the number of pairs.
     */
    public static int twoSum5(int[] nums, int target) {
        int[][] numsNew = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            numsNew[i][0] = nums[i];
            numsNew[i][1] = i;
        }
        numsNew = Arrays.stream(numsNew)
                .sorted((num1, num2) -> num1[0] == num2[0]? num1[1] - num2[1] : num1[0] - num2[0])
                .toArray(int[][]::new);
        int left = 0, right = nums.length - 1;
        int count = 0;
        while(left < right) {
            if (numsNew[left][0] + numsNew[right][0] > target) {
                right--;
            } else {
                count = count + (right - left);
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(twoSum5(new int[]{3, 9, 6, 4}, 13));
    }
}
