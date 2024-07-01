package org.linkedlist;
/*
Check whether the given linked list is either NULL-terminated or ends in a cycle
(cyclic)
LeetCode-141
*/

public class DetectCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
