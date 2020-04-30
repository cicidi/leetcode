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
 */
public class LongestIncreasingSubsequence {

    public int LongestIncreasingSubsequence(int[] nums) {
        int[] f = new int[nums.length];
        int max = 0;
        return 0;
    }
}
//
// function
// if  num[j] < num[i]
// if f[i] > f [j]+1
// 对于每个数字，枚举前面所有小于自己的数字 j，Dp[i] = max{Dp[j]} + 1   这个1 是指num [i]
//  then f [i] = f [j]+1
//
// 对于数据里面的每一个数进行历


