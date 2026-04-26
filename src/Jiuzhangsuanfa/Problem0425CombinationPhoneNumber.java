package Jiuzhangsuanfa;

import java.util.*;

public class Problem0425CombinationPhoneNumber {
    public static final Map<Character, List<Character>> map = new HashMap<>();
    static {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    static void main() {
        Problem0425CombinationPhoneNumber solution = new Problem0425CombinationPhoneNumber();
        String digits = "23";
        List<String> results = solution.letterCombinations(digits);
        System.out.println(results);
    }
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return results;
        }
        char[] digitChars = digits.toCharArray();
        StringBuilder combination = new StringBuilder();
        dfs(0, digitChars, combination, results);
        return results;
    }

    private void dfs(int index,
                     char[] digitChars,
                     StringBuilder combination,
                     List<String> results) {
        if (combination.length() == digitChars.length) {
            results.add(combination.toString());
            return;
        }
        List<Character> currChars = map.get(digitChars[index]);
        for (int i = 0; i < currChars.size(); i++) {
            combination.append(currChars.get(i));
            dfs(index + 1, digitChars, combination, results);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
