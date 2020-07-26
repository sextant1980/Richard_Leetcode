package Leetcode;

public class CountDigit {
    public static void main(String[] args) {
        int a = 372939393;
        int aOri = a;

        int pp = 1;
        while(a / 10 != 0){
            a = a / 10;
            pp++;
        }
        System.out.println("the digit of " + aOri + " is: " + pp);

    }
}
