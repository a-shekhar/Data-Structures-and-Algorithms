package org.circularlinkedlist;

import org.linkedlist.ListNode;

public class CircularLinkedList {
    public ListNode head;
    public ListNode tail;
    public int size;

    public CircularLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public ListNode createLinkedList(int value){
        ListNode newNode = new ListNode(value);
        head = newNode;
        tail = newNode;
        tail.next = head;
        size = 1;
        return head;
    }

    public void insertAtPosition(int value, int index){
        if(index < 0){
            System.out.println("Invalid index");
            return;
        }

        if(head ==  null){
            this.createLinkedList(value);
            return;
        }

        ListNode newNode = new ListNode(value);
        if(index == 0){
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }else if(index >= size){
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        } else {
            ListNode curr = head;
            for(int i = 0; i < index-1; i++){
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next = newNode;
        }

        size++;
    }

    public void traverse(){
        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }
        ListNode curr = head;
        for(int i = 1; i <= size; i++){
            System.out.print(curr.val);
            if(i != size){
                System.out.print(" -> ");
            }
            curr = curr.next;
        }

        System.out.println();
    }

    public void search(int value){
        if(head == null){
            System.out.println("Empty LinkedList");
            return;
        } 

        ListNode curr = head;
        for(int i = 0; i < size; i++){
            if(curr.val == value){
                System.out.println("Value found at index: " + i);
                return;
            }
            curr = curr.next;
        }

        System.out.println("Value not found in linked list...");
    }

    public void deleteAtPosition(int index){
     
        if(head == null){
            System.out.println("Empty Linked List");
            return;
        }

        if(index < 0 || index >= size){
            System.out.println("invalid index to remove node ");
            return;
        }

        if(index == 0){
            if(size == 1){
                head = null;
                tail = null;
                size = 0;
            }else{
                head = head.next;
                tail.next = head;
                size--;
            }
        } else if(index == size-1){
            ListNode curr = head;
            for(int i = 0; i < size - 2; i++){
                curr = curr.next;
            }
            tail = curr;
            tail.next = head;
            size--;
        } else {
            ListNode curr = head;
            for(int i = 0; i < index - 1; i++){
                curr = curr.next;
            }
            curr.next = curr.next.next;
            size--;
        }
    }

    
}
