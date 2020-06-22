/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (46.10%)
 * Total Accepted:    981.5K
 * Total Submissions: 2.1M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */

/*
 *
 * 1. start either from the start or end, both fine.
 * 2. [-2, 1 ,3,...]  dp[0] = -2   dp[1] = Math.max(dp[0]+ nums[1], nums[1]);
 * 3. dp[n] = Math.max(dp[n - 1], nums[n], nums[n]);
 
 
 */
package dp;

import java.lang.Math;
class Solution {
    public int maxSubArray(int[] nums) {
    
      if(nums.length == 0){
        return 0;
      }
      int[] dp = new int[nums.length];
      dp[0] = nums[0];
      int max = dp[0];
      for(int i = 1; i < nums.length; i++){
         dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
         max = Math.max(max,dp[i]);
      }
      return max;
    }
}
