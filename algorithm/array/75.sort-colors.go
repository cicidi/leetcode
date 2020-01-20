/*
 * @lc app=leetcode id=75 lang=golang
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (43.38%)
 * Total Accepted:    382K
 * Total Submissions: 870.1K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 *
 * Example:
 *
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Follow up:
 *
 *
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 *
 */

/*
    x = 0,2,


    0,0,0,1           2
	0,2,1,2,2,0.1,1,2,0

	0,2,1,2,2,0.1,1,2,1
	  ^               ^
	0,1,1,2,2,0.1,1,2,2
	  ^           ^
	0,0,1,1,2,0.1,2,2,2
	  	^		^
	0,0,1,1,1,0.2,2,2,2
	  	^	  ^
*/

package main

import "fmt"

func sortColors(nums []int) {
	lastNZ := 0
	firstNT := len(nums) - 1
	for i := 0; i <= firstNT; i++ {
		tmp := nums[i]
		//  fmt.Println("lastNZ ", lastNZ, " firstNT ", firstNT)
		if tmp == 0 {
			change(lastNZ, i, nums)
			for nums[firstNT] == 2 {
				firstNT--
			}
			for nums[lastNZ] == 0 {
				lastNZ++
			}
			continue
		}
		if tmp == 2 {
			change(firstNT, i, nums)
			for nums[firstNT] == 2 {
				firstNT--
			}
			for nums[lastNZ] == 0 {
				lastNZ++
			}
			continue
		}
	}
	fmt.Println(nums)
}

func change(i int, j int, nums []int) []int {
	t := nums[i]
	nums[i] = nums[j]
	nums[j] = t
	return nums
}

func main() {
	//var arr = []int{0, 2, 1, 2, 2, 0, 1, 1, 2, 0}
	var arr = []int{1, 0}
	sortColors(arr)
}
