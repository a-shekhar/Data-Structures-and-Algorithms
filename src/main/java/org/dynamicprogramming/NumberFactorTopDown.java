package org.dynamicprogramming;

/* Given Number N, find the number of ways to express as sum of 1, 3, 4.

For example
Input: 6
output: 3
 */
public class NumberFactorTopDown {
    public static int countWays(int n) {
        int[] dp = new int[101];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        return countWaysTopDown(n, dp);
    }

    public static int countWaysTopDown(int n, int[] dp) {
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = countWaysTopDown(n - 1, dp) + countWaysTopDown(n - 3, dp) + countWaysTopDown(n - 4, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(3));
        System.out.println(countWays(4));
        System.out.println(countWays(5));
        System.out.println(countWays(6));
    }
}
