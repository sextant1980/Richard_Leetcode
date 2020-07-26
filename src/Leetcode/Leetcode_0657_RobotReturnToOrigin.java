package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode_0657_RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < moves.length(); i++) {
            if(moves.charAt(i) == 'U') y++;
            if(moves.charAt(i) == 'D') y--;
            if(moves.charAt(i) == 'L') x--;
            if(moves.charAt(i) == 'R') x++;
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        Leetcode_0657_RobotReturnToOrigin tryout = new Leetcode_0657_RobotReturnToOrigin();
        boolean result = tryout.judgeCircle("LDRRLRUULR");
        System.out.println(result);
    }
}
