package org.linkedlist;

/*
Check whether the given Linked List length is even or odd?
*/
public class LengthEvenOrOdd {
    public int isLengthEvenOrOdd(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null){
                return 0; // 0 for even
            }
        }
        return 1; // 1 for odd
    }
}
