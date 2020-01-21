/*
 * @lc app=leetcode id=60 lang=golang
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (34.23%)
 * Total Accepted:    156.9K
 * Total Submissions: 453.1K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 *
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 *
 * Given n and k, return the k^th permutation sequence.
 *
 * Note:
 *
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, k = 3
 * Output: "213"
 *
 *
 * Example 2:
 *
 *
 * Input: n = 4, k = 9
 * Output: "2314"
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

func getPermutation(n int, k int) string {
	var finalResult = make([][]int, 0)
	var tmp = make([]int, 0)
	var visited = make([]bool, n)
	finalResult, _ = dfs(finalResult, tmp, n, 0, visited, k)
	fmt.Println(finalResult)
	return fmt.Sprintln(finalResult[len(finalResult)-1])
}

func dfs(finalResult [][]int, tmp []int, n int, index int, visited []bool, k int) ([][]int, int) {
	if index >= n {
		finalResult = append(finalResult, tmp)

		return finalResult, k - 1
	}

	for i := 1; i <= n; i++ {
		if visited[i-1] {
			continue
		}
		if k == 0 {
			break
		}

		visited[i-1] = true
		tmp = append(tmp, i) // important here if use  tmp := then the tmp has 3 number at maxium
		// if use tmp = then the tmp will have more then 3 number every time
		finalResult, k = dfs(finalResult, tmp, n, index+1, visited, k)
		tmp = tmp[:len(tmp)-1] // so , either remove last element or create a new tmp object every time
		visited[i-1] = false

	}
	return finalResult, k
}

func main() {
	fmt.Println(getPermutation(3, 3))
}
