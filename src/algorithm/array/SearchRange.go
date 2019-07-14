package main

import "fmt"

func main() {
	fmt.Println("vim-go")
}
func SearchRange(nums []int, target int) []int {
	if nums == nil || len(nums) == 0 {
		return []int{-1, -1}
	}
	l := helper(nums, target, true)
	r := helper(nums, target, false)
	return []int{l, r}
}
func helper(nums []int, target int, left bool) int {
	var l = 0
	var r = 0
	var m = 0
	for l+1 < r {
		m = l + (r-l)/2
		if nums[m] == target {
			if left {
				r = m
			} else {
				l = m
			}
		}
		if nums[m] < target {
			l = m
		}
		if target < nums[m] {
			r = m
		}
	}
	if left {
		if nums[r] == target {
			return r
		}
		if nums[l] == target {
			return l
		}
	} else {
		if nums[l] == target {
			return l
		}
		if nums[r] == target {
			return r
		}
	}
	return -1
}
