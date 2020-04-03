/*
 * @lc app=leetcode id=70 lang=golang
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (45.19%)
 * Total Accepted:    518K
 * Total Submissions: 1.1M
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 *
 * Example 2:
 *
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
*  1
*  2
*  1 1 1
*   Step [n - 1] + 1
*	Step [n - 2] + 2
*   solution[n - 1] + solution[n - 2]
 */
package main

func climbStairs(n int) int {
	var dp = make([]int, 0)
	dp[1] = 1
	dp[2] = 2
	for i := 3; i <= n; i++ {
		dp[n] = dp[n-2] + dp[n-1]
	}
	return dp[n]
}
