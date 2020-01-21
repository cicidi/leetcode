/*
 * @lc app=leetcode id=74 lang=golang
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (35.32%)
 * Total Accepted:    266.3K
 * Total Submissions: 749.1K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 */
package matrix

import (
	"fmt"
)

func searchMatrix(matrix [][]int, target int) bool {
	row := len(matrix)
	if row == 0 {
		return false
	}
	col := len(matrix[0])
	for i, j := row-1, 0; i >= 0 && j < col; {
		if matrix[i][j] == target {
			return true
		}
		if matrix[i][j] < target {
			j = j + 1
		} else {
			i = i - 1
		}
	}
	return false
}

func main() {
	fmt.Println("main")

	// failed test 1
	// failed before I use i < row instead of i >= 0
	m1 := [][]int{
		{1},
	}

	result := searchMatrix(m1, 0)
	if result != true {
		fmt.Println("wrong")
	}
	fmt.Println(result)
}
