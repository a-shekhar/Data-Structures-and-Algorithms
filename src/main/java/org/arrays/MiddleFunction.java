package org.arrays;
/*
Write a function called middle that takes an array and returns a new array that contains all but the first and last elements.

myArray = [1, 2, 3, 4]
middle(myArray)  # [2,3].
 */
public class MiddleFunction {
    public static int[] middle(int[] array) {
        if (array.length <= 2) {
            return new int[0]; // Return an empty array if the input array has 2 or fewer elements
        }

        int[] resultArray = new int[array.length-2];
        int j = 0;
        for(int i = 1; i < array.length-1; i++){
            resultArray[j] = array[i];
            j++;
        }
        return resultArray;
    }
}
