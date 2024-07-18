package org.recursion;
/* Given two positive integers a and b, find GCD of a and b. */
public class GCDOfTwoNumbers {
    public static int gcd(int a, int b) {
        // code here
        if(b==0){
            return a;
        }
        System.out.println(b);
        if(a % b == 0){
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 24, b = 36;
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b)); // Output: 12
    }
}
