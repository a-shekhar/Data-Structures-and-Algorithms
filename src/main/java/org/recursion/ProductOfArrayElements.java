package org.recursion;

/*
Given an array, arr[] of positive integers.
Your task is to return the product of array elements
 under the given modulo, mod with the value of 1000000007.
 */
public class ProductOfArrayElements {
    public static long product(int[] arr, int n) {
        // your code here
        if(n == 1){
            return arr[0];
        }
        return (arr[n-1] * product(arr, n-1)) % 1000000007;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, -1, 2};
        int n = arr.length;
        System.out.println("Product of array elements: " + product(arr, n)); // Output: 120
    }
}
