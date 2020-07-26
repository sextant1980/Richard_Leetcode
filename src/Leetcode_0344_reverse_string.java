import java.util.Arrays;

public class Leetcode_0344_reverse_string {
    public static void reverseString(char[] s) {
        helper(s, 0, s.length-1);
    }
    public static void helper(char[] s, int left, int right){
        if(left >= right) return;
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left, right);
    }

    public static void main(String[] args){
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println("new string = " + Arrays.toString(s));
    }
}


