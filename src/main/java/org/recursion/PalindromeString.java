package org.recursion;

/* Given a string S, check if it is palindrome or not. */
public class PalindromeString {
    public static boolean isPalindrome(String s) {
        // code here
        if(s.isEmpty()){
            return true ;
        }
        if(s.charAt(0) != s.charAt(s.length()-1)){
            return false;
        }
        System.out.println(s.substring(1, s.length()-1));
        return isPalindrome(s.substring(1, s.length()-1));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
    }
}
