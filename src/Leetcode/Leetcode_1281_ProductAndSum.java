package Leetcode;

public class Leetcode_1281_ProductAndSum {
    public int subtractProductAndSum(int n) {
        String nS = String.valueOf(n);
        int product = nS.chars().map(x -> Character.getNumericValue((char) x)).reduce((a, b) -> a * b).getAsInt();
        int sum = nS.chars().map(x -> Character.getNumericValue((char) x)).sum();
        return product + sum;
    }

    public static void main(String[] args) {
        Leetcode_1281_ProductAndSum tmp = new Leetcode_1281_ProductAndSum();
        int result = tmp.subtractProductAndSum(234);
        System.out.println(result);
    }
}
