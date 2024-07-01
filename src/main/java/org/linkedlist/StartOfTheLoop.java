package org.linkedlist;/*
Check whether the given linked list is NULL-terminated or not. If there is a
cycle find the start node of the loop.
LeetCode-142
*/

public class StartOfTheLoop {
    public int countNodesinLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                hasCycle = true;
                break;
            }
        }
        int count = 0;
        if(hasCycle){
            slow = slow.next;
            count++;
            while(slow !=fast ){
                slow = slow.next;
                count++;
            }
            return count;
        }
        return count;
    }
}
