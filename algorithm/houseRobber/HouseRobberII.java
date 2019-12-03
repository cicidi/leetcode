package houseRobber;/*
 *You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

 */

// 2, 1 ,1,2
// 2,   (1,2,true)
//      (1,)    
// (1,1,2)
// 1, (2,false)
//
// 1,( 1,1)
//   (2,1,1)
//   2 ,1 
//
// (1,3,1,3,100)
// d(1) = d(0) + d(1,3,100,true)
//               = d(1) + d(0,100)
//               or d(3,100,true)
//
class HourseRobberII {

    public static void main(String[] args) {
        //int[] arr = new int[]{1,2,1,1};
        int[] arr = new int[]{1, 3, 1, 3, 100};
        HourseRobberII s = new HourseRobberII();
        System.out.println(s.rob(arr));
    }

    int[] dp;

    public int rob(int[] nums) {
        // pick first house
        boolean pf = false;
        init(nums.length);
        return this.helper(nums, 0, pf);
    }

    public int helper(int[] nums, int i, boolean pf) {
        if (i >= nums.length || nums.length == 0) {
            return 0;
        }
        //if (dp[i] != -1){
        //  return dp[i];
        //}
        int result = 0;
        System.out.println(i);
        if (i == nums.length - 2) {
            if (!pf) {
                result = Math.max(nums[i], nums[i + 1]);
            } else {
                result = nums[i];
            }
        } else if (i == nums.length - 1) {
            if (!pf) {
                //System.out.println("end i " + i + " end pf " + pf);
                result = nums[i];
            }
        } else {
            if (i == 0 && pf == false) {
                pf = true;
            }
            boolean pf2 = false;
            if (i == 0) {
                pf2 = false;
            } else {
                pf2 = pf;
            }
            //      System.out.println("i :" + i + " pf " + pf);
            result = Math.max(nums[i] + helper(nums, i + 2, pf), helper(nums, i + 1, pf2));
        }
        System.out.println("i : " + i + " " + nums[i] + " pf " + pf + " result " + result);
        // dp[i] = result;
        return result;
    }

    public void init(int length) {
        dp = new int[length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
    }
}
