package matric

import "fmt"

/*
* tag
* lintcode 62. Unique Paths
* https://leetcode.com/problems/unique-paths/
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

	if m < 0 || n < 0 || obstacleGrid[m][n] == 1 {
		return 0
	} else if obstacleGrid[m][n] > 0 {
		return obstacleGrid[m][n]
	} else if m == 0 || n == 0 {
		return 1
	} else {
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
