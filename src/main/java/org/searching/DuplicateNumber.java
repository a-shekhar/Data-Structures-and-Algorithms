package org.searching;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            System.out.println(Math.abs(nums[i]) + " " + nums[Math.abs(nums[i])]);
            if(nums[Math.abs(nums[i])] < 0){
                return Math.abs(nums[i]);
            }else{
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DuplicateNumber duplicateNumber = new DuplicateNumber();
        int[] nums = {1, 3, 2, 2, 4};
        System.out.println(duplicateNumber.findDuplicate(nums)); // Output: 2
    }
}
