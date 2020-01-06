/*
 * @lc app=leetcode id=64 lang=golang
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (48.86%)
 * Total Accepted:    282.2K
 * Total Submissions: 568.4K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 *
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 *
 */

package main

import "fmt"

func minPathSum(grid [][]int) int {
	r := len(grid)
	c := len(grid[0])

	result := createMatrix(r, c)
	for i := 0; i < r; i = i + 1 {
		for j := 0; j < c; j = j + 1 {
			if i == 0 && j == 0 {
				result[i][j] = grid[i][j]
			} else if i == 0 {
				result[i][j] = result[i][j-1] + grid[i][j]
			} else if j == 0 {
				result[i][j] = result[i-1][j] + grid[i][j]
			} else {
				result[i][j] = min(result[i-1][j], result[i][j-1]) + grid[i][j]
			}
		}
	}
	fmt.Println(result)
	return result[r-1][c-1]
}

func min(x int, y int) int {
	if x <= y {
		return x
	} else {
		return y
	}
}

func createMatrix(r int, c int) [][]int {
	var matrix = make([][]int, 0)
	for i := 0; i < r; i = i + 1 {
		var row = make([]int, c)
		matrix = append(matrix, row)
	}
	return matrix
}
func main() {
	var grid = [][]int{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}
	fmt.Println(minPathSum(grid))
}
