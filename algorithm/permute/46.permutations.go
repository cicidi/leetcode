/*
 * @lc app=leetcode id=46 lang=golang
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (57.71%)
 * Total Accepted:    472.6K
 * Total Submissions: 804.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 *
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 *
 *  123
 		- candidate [1, 2, 3]
		i = 0
		- cur -> 1
		- candidate [2,3]
		- result[1]
			- candidate [2, 3]
			- i = 0
			- cur -> 2
			- candidate [3]
			- result[1, 2]
				- candidate[3]
				- i = 0
				- cur -> 3
				- candidate []
				- result [1, 2, 3]
					-  candidate []
						reuslt [1,2,3] -> add to finalResult
						return to last lier
			- candidate[2, 3]
			- i = 1
			- cur -> 3
			- candidate[2]
			-result[1, 3]
*/

package permute

import "fmt"

func permute(nums []int) [][]int {
	finalResult := make([][]int, 0)
	var result = make([]int, 0)
	var visited = make([]bool, len(nums))
	return permute_dfs(finalResult, result, nums, visited, 0)
}

func permute_dfs(finalResult [][]int, result []int, nums []int, visited []bool, index int) [][]int {
	if index >= len(nums) {
		//	arr := result // copy result
		fmt.Println("before merge {}", finalResult)
		finalResult = append(finalResult, result)
		fmt.Println("merge {}", finalResult)
		return finalResult
	}

	for i := 0; i < len(nums); i++ {
		if visited[i] {
			continue
		}
		result := append(result, nums[i])
		visited[i] = true
		fmt.Println("finalResult {},result{}", finalResult, result)
		finalResult = permute_dfs(finalResult, result, nums, visited, index+1)
		visited[i] = false

	}
	return finalResult
}

//func main() {
//	fmt.Println("main")
//
//	var nums = []int{1, 2, 3}
//	fmt.Println(permute(nums))
//}
