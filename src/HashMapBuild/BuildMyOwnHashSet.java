package HashMapBuild;

import java.util.*;

public class BuildMyOwnHashSet {
    public static void main(String[] args) {
        MySetImpl mySet = new MySetImpl();
        mySet.add(1);
        System.out.println(mySet);
        mySet.add(2);
        System.out.println(mySet);
        mySet.add(3);
        System.out.println(mySet);
        mySet.add(19);
        System.out.println(mySet);
        mySet.add(19);
        System.out.println(mySet);
        System.out.println(mySet.size());

        mySet.remove(19);
        System.out.println("size = " + mySet.size() + " and the Set is: " + mySet);
    }
}

interface MySet {
    void add(Object object);
    void remove(Object object);
    int size();
}

class MySetImpl implements MySet {

    class Node {
        Object key;
        int hashCode;
        Object value;
        Node next;

        public Node(Object key, int hashCode, Object value, Node next) {
            this.key = key;
            this.hashCode = hashCode;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", hashCode=" + hashCode +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    int size;
    Node[] table;
    static final int capacity = 16;
    Object dummy = "hello";

    public MySetImpl() {
        table = new Node[capacity];
    }

    @Override
    public void add(Object object) {
        int index = object.hashCode() % capacity;
        Node bucket = table[index];
        if(bucket == null) {
            table[index] = new Node(object, object.hashCode(), dummy, null);
            size++;
        } else {
            while(true) {
                if(bucket.key.equals(object) && bucket.hashCode == object.hashCode()) {
                    return;
                }
                if(bucket.next == null) {
                    break;
                }
                bucket = bucket.next;
            }
            bucket.next = new Node(object, object.hashCode(), dummy, null);
            size++;
        }
    }


    @Override
    public void remove(Object object) {
        int index = object.hashCode() % capacity;
        Node bucket = table[index];
        if(bucket == null) {
            throw new NullPointerException("element to be removed doesn't exit!");
        } else {
            int pp = 0;
            Node previous = null;
            while(bucket != null) {
                if(bucket.key == object && bucket.hashCode == object.hashCode()) {
                    if(pp == 0) {
                        table[index] = bucket.next;
                        size--;
                        return;
                    }
                    if(bucket.next == null) {
                        previous.next = null;
                        size--;
                        return;
                    }
                    previous.next = bucket.next;
                    size--;
                    return;
                }
                previous = bucket;
                bucket = bucket.next;
                pp++;
            }
            throw new NullPointerException("element to be removed doesn't exit!");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MySetImpl{" +
                "size=" + size +
                ", table=" + Arrays.toString(table) +
                ", dummy=" + dummy +
                '}';
    }
}