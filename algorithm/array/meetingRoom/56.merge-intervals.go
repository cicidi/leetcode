/*
 * @lc app=leetcode id=56 lang=golang
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (36.76%)
 * Total Accepted:    453.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 *
 *
 * Example 2:
 *
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 *
 */

/*
 analysis

 first we need to sort the interval by the `start`
 second, we need to check if the 2 ajacent interval has intersection.  how to? 这个地方每次自己想一遍  since it is sort, so  compare interval1.end with interval2.start
 third, if intersect then end = max , and dont add to result
 fortth, if  not overlap , then add to result
 fifty , dont miss the last one
*/

package main

import (
	"fmt"
	"sort"
)

// import "fmt"

func merge(intervals [][]int) [][]int {
	if len(intervals) <= 1 {
		return intervals
	}

	sort.SliceStable(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	start := intervals[0][0]
	end := intervals[0][1]

	var result [][]int
	for i, e := range intervals {
		if i >= 1 {
			//if i == len(intervals)-1 {
			//	result = append(result, []int{start, end})
			//}
			if end >= e[0] {
				end = max(end, e[1])
			} else {
				result = append(result, []int{start, end})
				start = e[0]
				end = e[1]
			}
			if i == len(intervals)-1 {
				result = append(result, []int{start, end})
			}
		}
	}
	return result
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
func main() {
	result := merge([][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}})
	fmt.Print(result)
}
