package org.recursion;

/* Given a string find its first uppercase letter */
public class FirstUppercase {
    public static char firstLetter(String str){
        if(str.isEmpty()){
            return '\0';
        }
        if(Character.isUpperCase(str.charAt(0))){
            return str.charAt(0);
        }
        return firstLetter(str.substring(1));
    }

    public static void main(String[] args) {
        String str = "aditya Raj Hello World!";
        System.out.println("First uppercase letter: " + firstLetter(str)); // Output: H
    }
}
