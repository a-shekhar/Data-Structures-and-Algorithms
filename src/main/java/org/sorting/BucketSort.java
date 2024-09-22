package org.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(int[] arr) {
        int numberOfBuket =  (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > maxValue) {
                maxValue = num;
            }
        }

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuket];
        for(int i = 0; i < numberOfBuket; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for(int value : arr){
            int bucketNumber = (int) Math.ceil((float)value * numberOfBuket
            /(float) maxValue);
            buckets[bucketNumber - 1].add(value);
        }
        System.out.println("Printing buckets before sorting:");
        printBuckets(buckets);

        for(ArrayList<Integer> bucket : buckets){
            Collections.sort(bucket);
        }

        System.out.println("Printing buckets after sorting:");
        printBuckets(buckets);

        int index  = 0 ;
        for(ArrayList<Integer> bucket : buckets){
            for(int value : bucket){
                arr[index] = value;
                index++;
            }
        }
        printArray(arr);
    }

    // Print Buckets
    public static void printBuckets(ArrayList<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("Bucket Number " + i + ":");
            for (int j = 0; j < buckets[i].size(); j++){
                System.out.print(buckets[i].get(j) + " ");
            }
            System.out.println();
        }
    }


    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
      //  System.out.println("Original array:");
        BucketSort bucketSort = new BucketSort();
        //bucketSort.printArray(arr);
        bucketSort.bucketSort(arr);
      //  System.out.println("\nSorted array:");
      //  bucketSort.printArray(arr);
    }
}
