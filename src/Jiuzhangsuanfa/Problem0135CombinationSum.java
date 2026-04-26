package Jiuzhangsuanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem0135CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null) {
            return results;
        }
        Arrays.sort(candidates);
        int[] newCandi = removeDuplicate(candidates);
        List<Integer> combination = new ArrayList<>();
        dfs(0, target, newCandi, combination, results);
        return results;
    }
    private int[] removeDuplicate(int[] candidates) {
        int k = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[k]) {
                candidates[++k] = candidates[i];
            }
        }
        int[] newCandi = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            newCandi[i] = candidates[i];
        }
        return newCandi;
    }
    private void dfs(int startIndex,
                     int target,
                     int[] candidates,
                     List<Integer> combination,
                     List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            combination.add(candidates[i]);
            dfs(i, target - candidates[i], candidates, combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}
