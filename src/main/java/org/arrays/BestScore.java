package org.arrays;

import java.util.Arrays;

/*
Given an array, write a function to get first, second best scores from the array and return it in new array.
Array may contain duplicates.
 */
public class BestScore {
    public static int[] findTopTwoScores(int[] array){
        Arrays.sort(array);
        return new int[]{array[array.length-1], array[array.length-2]};
        // 2nd approach
        /*
        int firstHighest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int score : array) {
            if (score > firstHighest) {
                secondHighest = firstHighest;
                firstHighest = score;
            } else if (score > secondHighest && score < firstHighest) {
                secondHighest = score;
            }
        }
         */
    }
}
