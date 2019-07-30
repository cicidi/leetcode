package main

import "fmt"

/*
* tag Matrix
* leetcode 59. Spiral Matrix II 892. Alien Dictionary
* https://leetcode.com/problems/spiral-matrix-ii/
 */
/* 1. 先把边界画出来
2. 然后开始转圈圈，每次把已经跑完的row， 或者col 的那个边界的值 -1 或+1 这样范围就缩小了
3。 一直赚到不能转圈圈
*/
func generateMatrix(n int) [][]int {
	number := 0
	columnStart := 0
	columnEnd := n - 1
	rowStart := 0
	rowEnd := n - 1
	matric := make([][]int, n)
	for i := range matric {
		matric[i] = make([]int, n)
	}
	for rowEnd >= rowStart {
		// travese right
		for i := columnStart; i <= columnEnd; i++ {
			matric[rowStart][i] = number
			println(number)
			number++
		}
		rowStart++
		// traverse down

		for i := rowStart; i <= rowEnd; i++ {
			matric[i][columnEnd] = number
			println(number)
			number++
		}
		columnEnd--

		// traverse left
		for i := columnEnd; i >= columnStart; i-- {
			matric[rowEnd][i] = number
			println(number)
			number++
		}

		rowEnd--
		for i := rowEnd; i >= rowStart; i-- {
			matric[i][columnStart] = number
			println(number)
			number++
		}

		columnStart++

	}
	return matric
}
func main() {
	fmt.Println(generateMatrix(4))
}
