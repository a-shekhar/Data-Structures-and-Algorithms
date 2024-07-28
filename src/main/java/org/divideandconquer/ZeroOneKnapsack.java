package org.divideandconquer;

/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).
 */
public class ZeroOneKnapsack {

    static int minKnapSack(int weight, int[] weights, int[] values, int index) {
        if(weight <= 0 || index >= weights.length){
            return 0;
        }
        int profit1 = 0;
        if (weights[index] <= weight) {
            profit1 += values[index] + minKnapSack(weight-weights[index], weights, values, index+1);
        }
        int profit2 = minKnapSack(weight, weights, values, index+1);
        return Math.max(profit1, profit2);
    }

    static int knapSack(int weight, int weights[], int values[], int n) {
        // your code here
        return minKnapSack(weight, weights, values, 0);
    }
}
