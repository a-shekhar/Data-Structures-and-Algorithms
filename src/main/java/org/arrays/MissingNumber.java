package org.arrays;

/*
Write Java function called findMissingNumberInArray that takes an integer array containing n-1 unique elements from a range of 1 to n, with one missing number, and returns the missing number.
Example
myArray = {1,2,3,4,6}
findMissingNumberInArray(myArray, 6) //
 */
public class MissingNumber {
    static int findMissingNumberInArray(int[] arr) {
        int n = arr.length+1;
        int totalSum = (n * (n + 1))/2;
        int sum = 0;
        for(int num : arr) {
            sum += num;
        }
        System.out.println(totalSum);
        System.out.println(sum);
        return totalSum - sum;
    }

    public static void main(String[] args) {
        MissingNumber myArray = new MissingNumber();
        int[] arr = {1, 2, 3, 4, 6};
        System.out.println("Missing number: " + myArray.findMissingNumberInArray(arr)); // Output: 5
    }
}
