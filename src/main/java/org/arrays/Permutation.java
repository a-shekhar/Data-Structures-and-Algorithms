package org.arrays;

import java.util.HashMap;

/*
Your are given two integer arrays. Write a program to check if they are permutation of each other.
Example
int[] array1 = {1,2,3,4,5};
int[] array2 = {5,1,2,3,4};
permutation(array1, array2)
Output
true
 */
public class Permutation {
    public boolean permutation(int[] array1, int[] array2){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : array1){
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        for(int num : array2){
          if(!map.containsKey(num)){
              return false;
          }

          if(map.get(num) == 0){
              return false;
          }

          map.put(num, map.get(num) - 1);
        }
        return true;
    }
}
