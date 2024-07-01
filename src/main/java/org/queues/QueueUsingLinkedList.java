package org.queues;

import org.linkedlist.ListNode;

/*
Implement a Queue using Linked List.
 */
public class QueueUsingLinkedList {
    //Function to push an element into the queue.
    ListNode front = null;
    ListNode rear = null;
    int length = 0;

    void push(int a) {
        ListNode temp = new ListNode(a);
        // Your code here
        if(front == null){
            front = temp;
            rear = temp;
        }else{
            rear.next = temp;
            rear = temp;
        }
        length++;
    }

    //Function to pop front element from the queue.
    int pop() {
        // Your code here
        if(front == null){
            return -1;
        }
        int poppedItem = front.val;
        front = front.next;
        length--;
        return poppedItem;
    }

    private int size(){
        return length;
    }

    private boolean isEmpty(){
        return front == null;
    }

    @Override
    public String toString() {
        return "QueueUsingLinkedList{" +
                "front=" + front +
                ", rear=" + rear +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        queue.pop();
        System.out.println(queue);
        queue.pop();
        queue.pop();
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue);
    }
}
