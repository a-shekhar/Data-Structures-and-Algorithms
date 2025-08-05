package org.circularlinkedlist;

import org.linkedlist.ListNode;

public class CircularLinkedListTest {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        
        circularLinkedList.traverse();

        ListNode head = circularLinkedList.createLinkedList(1);
        System.out.println("Created Node is " + head.val);
        System.out.println("Created Node tail is  " + head.next.val);

        circularLinkedList.insertAtPosition(2, 0);

        circularLinkedList.traverse();

        circularLinkedList.insertAtPosition(3, 5);

        circularLinkedList.traverse();

        circularLinkedList.insertAtPosition(4, 1);

        circularLinkedList.traverse();

        circularLinkedList.insertAtPosition(5, -1);

        circularLinkedList.traverse();

        circularLinkedList.search(4);

        circularLinkedList.search(5);

        circularLinkedList.deleteAtPosition(2);

        circularLinkedList.traverse();

        circularLinkedList.deleteAtPosition(0);

        circularLinkedList.traverse();

        circularLinkedList.deleteAtPosition(1);

        circularLinkedList.traverse();
    }
}
