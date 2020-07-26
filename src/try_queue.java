import java.util.*;

public class try_queue {

    public static boolean isSub(String s, String t) {
//        String s = "abc";
//        String t = "kdlsa";
        int index_tmp = t.indexOf(s.charAt(0));
        System.out.println(index_tmp);
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "kdlsa";
        char[] charTmp = new char[t.length()];
        charTmp = t.toCharArray();
        boolean judge = isSub(s, t);
        System.out.println(judge);
    }

}
