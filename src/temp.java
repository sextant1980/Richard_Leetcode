import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class temp {

    public static void main(String[] args) {
//
//        Comparable comparable = (a, b) -> a - b;

        String str = "Let's take LeetCode contest";
        String[] strA1 = str.split("(?=\\s)"); // negative look ahead
        System.out.println(Arrays.toString(strA1));

        String[] strA2 = str.split("(?<=\\s)"); // positive look ahead
        System.out.println(Arrays.toString(strA2));

        String strB = "Let's-take-LeetCode-contest";
        String[] strB1 = strB.split("(?=-)"); // negative look ahead
        System.out.println(Arrays.toString(strB1));

        String[] strB2 = strB.split("(?<=-)"); // positive look ahead
        System.out.println(Arrays.toString(strB2));
    }

    public boolean tryNow(int a, int b){
        if(a >= 0){
            if(b >= 0){
                return true;
            } else {
                return false;
            }
        } else {
            if(b >= 0){
                return false;
            }
        }
        return true;
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (x, y) -> {
            String[] xPart = x.split(" ", 2);
            String[] yPart = y.split(" ", 2);

            boolean xDigit = Character.isDigit(xPart[1].charAt(0));
            boolean yDigit = Character.isDigit(yPart[1].charAt(0));

            if(!xDigit){
                if(!yDigit){
                    return xPart[1].compareTo(yPart[1]) == 0? xPart[0].compareTo(yPart[0]) : xPart[1].compareTo(yPart[1]);
                } else {
                    return 1;
                }
            } else {
                if(!yDigit){
                    return -1;
                }
            }
            return 0;
        });

        return logs;
    }
}



