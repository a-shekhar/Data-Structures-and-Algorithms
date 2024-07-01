package org.linkedlist;

/*
How will you check if the linked list is palindrome or not?
Leetcode - 234
*/
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            System.out.println(fast);
            fast = fast.next.next;
        }
        System.out.println("Ad");
        ListNode reversedHalf = reversed(slow);
        System.out.println("reversed list " + reversedHalf);
        slow = head;
        System.out.println("slow list " + slow);
        while (reversedHalf != null){
            if(reversedHalf.val != slow.val){
                return false;  // Not a palindrome if values are not equal.
            }
            slow = slow.next;
            reversedHalf = reversedHalf.next;
        }
        return true;  // Palindrome if all values are equal.
    }

    public ListNode reversed(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }



    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(palindromeLinkedList.isPalindrome(head));
    }
}
