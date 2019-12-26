/*
 * @lc app=leetcode id=57 lang=golang
 *
 * [57] Insert Interval
 *
 * https://leetcode.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (31.j87%)
 * Total Accepted:    207.3K
 * Total Submissions: 644.4K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their
 * start times.
 *
 * Example 1:
 *
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 *
 * Example 2:
 *
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with
 * [3,5],[6,7],[8,10].
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 *
/
分析 newInterval 和 intervals【i】的分布情况
		xxxxxx    newInterval
	xxxxxxxx   intervals[i]
	 xxxx	newInterval
xxxxxx    newInterval

3 scenario might happend,
	1. no overlap
		a. newInterval have no overlap with any interval
			do nothing
		b. newInterval have  overlap with only one interval
			start = min(start, interval.start)
			end  = min(end, interval.end)
				does start and end need to to MAX INTEGER ?  NO
		c. newInterval have overlap with all intervals
			for this case. no need to compare again
			  make a flag
	2. overlap partially
		a. no diff with #1
	3. overlap totally
		a no diff with #1


        nnnnn
xxxxxx
   xxxxx
   			xxxxxxxxxxx
				xxxxx
*/
package main

import "fmt"

func insert(intervals [][]int, newInterval []int) [][]int {

	var start int
	var end int
	var result [][]int
	for i, e := range intervals {
		if i == 0 {
			start = e[0]
			end = e[1]
			continue
		}
		if (start > newInterval[0] && start < newInterval[1]) || (start < newInterval[0] && end > newInterval[1]) || (start < newInterval[0] && end > newInterval[0]) {
			start = min(start, newInterval[0])
			end = max(end, newInterval[1])
		}
		if i == 1 {
			fmt.Println(start, end)
		}

		if i >= 1 {
			if e[0] < end {
				end = max(end, e[1])
			} else {
				result = append(result, []int{start, end})
				start = e[0]
				end = e[1]
			}
		}
		if i == len(intervals)-1 {
			result = append(result, []int{start, end})
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

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func main() {
	fmt.Println(insert([][]int{{1, 3}, {2, 4}, {3, 6}}, []int{2, 7}))
}
