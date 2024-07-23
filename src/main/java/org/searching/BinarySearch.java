package org.searching;
/* Given an sorted array, find the index of the value given */
public class BinarySearch {
    public static int search(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while(low <= high) {
            mid = (low + high) /2;
            if(arr[mid] == value) {
                return mid;
            }else if(arr[mid] < value) {
                low = mid + 1;
            }else{
                high = mid - 1;  // value is in the left half of the array
            }
        }
        return -1; // value not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int value = 9;
        int index = search(arr, value);
        if(index != -1) {
            System.out.println("Value found at index: " + index);
        } else {
            System.out.println("Value not found in the array.");
        }
    }
}
