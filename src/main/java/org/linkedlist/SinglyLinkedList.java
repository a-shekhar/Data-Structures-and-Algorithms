package org.linkedlist;

import java.util.LinkedList;

// basic operations
public class SinglyLinkedList {
    static ListNode insertNodeAtHead(ListNode head, int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
        return head;
    }

    // Function to insert a node at the end of the linked list.
    ListNode insertAtEnd(ListNode head, int x) {
        ListNode node = new ListNode(x);
        if(head == null){
            return node;
        }

        ListNode currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }

        currentNode.next = node;
        return head;
    }

    public ListNode insertInMiddle(ListNode head, int x) {
        ListNode newNode = new ListNode(x);
        if(head == null || head.next == null){
            return newNode;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        newNode.next = slow.next;
        slow.next = newNode;
        return head;
    }

    static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

        static boolean searchKey(ListNode head, int key) {
            // Code here
            while(head != null){
                if(head.val == key){
                    return true;
                }
                head = head.next;
            }
            return false;
        }

        /*
Given the head of a Singly Linked List and an index number k, The task is to find the node at the given index (k)(1-based index) of the linked list.
If no such node exists whose index is k then return -1.
         */
    public int GetNth(ListNode head, int index) {
        if (head == null){
            return -1;
        }
        int count = 0;
        while(head != null){
            count++;
            if(count == index){
                return head.val;
            }
            head = head.next;
        }
        return -1;
    }
    

}
