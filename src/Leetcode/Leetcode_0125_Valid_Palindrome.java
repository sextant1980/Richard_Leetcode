package Leetcode;

public class Leetcode_0125_Valid_Palindrome {
    public static boolean isPalindrome(String s) {
        if(s == null) { return false; }
        int left = 0, right = s.length() - 1;
        while(left < right) {
            while(left < right && !isValidChar(s.charAt(left))) {
                left++;
            }
            while(left < right && !isValidChar(s.charAt(right))) {
                right--;
            }
            if(!isEqualChar(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isValidChar(char a) {
        return Character.isAlphabetic(a) || Character.isDigit(a);
    }

    public static boolean isEqualChar(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
