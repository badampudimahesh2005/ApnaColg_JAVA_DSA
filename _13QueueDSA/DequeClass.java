package QueueDSA;

import java.util.*;


public class DequeClass {

    public static void main(String[] args) {
        
        Deque<Integer> deque = new LinkedList<>();

        
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);

        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        System.out.println(deque);

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());

        System.out.println(deque);

    }    
}
