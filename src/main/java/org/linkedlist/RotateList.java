package org.linkedlist;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        int size = 0;
        ListNode currentNode = head;
        ListNode tail = new ListNode();
        while(currentNode != null){
            tail = currentNode;
            currentNode = currentNode.next;
            size++;
        }
        System.out.println("tail: " + tail.val);
        System.out.println("size " + size);
        k = k % size;
        //System.out.print(k);
        int rotate = 0;
        ListNode prevNode;
        while (rotate < k) {
            currentNode = head;
            prevNode = new ListNode();
            while(currentNode != tail) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            tail.next = head;
            head = tail;
            prevNode.next = null;
            tail = prevNode;
            rotate++;
        }
        return head;
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        ListNode result = rotateList.rotateRight(head, 3);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
