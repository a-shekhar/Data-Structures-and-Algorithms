package org.doublylinkedlist;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        DoublyListNode head = linkedList.createLinkedList(1);
        System.out.println("Created node is: " + head.val);

        linkedList.traverse();

        linkedList.insertAtPosition(0, 0);

        linkedList.traverse();

        linkedList.insertAtPosition(5, 5);

        linkedList.traverse();

        linkedList.insertAtPosition(2, 2);

        linkedList.traverse();

        linkedList.insertAtPosition(3, 3);

        linkedList.traverse();

        linkedList.insertAtPosition(-1, 0);

        linkedList.traverse();

        linkedList.backwardTraverse();

        linkedList.search(5);

        linkedList.search(4);

        linkedList.deleteAtPosition(0);

        linkedList.traverse();

        linkedList.backwardTraverse();

        linkedList.deleteAtPosition(4);
       
        linkedList.traverse();

        linkedList.backwardTraverse();

         linkedList.deleteAtPosition(2);

        linkedList.traverse();

        linkedList.backwardTraverse();

    }
}
