package Leetcode;

import java.util.Arrays;

public class Leetcode_1371_Increasing_Decreasing_String {
    public static String sortString(String s) {
        if(s.length() == 1) return s;
        StringBuilder sb = new StringBuilder();
        int[] frequency = new int[26];
        for(char c : s.toCharArray()){
            int index = c - 'a';
            frequency[index] += 1;
        }
        while(Arrays.stream(frequency).sum() > 0){
            for(int i = 0; i < 26; i++){
                if(frequency[i] > 0){
                    sb.append((char) ('a' + i));
                    frequency[i] -= 1;
                }
            }
            for(int i = 25; i >= 0; i--){
                if(frequency[i] > 0){
                    sb.append((char) ('a' + i));
                    frequency[i] -= 1;
                }
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        String str = sortString(s);
        System.out.println(str);
    }
}
