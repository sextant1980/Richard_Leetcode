import java.util.HashSet;

class Solution {
    public static int nextRound(int n){
        int current_result = 0;
        while(n > 0){
            int residual = n%10;
            current_result += residual * residual;
            n = n / 10;
        }
        return current_result;
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while(n != 1 && !hs.contains(n)){
            hs.add(n);
            n = nextRound(n);
        }
        return n == 1;
    }

    public static void main(String[] args){
        int n = 19;
        boolean happy = isHappy(n);
        System.out.println(happy);
    }
}