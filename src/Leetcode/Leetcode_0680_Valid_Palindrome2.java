package Leetcode;

public class Leetcode_0680_Valid_Palindrome2 {
    public static boolean validPalindrome(String s) {
        if (s == null) { return false; }
        Pair pair = findDiff(s);
        if (pair.leftIndx < pair.rightIndx) {
            return isPalindrome(s.substring(pair.leftIndx, pair.rightIndx))
                    || isPalindrome(s.substring(pair.leftIndx + 1, pair.rightIndx + 1));
        }
        return true;
    }

    public static Pair findDiff(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return new Pair(left, right);
    }

    public static boolean isPalindrome(String s) {
        Pair pair = findDiff(s);
        return pair.leftIndx >= pair.rightIndx;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }
}

class Pair {
    public int leftIndx;
    public int rightIndx;

    public Pair(int leftIndx, int rightIndx) {
        this.leftIndx = leftIndx;
        this.rightIndx = rightIndx;
    }
}
