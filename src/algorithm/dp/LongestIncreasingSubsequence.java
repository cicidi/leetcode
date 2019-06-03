package algorithm.dp;

/*
 * tag
 * lintcode 76. Longest Increasing Subsequence
 * url https://www.lintcode.com/problem/longest-increasing-subsequence/my-submissions
 * url
 */
public class LongestIncreasingSubsequence {

//    public int LongestIncreasingSubsequence(int[] nums) {
//        int[] f = new int[nums.length];
//        int max = 0;
//
//        // function
//        // if  num[j] < num[i]
//        // if f[i] > f [j]+1
//        // 对于每个数字，枚举前面所有小于自己的数字 j，Dp[i] = max{Dp[j]} + 1   这个1 是指num [i]
//        //  then f [i] = f [j]+1
//
//        // 对于数据里面的每一个数进行遍历

    //    possibility[i]   表示截止到i 有多少种可能
    // important 公式 for loop 两边是为了  能够满足不同的头和尾
    public int longestIncreasingSubsequence(int[] nums) {
        int[] possibility = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            possibility[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    possibility[i] = Math.max(possibility[i], possibility[j] + 1);
                }
            }
            if (possibility[i] > max) {
                max = possibility[i];
            }
        }
        return max;
    }
}
