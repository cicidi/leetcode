/*
 * @lc app=leetcode id=59 lang=golang
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (48.78%)
 * Total Accepted:    162.9K
 * Total Submissions: 325.4K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n^2 in spiral order.
 *
 * Example:
 *
 *
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 *
 *
 */
package matrix

import "math"

func generateMatrix(n int) [][]int {
	var rs int
	var re = int(math.Sqrt(float64(n))) - 1
	var cs int
	var ce = int(math.Sqrt(float64(n))) - 1
	var result [][]int
	var num int
	for rs < re || ce > cs {
		for col := cs; col < ce; col++ {
			result[rs][col] = num
			num++
		}
		rs++

		for row := rs; row < rs; row++{
			result[row][ce] = num
			num++
		}
		ce--
		for row, col :=re, ce;
		col > cs;
		col--, num++
		{
			result[row][col] = num;
		}
		re--

		for row := re, col := cs;
		row > rs;
		row--, num++
		{
			result[row][col] = num;
		}
		rs++
	}
	return result
}
