package HashMapBuild;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BuildMyOwnLinkedList {
    public static void main(String[] args) {
        MyLinkedListImpl myLinkedList = new MyLinkedListImpl();
        for(int i = 0; i < 10; i++) {
            myLinkedList.addEnd(i);
        }
        myLinkedList.display();



        myLinkedList.addMid(9, 100);
        myLinkedList.display();

        myLinkedList.remove(1);
        myLinkedList.display();

        System.out.println("get value at index 5: " + myLinkedList.get(5));
    }
}

interface MyLinkedList {
    void addFront(Object object);
    void addEnd(Object object);
    void addMid(int index, Object object);
    void remove(int index);
    Object get(int index);
    int size();
}

class MyLinkedListImpl implements MyLinkedList {

    class Node {
        Node before;
        Object value;
        Node after;

        public Node(Object value) {
            this.value = value;
        }

        public Node(Node before, Object value, Node after) {
            this.before = before;
            this.value = value;
            this.after = after;
        }

        @Override
        public String toString() {
            return "Node{value=" + value + "}";
        }
    }

    int size;
    Node node = null;

    @Override
    public void addFront(Object object) {
        if(node == null) {
            node = new Node(object);
        } else {
            node = new Node(null, object, node);
            node.after.before = node;
        }
        size++;
    }

    @Override
    public void addEnd(Object object) {
        if(node == null) {
            node = new Node(object);
        } else {
            Node tmp = node;
            while(tmp.after != null) {
                tmp = tmp.after;
            }
            tmp.after = new Node(tmp, object, null);;
        }
        size++;
    }

    @Override
    public void addMid(int index, Object object) {
        if(index > size) {
            throw new IndexOutOfBoundsException("index out of bound!");
        }

        if(index == 0) {
            addFront(object);
        } else if(index == size) {
            addEnd(object);
        } else {
            Node tmp = node;
            for(int i = 0; i < index; i++) {
                tmp = tmp.after;
            }
            Node newNode = new Node(tmp.before, object, tmp);
            tmp.before.after = newNode;
            tmp.before = newNode;
            size++;
        }

    }

    @Override
    public void remove(int index) {
        if(index > size - 1) {
            throw new IndexOutOfBoundsException("index out of bound!");
        }

        if(index == 0) {
            node = node.after;
            node.before = null;
        } else if(index == size - 1) {
            Node tmp = node;
            while(tmp.after != null) {
                tmp = tmp.after;
            }
            tmp = null;
        } else {
            Node tmp = node;
            for (int i = 0; i < index; i++) {
                tmp = tmp.after;
            }
            tmp.before.after = tmp.after;
            tmp.after.before = tmp.before;
        }
        size--;
    }

    @Override
    public Object get(int index) {
        if(index > size - 1) {
            throw new IndexOutOfBoundsException("index out of bound!");
        }

        Node tmp = node;
        for(int i = 0; i < index; i++) {
            tmp = tmp.after;
        }
        return tmp.value;
    }

    @Override
    public int size() {
        return size;
    }

    public void display() {
        Object[] tmp = new Object[size];
        Node head = node;
        for(int i = 0; i < size; i++) {
            tmp[i] = head.value;
            head = head.after;
        }
        System.out.println(Arrays.toString(tmp));
    }

}