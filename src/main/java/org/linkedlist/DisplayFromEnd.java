package org.linkedlist;

/*
How will you display a linked list from the end?
*/
public class DisplayFromEnd {
    public void printLinkedListFromEnd(ListNode head){
        if(head == null){
            return;
        }
        printLinkedListFromEnd(head.next);
        System.out.println(head.val);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        DisplayFromEnd displayFromEnd = new DisplayFromEnd();
        displayFromEnd.printLinkedListFromEnd(head);
    }
}
