package InterviewCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EquifaxPrisonBreak {
    public static void main(String[] args) throws IOException {
        File file1 = new File("d:\\Computer Science\\Antra_training\\Interviews\\Interview_Codes\\Equifax\\input003_hori.txt");
        File file2 = new File("d:\\Computer Science\\Antra_training\\Interviews\\Interview_Codes\\Equifax\\input003_vert.txt");
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file1));
        String st;
        int pp = 0;
        while ((st = br.readLine()) != null) {
            h.add(Integer.parseInt(st));
            pp++;
        }

        br = new BufferedReader(new FileReader(file2));
        pp = 0;
        while ((st = br.readLine()) != null) {
            v.add(Integer.parseInt(st));
            pp++;
        }

        long result = prison(1000, 1000, h, v);
        System.out.println(result);
//        int n = 100000;
//        int m = 20000;
//        List<Integer> h = new ArrayList<>(Arrays.asList(1));
//        List<Integer> v = new ArrayList<>(Arrays.asList(1, 2));
//        long result = prison(n, m, h, v);
//        System.out.println(result);
    }

    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        int conH = findContiguous(h);
        int conV = findContiguous(v);
        return (long) ((long) ((long) conH + 1) * (long) ((long) conV + 1));
    }

    public static int findContiguous (List<Integer> list) {
        int maxCount = 1;
        int count = 1;
        list = list.stream().sorted().collect(Collectors.toList());
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) - list.get(i - 1) == 1) {
                count++;
                if(count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}
