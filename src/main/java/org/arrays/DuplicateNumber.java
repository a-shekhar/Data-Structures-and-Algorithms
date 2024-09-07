package org.arrays;

import java.util.Arrays;

/*
Write a function which takes integer array as a parameter and returns a new integer array with unique elements. (remove duplicates)

Example

removeDuplicates({1, 1, 2, 2, 3, 4, 5})
Output : [1, 2, 3, 4, 5]
 */
public class DuplicateNumber {
    public static int[] removeDuplicates(int[] arr) {
        Arrays.sort(arr);
        int[] uniqueArray = new int[arr.length];
        int index = 0;
        boolean isDuplicate = false;
        for (int i = 0; i < arr.length; i++){
            isDuplicate = false;
            for(int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if(!isDuplicate){
                uniqueArray[index] = arr[i];
                index++;
            }
        }

        return Arrays.copyOf(uniqueArray, index);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 5};
        int[] uniqueArray = removeDuplicates(arr);
        System.out.println(Arrays.toString(uniqueArray)); // Output: [1, 2, 3, 4, 5]
    }
}
