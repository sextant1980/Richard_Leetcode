public class Leetcode_1165_SingleRowKeyboard {
    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String word = "cba";
        int time = calculateTime(keyboard, word);
        System.out.println(time);

    }

    public static int calculateTime(String keyboard, String word) {
        int index0 = keyboard.indexOf(word.charAt(0));
        int time = 0;
        for(int i = 1; i < word.length(); i++){
            int indexTmp = keyboard.indexOf(word.charAt(i));
            time += Math.abs(indexTmp - index0);
            index0 = indexTmp;
        }
        return time;
    }
}
