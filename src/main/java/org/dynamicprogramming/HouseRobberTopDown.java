package org.dynamicprogramming;

/* You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint
 stopping you from robbing each of them is that adjacent houses have
 security systems connected and it will automatically contact the police
  if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house,
 return the maximum amount of money you can rob tonight without alerting
 the police.
*/

public class HouseRobberTopDown {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        return getMaxMoney(nums, dp, 0);
    }

    private int getMaxMoney(int[] nums, int[] dp, int currentIndex) {
        if(currentIndex >= nums.length){
            return 0;
        }

        if(dp[currentIndex] != 0){
            return dp[currentIndex];
        }

        int includeCurrentHouse = nums[currentIndex] +
                getMaxMoney(nums, dp, currentIndex + 2);
        int excludeCurrentHouse = getMaxMoney(nums, dp, currentIndex + 1);
        dp[currentIndex] = Math.max(includeCurrentHouse, excludeCurrentHouse);
        return dp[currentIndex];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        HouseRobberTopDown houseRobber = new HouseRobberTopDown();
        System.out.println(houseRobber.rob(nums)); // Output: 4
    }
}
