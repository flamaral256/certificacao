package cap3.collection;

import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

public class TestQueue {
  public static void main(String[] args) {
    // Queue add the power to insert objects in a specific order into the collection (front and back).
    // They differ from Lists in the fact of lists may add in whatever index you choose and Queues
    // are more specif. For example, FIFO you always add at the back of queue, LIFO you always add
    // at the front of queue. In fact you can add in front for FIFO and back for LIFO as well when you
    // are working with a Deque, or a priority queue. But even this way you are adding in a specific order.
    // You cant for example add some object in the middle of the queue passing the index of what you want.
    // There is an order here to insert and remove elements of this kind of collection.
    // In the case of LinkedList that is a List and is also a Queue, you can insert and remove in any order.

    // FIFO
    Queue<Integer> queue = new ArrayDeque<>();
    System.out.println(queue.peek()); // return null because there is nothing there. thats why we cant add null to queues
    System.out.println(queue.offer(1)); // return true ---- 1 (the same method add but this doesnt throw exception)
    System.out.println(queue.offer(3)); // return true ---- 1, 3
    System.out.println(queue.offer(5)); // return true ---- 1, 3, 5
    System.out.println(queue.peek()); // return next element to be removed 1 (the same method element but this doesnt throw exception)
    System.out.println(queue.poll()); // remove and return next element 1 (the same method remove but this doesnt throw exception)
    System.out.println(queue); // 3, 5

    // LIFO
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(2); // push return void ----- 2 (the same method add but this doesnt throw exception)
    stack.push(4); // push return void ----- 4, 2
    stack.push(6); // push return void ----- 6, 4, 2
    System.out.println(stack.peek()); // return next element to be removed 6 (the same method element but this doesnt throw exception)
    System.out.println(stack.poll()); // remove and return next element 1 (the same method remove/pop but this doesnt throw exception)
    System.out.println(stack); // 4, 2
  }
}
