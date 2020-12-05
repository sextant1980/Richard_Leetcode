package IfElseRefactor;

public class RewriteIfElse01 {
    public static void main(String[] args) {
        String str = "B";
        int num = 6;
        int result;
//        if(str.equals("A")) {
//            if(num == 0) {
//                result = 99;
//            } else {
//                result = -99;
//            }
//        } else {
//            result = 99;
//        }
        if(!str.equals("A") || num == 0) {
            result = 99;
        } else {
            result = -99;
        }
        System.out.println(result);
    }
}
