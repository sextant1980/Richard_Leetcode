package InterviewCode;

public class AlmostPalindrome {

    public static void solve(int n, String str) {
        char[] strC = str.toCharArray();
        char result = str.charAt(0);
        for(int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);
            sb.replace(i, i+1, "");
            if(isPalind(sb.toString())) {
                result = str.charAt(i);
                break;
            }
        }
        System.out.println(result);
    }

    public static boolean isPalind(String str) {
        int low = 0;
        int high = str.length() - 1;
        while(low < high) {
            if(str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abccdba";
//        System.out.println(isPalind(str));
        solve(str.length(), str);
    }
}
