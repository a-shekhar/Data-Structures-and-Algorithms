package org.divideandconquer;

/* Given an array arr of only 0's and 1's. The array is sorted in such
 a manner that all the 1's are placed first and then
 they are followed by all the 0's. Find the count of all the 0's.
 */
public class CountZeros {
    int countZeroes(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
           mid = (low + high)/2;
           if(arr[mid] == 1){
               low = mid + 1;
           }else{
               high = mid -1;
           }
        }
        return arr.length - low;
    }

    public static void main(String[] args) {
        CountZeros countZeros = new CountZeros();
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println("Count of 0s: " + countZeros.countZeroes(arr)); // Output: 3
    }
}
