package org.searching;
/* Given an sorted array, find the index of the value given */
public class BinarySearchRecursion {
    public static int search(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        return binarySearch(arr, value, low, high);
    }

    public static int binarySearch(int[] arr, int value, int low, int high) {
       if(low > high){
           return -1; // value not found in the array  // base case: array is empty or value is not in the array.

       }
        int mid = (low + high) /2;
        if(arr[mid] == value) {
                return mid;
        }
        if(arr[mid] < value) {
            return binarySearch(arr, value, mid+1, high);
            }else{
            return binarySearch(arr, value, low, mid-1);  // value is in the left half of the array
            }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int value = 10;
        int index = search(arr, value);
        if(index != -1) {
            System.out.println("Value found at index: " + index);
        } else {
            System.out.println("Value not found in the array.");
        }
    }
}
