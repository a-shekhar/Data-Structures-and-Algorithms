package org.divideandconquer;
/* Go to first cell to last one with minimum cost */
public class MinCostToReachLastCell {
    public static int minCostToReachLastCell(int[][] arr){
        return minCostToReachLastCell(arr, arr.length-1, arr[0].length-1);
    }

    public static int minCostToReachLastCell(int[][] arr, int row, int col){
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }
        if(row == 0 && col == 0){
            return arr[row][col];
        }
        int minCost1 = minCostToReachLastCell(arr, row-1, col);
        int minCost2 = minCostToReachLastCell(arr, row, col-1);
        return Math.min(minCost1, minCost2) + arr[row][col];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        System.out.println("Minimum cost to reach " + minCostToReachLastCell(arr));
    }
}
