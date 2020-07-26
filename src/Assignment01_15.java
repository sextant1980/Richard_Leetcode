import java.util.Collections;
import java.util.HashSet;

public class Assignment01_15 {

    public static void main(String[] args){
        int[] a = {3, 2, 3};

        if(a.length < 2){
            System.out.println("Array length is 1! No second largest value.");
        } else {
            HashSet<Integer> HS = new HashSet<>();
            for(int i=0; i<a.length; i++){
                HS.add(a[i]);
            }
            if(HS.size() == 1){
                System.out.println("Array elements have the same value! No second largest value.");
            } else {
                HS.remove(Collections.max(HS));
                System.out.println("The result is: " + Collections.max(HS));
            }
        }

    }
}
