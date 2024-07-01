package org.stacks;

import org.linkedlist.ListNode;

import java.util.Arrays;

class StackUsingLinkedList {
    ListNode top = null;
    ListNode head = null;
    int size;

    public StackUsingLinkedList(){
        head = null;
        size = 0;
    }
    public void push(int value) {
        if(head == null){
            head = new ListNode(value);
        }else{
            ListNode temp = new ListNode(value);
            ListNode curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = temp;
        }
        size++;
        System.out.println("Pushed value: " + value + " at the end of the list");
    }

    public int pop(){
        if(head == null){
            throw new RuntimeException("Stack is empty");
        }
        size--;
        if(head.next == null){
            int value = head.val;
            head = head.next;
            System.out.println("Popped value: " + value);
            return value;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        int value = curr.val;
        prev.next = null;
        System.out.println("Popped value: " + value);
        return value;
    }

    public int peek(){
        if(head == null){
            throw new RuntimeException("Stack is empty");
        }
        return head.val;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public String toString(){
        StringBuffer result = new StringBuffer();
        ListNode curr = head;
        while(curr != null){
            result.append(curr.val + " ");
            curr = curr.next;

        }

        return result.toString();
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Stack size: " + stack.getSize());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Stack size: " + stack.getSize());
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        System.out.println("Stack size: " + stack.getSize());
        stack.push(13);
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
    }
}