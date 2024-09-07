package org.arrays;

import java.util.ArrayList;
import java.util.HashMap;

/*
LeetCode-217 Given an integer array nums,
return true if any value appears at least twice in the array,
and return false if every element is distinct.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums) {
            if(list.contains(num)) {
                return true;
            }
            list.add(num);
        }
        return false;
    }
}
