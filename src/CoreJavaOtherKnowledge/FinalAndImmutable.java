package CoreJavaOtherKnowledge;

import java.util.Arrays;

public class FinalAndImmutable {
    public static void main(String[] args) {
        final String str = "how";
//        str = "good"; // cannot change reference and thus content
        final int aa = 13;
//        aa = 9; // cannot change reference and thus content
        final int[] bb = {8, 9, 3, 2};
        bb[2] = 8; // the content of bb can be changed, but reference of bb cannot change. bb will always point the the same object;
        System.out.println(Arrays.toString(bb));

        String str1 = "good";
        str1 = "duid"; // the content of string "good" cannot be changed, but the reference of str1 can be changed.

        try {
            int kk = 10/0;
        } catch (Exception ex) {
            System.out.println("great!");
        }
    }
}
