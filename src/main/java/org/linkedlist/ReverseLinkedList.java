package org.linkedlist;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
LeetCode-206
*/
public class ReverseLinkedList {
   public  ListNode reverseList(ListNode head) {
        // code here
       if(head == null){
           return null;
       }
       if(head.next == null){
           return head;
       }
       ListNode prev = null;
       ListNode curr = head;
       while(curr!=null){
           ListNode nextNode = curr.next;
           curr.next = prev;
           prev = curr;
           curr = nextNode;
       }
       return prev;
    }
}
