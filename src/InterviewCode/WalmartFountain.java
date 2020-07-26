package InterviewCode;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class WalmartFountain {
    public static int findMinNumFountain(int n, int[] location) {
        if(n != location.length) return 999999;
        int[][] limits = new int[n+1][2];
        for(int i = 1; i <= n; i++) {
            limits[i][0] = Math.max(i - location[i - 1], 1);
            limits[i][1] = Math.min(i + location[i - 1], n);
            System.out.println("limits is: " + limits[i][0] + " and " + limits[i][1]);
        }

//        int stackLeftLimit = limits[0][0];
//        int stackRightLimit = limits[0][1];
        Stack<int[]> myStack = new Stack<>();
        myStack.push(limits[1]);
        for(int i = 2; i <= n; i++) {
            while(!myStack.isEmpty() && limits[i][0] <= myStack.peek()[0] && limits[i][1] >= myStack.peek()[1]) {
                myStack.pop();
            }
            if(!myStack.isEmpty() && limits[i][0] >= myStack.peek()[0] && limits[i][1] <= myStack.peek()[1]) {
                continue;
            } else {
                myStack.push(limits[i]);
            }
        }
        return myStack.size();
    }

    public static void main(String[] args) throws IOException {
        int n = 500;
        File file = new File("c:\\Users\\pan\\Desktop\\input003_clean.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int[] location = new int[n];
        String st;
        int pp = 0;
        while ((st = br.readLine()) != null) {
            location[pp] = Integer.parseInt(st);
            pp++;
        }
//        System.out.println(Arrays.toString(location));
//        int[] location = new int[]{1, 2, 1, 1, 1};
        int minNum = findMinNumFountain(n, location);
        System.out.println(minNum);
    }
}
