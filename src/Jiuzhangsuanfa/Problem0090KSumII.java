package Jiuzhangsuanfa;

import java.util.ArrayList;
import java.util.List;

public class Problem0090KSumII {
    public List<List<Integer>> kSumII(int[] a, int k, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (a == null) {
            return results;
        }
        List<Integer> combination = new ArrayList<>();
        dfs(0, a, k, target, combination, results);
        return results;
    }
    private void dfs(int startIndex,
                     int[] a,
                     int k,
                     int target,
                     List<Integer> combination,
                     List<List<Integer>> results) {
        if (target == 0 && k == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        for (int i = startIndex; i < a.length; i++) {
            if (target - a[i] < 0 || k == 0) {
                break;
            }
            combination.add(a[i]);
            dfs(i + 1, a, k - 1, target - a[i], combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}
