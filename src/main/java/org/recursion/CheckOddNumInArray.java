package org.recursion;

import java.util.Arrays;

/*
Write a recursive function called someRecursive which accepts an array
 and a callback. The function returns true if a single value in
 the array returns true when passed to the callback.
 Otherwise it returns false.
*/
class OddFunction {
    boolean run(int num) {
        if (num % 2 == 0) {
            return false; }
        else {
            return true;
        }
    }
}
public class CheckOddNumInArray {

    public static boolean someRecursive(int[] arr, OddFunction odd) {
        // TODO
        if(arr.length == 1){
            return odd.run(arr[0]);
        }
        System.out.println(Arrays.toString(arr));
        return odd.run(arr[0]) ||
                someRecursive(Arrays.copyOfRange(arr,1, arr.length), odd);
    }

     public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,4,5,6};
         OddFunction odd = new OddFunction();
        System.out.println(someRecursive(arr, odd)); // should print true
    }
}
