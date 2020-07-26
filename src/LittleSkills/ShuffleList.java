package LittleSkills;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleList {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("0");
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

//        swap(myList, 1, 3);
        shuffle(myList);
        System.out.println(myList);
    }

    private static void swap(List<String> myList, int from, int to) {
        String tmp = myList.get(from);
        myList.set(from, myList.get(to));
        myList.set(to, tmp);
    }

    public static void shuffle(List<String> myList) {
        Random random = new Random();
        for(int i = 0; i < myList.size(); i++) {
            int to = random.nextInt(myList.size() - 1);
            swap(myList, i, to);
        }
    }
}

//class abc {
////    public static void main(String[] args) {
////        ShuffleList mySh = new ShuffleList();
////
////    }
//    public void callB() {
//        ShuffleList.
//    }
//}