package org.sorting;

import java.util.Arrays;

public class BubbleSort {
    static int count =0;
    public static void bubbleSort(int[] arr) {

        int n = arr.length;
        boolean sorted = false;
        for(int i = 0; i < n-1; i++) {
            sorted = true;
            // some uses n-i-1 also for end
            for(int j = 0; j < n-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    sorted = false;
                }
            }
            count++;
            if(sorted) {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        System.out.println(count);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 2, 1, 9, 4, 6, 7};
        bubbleSort(arr);
        printArray(arr);
    }
}
