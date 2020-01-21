/*
 * @lc app=leetcode id=85 lang=golang
 *
 * [85] Maximal Rectangle
 *
 * https://leetcode.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (34.71%)
 * Total Accepted:    144.1K
 * Total Submissions: 408.9K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 *
 * Example:
 *
 *
 * Input:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 *
 */

package matrix

import "fmt"

func maximalRectangle(matrix [][]byte) int {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return 0
	}

	grid := createMatrix(matrix, len(matrix), len(matrix[0]))
	return largest(grid)
}

func createMatrix(matrix [][]byte, row int, col int) [][]int {
	grid := make([][]int, 0)
	for i := 0; i < row; i = i + 1 {
		newRow := make([]int, col)
		grid = append(grid, newRow)
	}

	//fmt.Println("grid : ", grid)
	for i := row - 1; i >= 0; i = i - 1 {
		for j := 0; j < col; j = j + 1 {
			if matrix[i][j] == 49 {
				for cur := i; cur >= 0; cur = cur - 1 {
					if matrix[cur][j] == 49 {
						//				fmt.Println("i: ", i, " j : ", j)
						grid[i][j] = grid[i][j] + 1
					} else {
						break
					}
				}
			}
		}
	}
	//	fmt.Println("grid : ", grid)
	return grid
}

func largest(grid [][]int) int {

	m := 0

	for row := 0; row < len(grid); row = row + 1 {
		s := make(Stack, 0)

		s = append(s, -1)
		for i := 0; i <= len(grid[row]); i = i + 1 {
			// 		fmt.Println(s)
			var cur int
			if i == len(grid[row]) {
				cur = -1
			} else {
				cur = grid[row][i]
			}
			//		fmt.Println("row", row, "peek : ", s.Peek())
			for len(s) > 1 && cur <= grid[row][s.Peek()] {
				var index_h int
				s, index_h = s.Pop()

				h := grid[row][index_h]
				w := i - s.Peek() - 1
				m = max(m, h*w)
			}
			s = s.Push(i)
		}
	}
	return m
}

type Stack []int

func (s Stack) Peek() int {
	return s[len(s)-1]
}

func (s Stack) Push(v int) []int {
	s = append(s, v)
	return s
}

func (s Stack) Pop() ([]int, int) {
	return s[:len(s)-1], s[len(s)-1]
}

func max(a int, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}

func convert(matrix [][]string) [][]byte {
	r := len(matrix)
	c := len(matrix[0])

	grid := make([][]byte, 0)
	for i := 0; i < r; i = i + 1 {
		row := make([]byte, 0)
		for j := 0; j < c; j = j + 1 {
			row = append(row, []byte(matrix[i][j])[0])
			//fmt.Println(j)
		}
		grid = append(grid, row)
	}
	//fmt.Println("grid ", grid)
	return grid
}

func main() {
	//matrixString := [][]string{{"1", "0", "1", "0", "0"}, {"1", "0", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "0", "0", "1", "0"}}
	matrixString := [][]string{{"1"}}
	//	matrixString := [][]string{{"1", "0", "1", "1", "1"}, {"0", "1", "0", "1", "0"}, {"1", "1", "0", "1", "1"}, {"1", "1", "0", "1", "1"}, {"0", "1", "1", "1", "1"}}
	matrix := convert(matrixString)
	fmt.Println(maximalRectangle(matrix))
}
