package org.divideandconquer;

/* Given Number N, find the number of ways to express as sum of 1, 3, 4.

For example
Input: 6
output: 3
 */
public class NumberFactor {
    public static int countWays(int n) {
        if (n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(n == 1 || n == 2){
            return 1;
        }

        if(n == 3){
            return 2;
        }

        int sub1 = countWays(n - 1);
        int sub2 = countWays(n - 3);
        int sub3 = countWays(n - 4);
        return sub1 + sub2 + sub3;
    }

    public static void main(String[] args) {
        System.out.println(countWays(3));
        System.out.println(countWays(4));
        System.out.println(countWays(5));
        System.out.println(countWays(6));
    }
}
