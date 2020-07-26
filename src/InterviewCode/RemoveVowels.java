package InterviewCode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RemoveVowels {
    public static void solve(int n, String str) {
        Character[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> al = Arrays.asList(vowels);
        StringBuffer sb = new StringBuffer(str);
        for(int i = 0; i < sb.length(); i++) {
            if(al.contains(sb.charAt(i))) {
                sb.replace(i, i+1, "");
                i--;
            }
        }

        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
////        int n = in.nextInt();
////        in.nextLine();
////        String str = in.nextLine();
        int n = 7;
        String str = "akE. Hello";
        solve(n, str);
//        in.close();
    }
}
