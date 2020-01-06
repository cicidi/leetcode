/*
 * @lc app=leetcode id=78 lang=golang
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (55.39%)
 * Total Accepted:    449K
 * Total Submissions: 794.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */
package main

import "fmt"

func subsets(nums []int) [][]int {
	result := make([][]int, 0)
	result = append(result, make([]int, 0))
	return dp(nums, 0, make([]int, 0), result)
}
func dp(nums []int, start int, slice []int, result [][]int) [][]int {
	if start == len(nums) {
		tmp := make([]int, len(slice))
		copy(tmp, slice)
		result = append(result, tmp)
	}

	for i := start; i < len(nums); i = i + 1 {
		//result = dp(nums, i+1, slice, result)
		slice = append(slice, nums[i])
		result = dp(nums, i+1, slice, result)
		slice = slice[:len(slice)-1]
	}
	return result
}

func main() {
	arr := []int{1, 2, 3}
	fmt.Println(subsets(arr))
}
