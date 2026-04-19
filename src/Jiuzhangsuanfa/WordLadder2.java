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
        dict.add(start);
        dict.add(end);
        Map<String, Set<String>> index = buildIndex(dict);
        List<List<String>> ladders = new ArrayList<>();
    }

    public Map<String, Set<String>> buildIndex(Set<String> dict) {
        Map<String, Set<String>> index = new HashMap<>();
        dict.forEach(word -> {
            IntStream.range(0, word.length())
                    .mapToObj(i -> word.substring(0, i) + "%" + word.substring(i + 1))
                    .forEach(key -> index.computeIfAbsent(key, k -> new HashSet<>()).add(word));
        });
        return index;
    }

    public List<String> findNeiberhoodWords(String word, Map<String, Set<String>> index) {
        List<String> neiberhoodWords = new ArrayList<>();
        IntStream.range(0, word.length())
                .mapToObj(i -> word.substring(0, i) + "%" + word.substring(i + 1))
                .map(w -> neiberhoodWords.addAll(index.get(w)));
        return neiberhoodWords;
    }
}
