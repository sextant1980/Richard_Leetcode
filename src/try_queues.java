import java.util.*;

public class try_queues {

    public static void main(String[] args){

        Deque<Integer> queue = new LinkedList<>();
        queue.push(3);
        queue.push(8);
        queue.push(7);
        queue.push(9);

        System.out.println("the queue is: " + queue);

        int aa = queue.pop();

        System.out.println("the head element: " + aa);
        System.out.println("the queue is: " + queue);

        Deque<Integer> queue2 = new ArrayDeque<>();
        queue2.push(3);
        queue2.push(8);
        queue2.push(7);
        queue2.push(9);

        System.out.println("the queue is: " + queue2);

        int bb = queue2.pop();

        System.out.println("the head element: " + bb);
        System.out.println("the queue is: " + queue2);

    }
}
