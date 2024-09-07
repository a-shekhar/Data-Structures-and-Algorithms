package org.arrays;

/* Write a program to check if an array contains a number in Java.
int[] intArray = {1,2,3,4,5,6};
searchInArray(intArray, 6); // 5
 */
public class SearchInArray {
    public int searchInArray(int[] intArray, int valueToSearch) {
        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] == valueToSearch) {
                return i;
            }
        }
        return -1; // value not found in the array
    }
}
