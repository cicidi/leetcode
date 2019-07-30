package main

import "fmt"

/*
* tag
* leetcode 62. Unique Paths
* https://leetcode.com/problems/unique-paths/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner

of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?*/

/*
steps
1. 确定方法，这个机器人走路  应该是可以用bfs 的  回头可以做一下
2。 这里用的dfs  也就是用recursion 走， 每一个格子的unique path 都等于 他右边的和他下边的 数量的和

*/

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	if len(obstacleGrid) == 0 {
		return 0
	}
	m := len(obstacleGrid)
	n := len(obstacleGrid[0])
	if obstacleGrid[0][0] == 1 {
		return 0
	}
	return uniquePathHelper(m-1, n-1, obstacleGrid)
}
func uniquePathHelper(m int, n int, obstacleGrid [][]int) int {

	if m < 0 || n < 0 || obstacleGrid[m][n] == 1 { //important recursion 的结束条件 1
		return 0
	} else if obstacleGrid[m][n] > 0 { // important recursion 的结束条件 2
		return obstacleGrid[m][n]
	} else if m == 0 || n == 0 { // important recursion 的结束条件 3
		return 1
	} else { // important recursion 的开始句
		obstacleGrid[m][n] = uniquePathHelper(m-1, n, obstacleGrid) + uniquePathHelper(m, n-1, obstacleGrid)
		return obstacleGrid[m][n]
	}
}

func createMatric(m int, n int) [][]int {
	matric := make([][]int, m)
	for i := range matric {
		matric[i] = make([]int, n)
	}
	return matric
}

func createObs(m int, n int) [][]int {
	matric := make([][]int, m)
	for i := range matric {
		matric[i] = make([]int, n)
	}
	matric[0][0] = 1
	return matric
}

func main() {
	println("start")
	fmt.Println(uniquePathsWithObstacles(createObs(2, 1)))
}
