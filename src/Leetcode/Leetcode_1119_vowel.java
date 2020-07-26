package Leetcode;

public class Leetcode_1119_vowel {
    public String removeVowels(String S) {
        StringBuilder sd = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == 'a' || S.charAt(i) == 'e' || S.charAt(i) == 'i' || S.charAt(i) == 'o' || S.charAt(i) == 'u') {
                continue;
            } else {
                sd.append(S.charAt(i));
            }
        }
        return sd.toString();
    }
}
