/*
 * @lc app=leetcode id=81 lang=golang
 *
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (32.77%)
 * Total Accepted:    199.8K
 * Total Submissions: 608.5K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 *
 * Example 1:
 *
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * Follow up:
 *
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums
 * may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 *
 *
 */
package linkedlist

import (
	"fmt"
	"math"
)

func search(nums []int, target int) bool {
	if len(nums) == 0 {
		return false
	}
	start := 0
	end := len(nums) - 1
	vStart := math.MinInt32
	vEnd := math.MaxInt32
	for start < end-1 {
		tmpS := start
		for nums[start] == vStart {
			start = start + 1
		}
		if tmpS != start {
			continue
		}
		tmpE := end
		for nums[end] == vEnd {
			end = end - 1
		}
		if tmpE != end {
			continue
		}

		mid := start + (end-start)/2
		if target == nums[mid] {
			return true
		}
		if nums[start] < nums[mid] {
			fmt.Println("nums[start] < nums[mid] :", start, mid, end)
			fmt.Println("nums vale :", nums[start], nums[mid], nums[end])
			fmt.Println("target : ", target)
			if nums[start] <= target && target <= nums[mid] {
				fmt.Println("nums[start] < target && target < nums[end]")
				end = mid
			} else {
				fmt.Println("else nums[start] < target && target < nums[end]")
				start = mid
			}
		} else {
			fmt.Println("nums[start] >=  nums[mid]")
			if nums[mid] <= target && target <= nums[end] {
				start = mid
				fmt.Println("1")
			} else {
				fmt.Println("2")
				end = mid
			}
		}
		vStart = nums[start]
		vEnd = nums[end]
	}
	if nums[start] == target {
		return true
	}
	if nums[end] == target {
		return true
	}
	fmt.Println("start : ", start)
	fmt.Println("end : ", end)
	return false
}
func main() {
	//test case 1
	// 1,2,3,4,5
	//	arr := []int{2, 5, 6, 0, 0, 1, 2}
	//	fmt.Println(search(arr, 2))
	//	fmt.Println(search(arr, 5))
	//	fmt.Println(search(arr, 6))
	//	fmt.Println(search(arr, 0))
	//	fmt.Println(search(arr, 3))
	//	fmt.Println(search(arr, 4))
	//	fmt.Println(search(arr, 7))
	//	//test case 2
	//	// if the ar has duplicate,  the start and end might be same
	//	// so need to remove
	//	arr2 := []int{1, 1, 3, 1}
	//	fmt.Println(search(arr2, 2))
	arr3 := []int{4, 5, 6, 7, 0, 1, 2, 3}
	fmt.Println(search(arr3, 4))
	fmt.Println(search(arr3, 6))
}

/*

	 	    |  xxxx     |
		    | x         |
	        |x          |
	       x|           |  xxxxx
	  xxxxx |           | x
	   	    |           |x
		    |          x|
	        |      xxxx |
*/
