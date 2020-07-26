import java.util.HashMap;

public class Leetcode_0709_toLowerCase {
    public static String mytoLowerCase(String str) {
        int n = str.length();
        String strUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String strLower = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, Character> myHM = new HashMap<>();
        for(int i=0; i<strUpper.length(); i++){
            myHM.put(strUpper.charAt(i), strLower.charAt(i));
        }

        StringBuilder myStr = new StringBuilder();
        for(char tmp : str.toCharArray()){
            myStr.append(myHM.containsKey(tmp)? myHM.get(tmp) : tmp);
        }
        return myStr.toString();
    }

    public static void main(String[] args){
        String str = "abcd";
        String str2 = mytoLowerCase(str);
        System.out.println("the new string is: " + str2);
    }

}

