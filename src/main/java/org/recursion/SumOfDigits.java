package org.recursion;

/* Given a number, N. Find the sum of all the digits of N */
public class SumOfDigits {
    static int sumOfDigits(int n) {
        // code here
        if(n == 0){
            return 0;
        }
        return (n%10) + sumOfDigits(n/10);
    }

    public static void main(String[] args) {
        int num = 12345;
        System.out.println("Sum of digits: " + sumOfDigits(num));  // Output: 15
    }
}
