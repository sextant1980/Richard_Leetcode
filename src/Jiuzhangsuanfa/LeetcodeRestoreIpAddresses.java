package Jiuzhangsuanfa;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeRestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        List<String> solution = new ArrayList<>();
        dfs(0, solution, results, s);
        return results;
    }
    private void dfs(int startIndex, List<String> solution, List<String> results, String s) {
        if (solution.size() == 3) {
            if (isValid(s.substring(startIndex))) {
                results.add(String.join(".", solution) + "." + s.substring(startIndex));
            }
            return;
        }
        for (int i = startIndex; i < startIndex + 3 && i < s.length(); i++) {
            if (!isValid(s.substring(startIndex, i + 1))) {
                break;
            }
            solution.add(s.substring(startIndex, i + 1));
            dfs(i + 1, solution, results, s);
            solution.remove(solution.size() - 1);
        }
    }
    private boolean isValid(String str) {
        if (str.length() == 0 || str.length() > 3) {
            return false;
        }
        int value = Integer.parseInt(str);
        if (value > 255) {
            return false;
        }
        if (str.startsWith("0") && str.length() != 1) {
            return false;
        }
        return true;
    }
}
