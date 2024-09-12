package org.queues;

import java.util.Arrays;

/* Design Circular Queue using array */
public class MyCircularQueue {

    int[] arr;
    int front;
    int rear;
    int size;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
        size = k;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }else if(isEmpty()){
            front = 0;
            rear++;
            arr[rear] = value;
        }else if(rear == size - 1){
            arr[0] = value;
        }else{
            rear++;
            arr[rear] = value;
        }
        System.out.println(Arrays.toString(arr));
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }else if(front == size-1){
            arr[front] = 0;
            front = (front + 1) % size;
        }else{
            arr[front] = 0;
            front++;
        }
        System.out.println("Ad");
        System.out.println(Arrays.toString(arr));
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return arr[rear];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println("Empty queue: " + circularQueue.isEmpty());
        System.out.println("Full queue: " + circularQueue.isFull());
        System.out.println("Added: " + circularQueue.enQueue(1)); // return true
        System.out.println("Empty queue: " + circularQueue.isEmpty());
        System.out.println("Added: " + circularQueue.enQueue(2)); // return true
        System.out.println("Added: " + circularQueue.enQueue(3)); // return true
        System.out.println("Added: " + circularQueue.enQueue(4));
        System.out.println("Full queue: " + circularQueue.isFull());// return false, the queue is full
        System.out.println("Rear: " + circularQueue.Rear());    // return 3
        System.out.println("is full: " + circularQueue.isFull()); // return true
        System.out.println("Removed: " + circularQueue.deQueue()); // return true
        System.out.println("Added: " + circularQueue.enQueue(4)); // return true
        System.out.println("Removed: " + circularQueue.deQueue()); // return false, the queue is full
        System.out.println("Rear: " + circularQueue.Rear());    // return 4
        System.out.println("Front: " + circularQueue.Front());   // return 2
    }
}
