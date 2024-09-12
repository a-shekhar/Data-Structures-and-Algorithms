package org.queues;

import java.util.Arrays;

/* Implement a Queue using an Array. */
public class QueueUsingArray {
    int front, rear;
    int[] arr = new int[3];

    public QueueUsingArray() {
        front = -1;
        rear = -1;
    }

    //Function to push an element x in a queue.
    void push(int value) {
        // Your code here
        if(rear < arr.length-1){
            rear++;
            if(rear == 0){
                front = 0;
            }
            arr[rear] = value;
            System.out.println("Queue after adding " + value + " is "
                        + Arrays.toString(arr));
        }else{
            System.out.println("Queue is full. Cannot push " + value);
        }
    }

    //Function to pop an element from queue and return that element.
    public int pop(){
        // Your code here
        if(front == -1 || front > rear){
            return -1;
        }

        int poppedItem = arr[front];
        front++;
        return poppedItem;
    }

    //Function to check if queue is empty or not.
    public boolean isEmpty(){
        return (front == -1);
    }

    //Function to check if queue is full or not.
    public boolean isFull(){
        return (rear == arr.length-1);
    }

    //Function to get the front element of the queue.
    public int peek(){
        if(front == -1)
            return -1;
        return arr[front];
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray();
        queue.push(1);
        queue.push(2);
        //queue.push(3);
        //queue.push(4);
        System.out.println("Popped element is " + queue.pop());
        System.out.println("Popped element is " + queue.pop());
        System.out.println("Popped element is " + queue.pop());
        System.out.println("Popped element is " + queue.pop());
    }
}
