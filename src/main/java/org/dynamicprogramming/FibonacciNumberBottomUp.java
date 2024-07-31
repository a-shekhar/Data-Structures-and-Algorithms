package org.dynamicprogramming;
/*
he Fibonacci numbers, commonly denoted F(n) form a sequence,
 called the Fibonacci sequence, such that each number is the
 sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).
 */
public class FibonacciNumberBottomUp {
    public int fib(int n) {
        int[] dp = new int[31];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciNumberBottomUp fibonacciNumber = new FibonacciNumberBottomUp();
        System.out.println(fibonacciNumber.fib(4));
    }
}
