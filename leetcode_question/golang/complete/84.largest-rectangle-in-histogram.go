/*
 * @lc app=leetcode id=84 lang=golang
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (32.35%)
 * Total Accepted:    209K
 * Total Submissions: 636.7K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 *
 *
 *
 *
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 *
 *
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 *
 *
 *
 * Example:
 *
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 *
 */
package main

import "fmt"

type Stack []int

func (s Stack) Push(v int) Stack {
	return append(s, v)
}

func (s Stack) Pop() (Stack, int) {
	l := len(s)
	return s[:l-1], s[l-1]
}

func (s Stack) Peek() int {
	//fmt.Println(len(s))
	return s[len(s)-1]
}

func largestRectangleArea(heights []int) int {
	s := make(Stack, 0)

	m := 0
	s = s.Push(-1)
	for i := 0; i <= len(heights); i = i + 1 {
		//	fmt.Println("stack: ", s)
		var cur int
		if i == len(heights) {
			cur = -1
		} else {
			cur = heights[i]
		}
		for len(s) > 1 && heights[s.Peek()] >= cur {
			var last int
			var h int
			s, last = s.Pop() // here the s should not use s, last := s.Pop  which create a new instance
			//		fmt.Println("last : ", last)
			h = heights[last]
			w := i - s.Peek() - 1
			//		fmt.Println("h : ", h, "w : ", w)
			m = max(m, h*w)
		}
		s = s.Push(i)
	}
	return m
}

func max(a int, b int) int {

	if a >= b {
		return a
	}
	return b

}

func main() {
	input := []int{2, 1, 5, 6, 2, 3}
	//input := []int{1}
	fmt.Println(largestRectangleArea(input))
}
