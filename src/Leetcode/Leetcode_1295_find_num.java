package Leetcode;

public class Leetcode_1295_find_num {
    public int findNumbers(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int pp = 0;
            while(nums[i] / (int) Math.pow(10,pp) != 0 ){
                pp++;
            }
            if(pp%2==0){
                result += 1;
            }
        }
        return result;
    }
}
