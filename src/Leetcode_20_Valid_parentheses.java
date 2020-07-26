import java.util.HashMap;
import java.util.Stack;

public class Leetcode_20_Valid_parentheses {
    public static boolean solution(String s){

        if(s.length() == 0){
            return true;
        }
        if(s.length() == 1){
            return false;
        }
        HashMap<Character, Character> types = new HashMap<>();
        types.put(')', '(');
        types.put(']', '[');
        types.put('}', '{');

        Stack<Character> myStack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(types.containsKey(tmp)){
                if(myStack.isEmpty()){
                    return false;
                }
                char head = myStack.peek();
                if(head == types.get(tmp)){
                    myStack.pop();
                } else {
                    return false;
                }
//
//                if(myStack.isEmpty()){
//                    return true;
//                }
            } else {
                myStack.push(tmp);
            }

        }
        if(myStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        String str = "){";
        Boolean judge = solution(str);
        System.out.println("are the parenthese valid? " + judge);
    }
}
