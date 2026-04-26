package Jiuzhangsuanfa;

import java.util.*;
import java.util.stream.IntStream;

public class WordLadder2 {
    /**
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     *          we will sort your return value in output
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        dict.add(start);
        dict.add(end);
        Map<String, Set<String>> index = buildIndex(dict);
        Map<String, Integer> distance = bfs(end, index);
        List<List<String>> ladders = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(start);
        dfs(start, end, index, distance, path, ladders);
        return ladders;
    }

    private void dfs(String start,
                     String end,
                     Map<String, Set<String>> index,
                     Map<String, Integer> distance,
                     List<String> path,
                     List<List<String>> ladders) {
        if (start.equals(end)) {
            ladders.add(new ArrayList(path));
            return;
        }
        for (String curr : findNeiberhoodWords(start, index)) {
            if (distance.get(curr) != distance.get(start) - 1) {
                continue;
            }
            path.add(curr);
            dfs(curr, end, index, distance, path, ladders);
            path.remove(path.size() - 1);
        }
    }

    private Map<String, Set<String>> buildIndex(Set<String> dict) {
        Map<String, Set<String>> index = new HashMap<>();
        dict.forEach(word -> {
            IntStream.range(0, word.length())
                    .mapToObj(i -> word.substring(0, i) + "%" + word.substring(i + 1))
                    .forEach(key -> index.computeIfAbsent(key, k -> new HashSet<>()).add(word));
        });
        return index;
    }

    private Map<String, Integer> bfs(String end, Map<String, Set<String>> index) {
        Map<String, Integer> distance = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(end);
        distance.put(end, 0);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            findNeiberhoodWords(curr, index).forEach(wrd -> {
                if (!distance.containsKey(wrd)) {
                    distance.put(wrd, distance.get(curr) + 1);
                    queue.offer(wrd);
                }
            });
        }
        return distance;
    }

    private List<String> findNeiberhoodWords(String word, Map<String, Set<String>> index) {
        List<String> neiberhoodWords = new ArrayList<>();
        IntStream.range(0, word.length())
                .mapToObj(i -> word.substring(0, i) + "%" + word.substring(i + 1))
                .forEach(w -> neiberhoodWords.addAll(index.get(w)));
        return neiberhoodWords;
    }
}
