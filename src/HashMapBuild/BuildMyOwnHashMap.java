package HashMapBuild;

import java.util.Arrays;
import java.util.HashMap;

public class BuildMyOwnHashMap {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        MyMap map = new MyMapImpl();
        map.put(1, "hello1");
        System.out.println(map);
        map.put(2, "hello2");
        System.out.println(map);
        map.put(3, "hello3");
        System.out.println(map);
        map.put(3, "hello33");
        System.out.println(map);
        map.put(19, "hello19");
        System.out.println(map);
        map.put(19, "hello119");
        System.out.println(map);
        System.out.println(map.get(3)); // hello33
        System.out.println(map.get(19)); // hello119
    }
}

interface MyMap {
    Object get(Object key);
    void put(Object key, Object value);
    int size();
}

class MyMapImpl implements MyMap {

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

    Node[] table = new Node[16];;
    int size;
    static final int CAPACITY = 16;

    public MyMapImpl() {

    }

    @Override
    public Object get(Object key) {
        int index = key.hashCode() % CAPACITY;
        Node bucket = table[index];
        if(bucket == null) {
            return null;
        } else {
            // iterate node list. find key.equals(current key), return value
            Node head = bucket;
            while(head != null) {
                if (head.key.equals(key) && key.hashCode() == head.key.hashCode()) {
                    return head.value;
                }
                head = head.next;
            }
        }
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        int index = key.hashCode() % CAPACITY;
        Node bucket = table[index];
        if(bucket == null) {
            table[index] = new Node(key, key.hashCode(), value, null);
            size++;
        } else {
            // iterate node list. find existing key or insert new Node to the end
            Node head = bucket;
            while(true) {
                if(head.key.equals(key) && head.hashCode == key.hashCode()) {
                    head.value = value;
                    return;
                }
                if(head.next == null) {
                    break;
                }
                head = head.next;
            }
            head.next = new Node(key, key.hashCode(), value, null);
            size++;
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyMapImpl{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                '}';
    }
}