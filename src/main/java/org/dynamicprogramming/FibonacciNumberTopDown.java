package org.dynamicprogramming;
/*
he Fibonacci numbers, commonly denoted F(n) form a sequence,
 called the Fibonacci sequence, such that each number is the
 sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).
 */
public class FibonacciNumberTopDown {
    public int fib(int n) {
        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        return calculateFibonacci(n,dp);
    }

    private int calculateFibonacci(int n, int[] dp) {
        if(n == 0 || n == 1){
            return dp[n];
        }
        if(dp[n] == 0){
            dp[n] = calculateFibonacci(n - 1, dp) + calculateFibonacci(n - 2, dp);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciNumberTopDown fibonacciNumber = new FibonacciNumberTopDown();
        System.out.println(fibonacciNumber.fib(4));
    }
}
