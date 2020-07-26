package Leetcode;

import java.util.Arrays;

public class Leetcode_1389_create_target {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        Arrays.fill(target, -1);

        int max_index = 0;
        for(int i = 0; i < nums.length; i++){
            if(target[index[i]] == -1){
                max_index = index[i];
                target[index[i]] = nums[i];
            } else {
                System.arraycopy(target, index[i], target, index[i] + 1, max_index - index[i] + 1);
                max_index++;
            }
        }
        return target;
    }
//        int[] target = new int[nums.length];
//        int[] tmp = new int[nums.length];
//        Arrays.fill(tmp, -1);
//        target[0] = nums[0];
//        tmp[0] = 0;
//
//        if(index.length == 1){
//            return target;
//        }
//
//        for(int i = 1; i < index.length; i++){
//            System.arraycopy(target, 0, tmp, 0, target.length);
//            if(index[i] == 0){
//                target[index[i]] = nums[i];
//                System.arraycopy(tmp, 0, target, index[i] + 1, i);
//            } else if(index[i] == i){
//                System.arraycopy(tmp, 0, target, 0, i);
//                target[index[i]] = nums[i];
//            } else {
//                System.arraycopy(tmp, 0, target, 0, index[i]);
//                target[index[i]] = nums[i];
//                System.arraycopy(tmp, index[i], target, index[i] + 1, i-index[i]);
//            }
//
//        }
//        return target;
//    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,0};
        int[] index = {0,1,2,3,0};
        // result = {0,1,2,3,4}
//        int[] result = createTargetArray(nums, index);
//        System.out.println(Arrays.toString(result));
    }
}
