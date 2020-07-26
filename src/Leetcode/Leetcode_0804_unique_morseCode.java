package Leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Leetcode_0804_unique_morseCode {
    public int uniqueMorseRepresentations(String[] words) {
        Map<Object, Long> myMap= Arrays.stream(words).map(x -> convertStrToMorse(x)).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        return myMap.size();
    }

    public String convertStrToMorse(String str){
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            int diff = str.charAt(i) - 'a';
            sb.append(morse[diff]);
        }

        return sb.toString();
    }
}
