import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Assignment03_15 {

    public static void main(String[] args){

        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(10);

        HashMap<String, String> B = new HashMap<>();
        B.put("a","1");
        B.put("b","2");
        B.put("c","10");

        List<Integer> C = new ArrayList<>();
        for(int x : A){
            if(!B.containsValue(String.valueOf(x))){
                C.add(x);
            }
        }

        System.out.println("The new list is: " + C);
    }
}
