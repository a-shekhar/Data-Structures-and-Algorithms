package org.recursion;

/* You are given a string s. You need to reverse the string. */
public class ReverseString {
    public static String reverseWord(String str) {
        // Reverse the string str
        if(str.isEmpty()){
            return "";
        }
        return str.charAt(str.length() - 1) +
                reverseWord(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        String s = "Hello, World!";
        System.out.println("Reversed string: " + reverseWord(s)); // Output: "!dlroW,olleH"
    }
}
