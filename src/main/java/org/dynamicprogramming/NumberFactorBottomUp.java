package org.dynamicprogramming;

/* Given Number N, find the number of ways to express as sum of 1, 3, 4.

For example
Input: 6
output: 3
 */
public class NumberFactorBottomUp {

    public static int countWays(int n) {
        int[] dp = new int[101];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for(int i = 4; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
        }
        return dp[n];
    }



    public static void main(String[] args) {
        System.out.println(countWays(3));
        System.out.println(countWays(4));
        System.out.println(countWays(5));
        System.out.println(countWays(6));
    }
}
