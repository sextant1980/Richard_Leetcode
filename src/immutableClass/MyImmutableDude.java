package immutableClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class MyImmutableDude {

    private final String name;
    private final int age;
    private final ArrayList<Integer> myArrayList;

    public MyImmutableDude(String name, int age, ArrayList<Integer> myArrayList) {
        this.name = name;
        this.age = age;
//        this.myArrayList = myArrayList;
        ArrayList<Integer> tmpList = new ArrayList<>();
        myArrayList.forEach(x -> tmpList.add(x));
        this.myArrayList = tmpList;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Integer> getMyArrayList() {
        return (ArrayList<Integer>) myArrayList.clone();
//        return myArrayList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(9);

        String name = "daduniu";

        int age=21;

        MyImmutableDude myDude = new MyImmutableDude(name, age, arrayList);

        //Lets see whether its copy by field or reference
        System.out.println(name == myDude.getName());
        System.out.println(arrayList == myDude.getMyArrayList());
        //print the ce values
        System.out.println("myDude age:" + myDude.getAge());
        System.out.println("myDude name:" + myDude.getName());
        System.out.println("myDude arraylist:" + myDude.getMyArrayList());

        //change the local variable values
        age = 20;
        name = "gaibian";
        arrayList.add(8);
        //print the values again
        System.out.println("myDude age:" + myDude.getAge());
        System.out.println("myDude name:" + myDude.getName());
        System.out.println("myDude arraylist:" + myDude.getMyArrayList());

        ArrayList<Integer> myList = myDude.getMyArrayList();
        myList.add(8);
        System.out.println("myDude arraylist after adding 8: " + myDude.getMyArrayList());

    }

}
