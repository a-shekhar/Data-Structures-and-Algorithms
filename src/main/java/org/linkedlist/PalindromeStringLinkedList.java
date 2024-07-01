package org.linkedlist;/*
Given	an	array	of	characters	formed	with	a’s	and	b’s.	The	string	is	marked	with
 special	character	X	which	represents	the	middle	of	the	list	(for	example:
 ababa...ababXbabab…..baaa).	Check	whether	the	string	is	palindrome.
 */

import org.stacks.PalindromeStringStack;

import java.util.Stack;


public class PalindromeStringLinkedList {

    public boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int n = s.length();
        for(i = 0; i < n ; i++){
            if(s.charAt(i) == 'X'){
                i++; // skip that index
                break;
            }
            stack.push(s.charAt(i));
        }
        while(i < n){
            if(!stack.isEmpty() && stack.peek() !=  s.charAt(i)){
                return false;
            } else if (!stack.isEmpty() && stack.peek() ==  s.charAt(i)) {
                stack.pop();
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeStringStack palindromeString = new PalindromeStringStack();
        System.out.println(palindromeString.isPalindrome("abXba"));
        System.out.println(palindromeString.isPalindrome("abbaXabba"));
        System.out.println(palindromeString.isPalindrome("abbaXbaba"));
        System.out.println(palindromeString.isPalindrome("abcXcba"));
        System.out.println(palindromeString.isPalindrome("abcXabc"));
    }
}
