public class Leetcode_1108_Defanging_IP {
    public static String defangIPaddr(String address) {
//        int n = address.length();
//        // char[] strA = address.toCharArray;
//        StringBuilder myStr = new StringBuilder();
//        for(int i=0; i<n; i++){
//            if(address.charAt(i) == '.'){
//                myStr.append("[.]");
//            } else {
//                myStr.append(address.charAt(i));
//            }
//        }
//        String str_new = myStr.toString();
//        return str_new;
        return address.replace(".", "[.]");
    }

    public static void main(String[] args){
        String str = "1.1.1.1";
        String str_new = defangIPaddr(str);
        System.out.println("result is: " + str_new);
    }
}
