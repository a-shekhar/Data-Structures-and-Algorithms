package org.divideandconquer;
/* Number of paths to reach the last cell with given cost */
public class PathsToReachLastCell {
    public static int pathsToReachLastCell(int[][] arr, int cost){
        return pathsToReachLastCell(arr,
                arr.length-1, arr[0].length-1, cost);
    }

    public static int pathsToReachLastCell(int[][] arr, int row, int col, int cost){
        if(cost < 0){
            return 0;
        }
        if(row == 0 && col == 0){
            return cost - arr[row][col] == 0 ? 1 : 0;
        }
        if(row == 0){
            return pathsToReachLastCell(arr, 0, col-1, cost-arr[row][col]);
        }

        if(col == 0){
            return pathsToReachLastCell(arr, row-1, 0, cost-arr[row][col]);
        }
        int noOfPaths1 = pathsToReachLastCell(arr, row-1, col, cost-arr[row][col]);
        int noOfPaths2 = pathsToReachLastCell(arr, row, col-1, cost-arr[row][col]);
        return noOfPaths1 + noOfPaths2;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {4, 7, 1, 6},
                {5, 7, 3, 9},
                {3, 2, 1, 2},
                {7, 1, 6, 3}
        };
        int target = 25;
        System.out.println("No of paths to reach " + pathsToReachLastCell(arr, target));
    }
}
