package org.recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given an array arr[], check whether it is sorted in non-decreasing order.
Return true if it is sorted otherwise false.
*/
public class SortedArray {
    public static boolean arraySortedOrNot(int[] arr) {
        if(arr.length == 1){
            return true;
        }
        return arr[0] < arr[1]
                && arraySortedOrNot(Arrays.copyOfRange(arr,1, arr.length));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(arraySortedOrNot(arr));
        int[] arr2 = new int[]{1, 3, 2, 4};
        System.out.println(arraySortedOrNot(arr2));
    }
}
