package org.arrays;

/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = temp;
        }
    }
}
