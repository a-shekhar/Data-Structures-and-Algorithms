package org.arrays;

/*
How to find maximum product of two integers in the array where all elements are positive.
Example:
int[] intArray = {10,20,30,40,50};
maxProduct(intArray) // (40,50)
*/
public class MaxProduct {
    public String maxProduct(int[] intArray) {
        int maxProduct = Integer.MIN_VALUE;
        String ans = "";
        for(int i = 0; i < intArray.length; i++) {
            for(int j = i+1; j < intArray.length; j++) {
                if(intArray[i] * intArray[j] > maxProduct) {
                    maxProduct = intArray[i]*intArray[j];
                    ans = intArray[i] + "," + intArray[j];
                }
            }
        }
        return ans;
    }
}
