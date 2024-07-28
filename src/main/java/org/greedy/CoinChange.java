package org.greedy;

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
 */

// works only if  highest value that doesn't exceed the remaining amount to be changed
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // sort the coins
        Arrays.sort(coins);
        int index = coins.length -1;
        int coinCount = 0;
        while(true){

            //  get the max coin value
            int coinValue = coins[index];
            // get the max count of coin Of same denominations
            int coinOfSameDenominations  = (amount/coinValue);
            // update the count of coins and remaining amount
            coinCount += coinOfSameDenominations;
            amount -= (coinOfSameDenominations) * coinValue;
            // check for another index
            index--;
            System.out.println("Coin count " + coinCount +
                    " amount " + amount + " coin value " + coinValue);
            if(amount == 0){
                return coinCount;
            }

            if(index < 0){
                break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins,11));
    }
}








