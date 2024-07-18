package org.recursion;
/* Given a decimal number N, compute its binary equivalent. */
public class DecimalToBinary {
    public static String toBinary(int n) {
        //Write your code here
        if(n < 0){
            return "-1";
        }
        if(n == 0){
            return "";
        }
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        System.out.println(toBinary(5));
        System.out.println(toBinary(-3));
        System.out.println(toBinary(15));
        System.out.println(toBinary(32));
    }
}
