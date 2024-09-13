package org.linkedlist;
/* Given a singly linked list and an integer, x. Delete the xth node (1-based indexing) from the singly linked list. */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int x) {
        if (head == null){
            return null;
        }

        if(x == 1){
            return head.next;
        }

        int i = 1;
        ListNode currentNode = head;
        ListNode prevNode = new ListNode();

        while(i < x){
            prevNode = currentNode;
            currentNode = currentNode.next;
            i++;
        }
        ListNode nodeTobeRemoved = currentNode;
        prevNode.next = currentNode.next;
        currentNode.next = null;
        return nodeTobeRemoved;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        DeleteNode deleteNode = new DeleteNode();
        ListNode result = deleteNode.deleteNode(head, 2);
        System.out.println(result); // Output: 1 -> 2 -> 3 -> 4 -> 5
    }
}
