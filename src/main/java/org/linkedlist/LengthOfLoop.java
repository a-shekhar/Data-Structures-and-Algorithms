package org.linkedlist;
/*
 Given a linked list of size N. The task is to complete the function countNodesinLoop()
 that checks whether a given Linked List contains a loop or not and
 if the loop is present then return the count of nodes in a loop or else return 0.
 C is the position of the node to which the last node is connected.
 If it is 0 then no loop.
*/
public class LengthOfLoop {
    static int countNodesInLoop(ListNode head)
    {
        //Add your code here.
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
