package org.searching;
/* Given an array, find the index of the value given */
public class LinearSearch {
    public static int search(int[] arr, int value) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return -1; // value not found
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
