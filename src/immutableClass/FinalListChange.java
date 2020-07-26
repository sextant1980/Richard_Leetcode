package immutableClass;

import java.util.ArrayList;

public class FinalListChange {
    public static void main(String[] args) {
        final ArrayList<Integer> myList = new ArrayList<>();
        myList.add(3);
        myList.add(9);
        myList.add(6);
        System.out.println(myList);
    }
}
