package Jiuzhangsuanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem0010StringPermutationsII
{
    public List<String> StringPermuteII(String input) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (input == null) {
            return results;
        }
        char[] chars = input.toCharArray();
        boolean[] visited = new boolean[chars.length];
        Arrays.sort(chars);
        StringBuilder permutation = new StringBuilder();
        dfs(chars, visited, permutation, results);
        return results;
    }

    private void dfs(char[] chars,
                     boolean[] visited,
                     StringBuilder permutation,
                     List<String> results) {
        if (permutation.length() == chars.length) {
            results.add(permutation.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i != 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            permutation.append(chars[i]);
            dfs(chars, visited, permutation, results);
            permutation.deleteCharAt(permutation.length() - 1);
            visited[i] = false;
        }
    }
}
