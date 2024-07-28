package org.divideandconquer;

/* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/
public class HouseRobber {
    public int rob(int[] nums) {
        return getMaxMoney(nums, 0);
    }

    private int getMaxMoney(int[] nums, int index) {
        if(index >= nums.length){
            return 0;
        }
        int includeCurrentHouse = nums[index] +
                getMaxMoney(nums, index + 2);
        int excludeCurrentHouse = getMaxMoney(nums, index + 1);
        return Math.max(includeCurrentHouse, excludeCurrentHouse);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(nums)); // Output: 4
    }
}
