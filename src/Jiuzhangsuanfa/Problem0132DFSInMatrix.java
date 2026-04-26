package Jiuzhangsuanfa;

import java.util.*;

public class Problem0132DFSInMatrix {
    public static int[] dirX= new int[]{-1, 0, 1, 0};
    public static int[] dirY= new int[]{0, -1, 0, 1};

    static void main() {
        Problem0132DFSInMatrix solution = new Problem0132DFSInMatrix();
        char[][] board = new char[][]{
                {'b', 'a', 'b', 'b', 'a'}
        };
        List<String> words = new ArrayList<>();
        words.add("babbab");
        words.add("b");
        words.add("a");
        words.add("ba");
        List<String> results = solution.wordSearchII(board, words);
        System.out.println(results);
    }
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        Set<String> results = new HashSet<>();
        if (words == null || words.isEmpty()) {
            return new ArrayList<>(results);
        }
        Map<String, Boolean> map = getBooleanMap(words);
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                sb.append(board[i][j]);
                dfs(i, j, sb, board, visited, map, results);
                sb.deleteCharAt(sb.length() - 1);
                visited[i][j] = false;
            }
        }
        return new ArrayList<>(results);
    }
    private void dfs(int idX, int idY, StringBuilder sb,
                     char[][] board,
                     boolean[][] visited,
                     Map<String, Boolean> map,
                     Set<String> results) {
        if (map.getOrDefault(sb.toString(), false)) {
            results.add(sb.toString());
        }
        if (!map.containsKey(sb.toString())) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newIdX = idX + dirX[i];
            int newIdY = idY + dirY[i];
            if (newIdX < 0 || newIdY < 0 || newIdX >= board.length || newIdY >= board[0].length || visited[newIdX][newIdY]) {
                continue;
            }
            sb.append(board[newIdX][newIdY]);
            visited[newIdX][newIdY] = true;
            dfs(newIdX, newIdY, sb, board, visited, map, results);
            sb.deleteCharAt(sb.length() - 1);
            visited[newIdX][newIdY] = false;
        }
    }
    private Map<String, Boolean> getBooleanMap(List<String> words) {
        Map<String, Boolean> map = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String curr = word.substring(0, i + 1);
                if (curr.length() != word.length()) {
                    map.putIfAbsent(curr, false);
                } else {
                    map.put(curr, true);
                }
            }
        }
        return map;
    }
}
