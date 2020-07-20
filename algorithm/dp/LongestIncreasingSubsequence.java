package dp;

/*
 * tag
 * lintcode 76. Longest Increasing Subsequence
 * url https://www.lintcode.com/problem/longest-increasing-subsequence/my-submissions

 * Description
 * English
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * You code should return the length of the LIS.
 * Have you met this question in a real interview?
 * Clarification
 * What's the definition of longest increasing subsequence?
 * The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
 *
 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 *
 * Example
 * Example 1:
 * 	Input:  [5,4,1,2,3]
 * 	Output:  3
 *
 * 	Explanation:
 * 	LIS is [1,2,3]
 *
 *
 * Example 2:
 * 	Input: [4,2,4,5,3,7]
 * 	Output:  4
 *
 * 	Explanation:
 * 	LIS is [2,4,5,7]
 * Challenge
 * Time complexity O(n^2) or O(nlogn)
 *
 * Analysis:
 * dp[i] means at index i, what is the maximum size of the LIS.
 * j is the index when num[j] smaller than num[i]
 * E(j) is the collection of j;
 * dp[i] = max{for(j in E(j) -> dp[j]} + 1
 * if num[j] < num[i]
 */
public class LongestIncreasingSubsequence {

    // this is the solution from jiuzhang
    public int longestIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // by default the length is start with 1
            dp[i] = 1;
            for (int j = 0; j < i; j++) { // for loop all value which is before j
                if (nums[j] < nums[i]) { // only if nums[j] < nums[i], when compare the value
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}


