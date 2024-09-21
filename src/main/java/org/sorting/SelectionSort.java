package org.sorting;

public class SelectionSort {

    public static int[] selectionSort(int[] arr){
        int n = arr.length;
        int minimumIndex;
        for(int i = 0; i < n; i++){
            minimumIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[minimumIndex] > arr[j]){
                    minimumIndex = j;
                }
            }

            if(minimumIndex != i){
                int temp = arr[i];
                arr[i] = arr[minimumIndex];
                arr[minimumIndex] = temp;
            }
        }
        return arr;
    }

    private static void printArray(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr);

        arr = selectionSort(arr);
        System.out.println("\nSorted array:");
        printArray(arr);
    }

}
