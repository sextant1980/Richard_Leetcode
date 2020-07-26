package com.multipleInterface;

import java.util.Iterator;
import java.util.PriorityQueue;

public class UnderstandCollectionInherit {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(1);
        pq.add(9);
        pq.add(3);

        Iterator iterator = pq.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
