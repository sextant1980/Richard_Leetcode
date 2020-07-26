public class Leetcode_1180_CountSubarray {
    public static int countLetters(String S) {
        int count = 1;
        int arrCount = 0;
        for(int i = 1; i < S.length(); i++){
            if(S.charAt(i) == S.charAt(i - 1)){
                count++;
            } else {
                arrCount += count * (1 + count)/2;
                count = 1;
            }
        }
        arrCount += count * (1 + count)/2;

        if(count == S.length()){
            return count * (1 + count)/2;
        }

        return arrCount;
    }

    public static void main(String[] args) {
        String S = "aaaba";
        System.out.println(countLetters(S));

        String S1 = "yyyyyyyyyyyyyyyyyyyyyyyyyyy";
        System.out.println(countLetters(S1));

        String S2 = "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk";
        System.out.println(countLetters(S2));

        String S3 = "hhhhhhhhhhhhhhhhhh";
        System.out.println(countLetters(S3));

        String S4 = "mm";
        System.out.println(countLetters(S4));

        String S5 = "k";
        System.out.println(countLetters(S5));

        String S6 = "bbb";
        System.out.println(countLetters(S6));
    }
}
