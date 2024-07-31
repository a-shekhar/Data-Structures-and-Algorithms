package org.divideandconquer;

/* Write a function called findRotatedIndex which accepts a rotated array
of sorted numbers and an integer. The function should return the index of
the integer in the array. If the value is not found, return -1.
*/
public class RotatedIndex {
    public static int findRotatedIndex(int[] arr, int num) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2};
        int num = 4;
        int index = findRotatedIndex(arr, num);
        System.out.println("Index of " + num + ": " + index);
    }
}
