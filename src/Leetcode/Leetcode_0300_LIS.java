package Leetcode;

import java.util.Arrays;

public class Leetcode_0300_LIS {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) {return 0;}
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1,0,3,2,3};
        int output = lengthOfLIS(input);
        System.out.println(output);
    }
}
