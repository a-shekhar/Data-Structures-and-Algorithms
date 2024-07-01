package org.stacks;
/*
Show how to implement one stack efficiently using two queues. Analyze the
running time of the stack operations.
 */

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    Queue<Integer> pushedQueue;
    Queue<Integer> poppedQueue;

    public StackUsingQueues() {
        pushedQueue = new LinkedList<>();
        poppedQueue = new LinkedList<>();
    }


    public void push(int x) {
        pushedQueue.offer(x);
    }

    public int pop() {
        while(pushedQueue.size() > 1){
            poppedQueue.offer(pushedQueue.poll());
        }
        int poppedItem =  pushedQueue.poll();
        while(!poppedQueue.isEmpty()){
            pushedQueue.offer(poppedQueue.poll());
        }
        return poppedItem;
    }

    public int top() {
        while(pushedQueue.size() > 1){
            poppedQueue.offer(pushedQueue.poll());
        }
        int peekedItem = pushedQueue.peek();
        poppedQueue.offer(pushedQueue.poll());
        while(!poppedQueue.isEmpty()){
            pushedQueue.offer(poppedQueue.poll());
        }
        return peekedItem;
    }

    public boolean empty() {
        return pushedQueue.isEmpty() && poppedQueue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);

        System.out.println(stack.top()); // 3

        System.out.println(stack.pop());

        System.out.println(stack.empty()); // true
    }
}
