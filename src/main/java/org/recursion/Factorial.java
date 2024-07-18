package org.recursion;
/* Given a positive integer, N. Find the factorial of N. */
public class Factorial {
    static long factorial(int num){
        // code here
        if(num == 0){
            return 1;
        }
        if(num == 1){
            return 1;
        }
        return num * factorial(num-1);
    }
}
