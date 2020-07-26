package HashMapBuild;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BuildMyOwnArrayList {
    public static void main(String[] args) {
        MyArrayListImpl myArrayList = new MyArrayListImpl();
        for(int i = 0; i < 15; i++) {
            myArrayList.add(i);
        }
        myArrayList.remove(3);
        System.out.println(myArrayList);
        System.out.println("the size of myArrayList is: " + myArrayList.size());
        System.out.println(myArrayList.get(13));
    }

}

interface MyArrayList {
    void add(Object object);
    void remove(Object object);
    Object get(int index);
    int size();
}

class MyArrayListImpl implements MyArrayList {

    int size;
    Object[] array = new Object[10];

    public MyArrayListImpl() {
    }

    @Override
    public void add(Object object) {
        int indexNull = 0;
        while(array[indexNull] != null) {
            indexNull++;
        }

        if(indexNull > array.length / 2) {
            Object[] tmp = array;
            array = new Object[tmp.length * 2];
            System.arraycopy(tmp, 0, array, 0, tmp.length);
        }

        array[indexNull] = object;
        size++;
    }

    @Override
    public void remove(Object object) {
        boolean foundMatch = false;
        int indexSearch = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == object) {
                foundMatch = true;
                indexSearch = i;
                break;
            }
        }
        if(!foundMatch) {
            throw new NoSuchElementException("no such object in array!");
        } else {
            System.arraycopy(array, indexSearch + 1, array, indexSearch, array.length - 1 - indexSearch - 1 + 1);
            size--;
        }
    }

    @Override
    public Object get(int index) {
        if(index > size - 1) {
            throw new NullPointerException("index out of bound!");
        }
        if(array[index] == null) {
            throw new NullPointerException("no such element in array!");
        }
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyArrayListImpl2{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}

