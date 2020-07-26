package Leetcode;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String aa = "hibernate";
        char[] aaC = aa.toCharArray();
        int left = 0, right = aa.length() - 1;
        while(left < right) {
            char tmp = aaC[left];
            aaC[left] = aaC[right];
            aaC[right] = tmp;
            left++;
            right--;
        }
        String bb = String.valueOf(aaC);
        System.out.println(bb);
    }
}
