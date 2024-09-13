package org.linkedlist;

// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}

    public ListNode(int x) {
         val = x;
          next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

