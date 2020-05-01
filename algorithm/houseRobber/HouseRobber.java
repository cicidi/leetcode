package houseRobber;/*
 *[198] House Robber

https://leetcode.com/problems/house-robber/description/

* algorithms
* Easy (41.34%)
* Source Code:       198.house-robber.java
* Total Accepted:    389.8K
* Total Submissions: 941.1K
* Testcase Example:  '[1,2,3,1]'

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:


Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

Example 2:


Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 * */

/*
 * When to use dp 
 *  it seems decision or result on picking each house is depends on the solution of others
 *dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]) 
 * but since we dont know dp [i + 2] we need to change dp as an array to helper() and in the helper we reassign the value to dp arr[], that is why init all value to -1 by default; 
 * */

class HouseRobber {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 2};
        HouseRobber s = new HouseRobber();
        System.out.println(s.rob(arr));
    }

    int[] dp;
    
    public int rob(int[] nums){
        this.solution1(nums);
    }

    public int solution1(int[] nums) {
        init(nums.length);
        return this.helper(nums, 0);
    }

    public int helper(int[] nums, int i) {
        if (i >= nums.length || nums.length == 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int result;
        if (i == nums.length - 2) {
            result = Math.max(nums[i], nums[i + 1]);
        }
        if (i == nums.length - 1) {
            result = nums[i];
        } else {
            result = Math.max(nums[i] + helper(nums, i + 2), helper(nums, i + 1));
        }
        dp[i] = result;
        return result;
    }

    public void init(int length) {
        dp = new int[length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
    }
}
