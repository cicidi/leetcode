/*
 * @lc app=leetcode id=77 lang=golang
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (50.02%)
 * Total Accepted:    241.4K
 * Total Submissions: 474.3K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
d*
 * Example:
 *
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 *
 *
*/

package permute

import "fmt"

func combine(n int, k int) [][]int {
	var result = make([][]int, 0)
	return dp(1, n, make([]int, 0), k, result)
}

func dp(index int, n int, arr []int, k int, result [][]int) [][]int {
	if len(arr) == k {
		fmt.Println("result1", result)
		fmt.Println("arr2 ", arr)
		b := make([]int, len(arr))
		copy(b, arr)
		result := append(result, b)
		fmt.Println("result1'", result)
		return result
	}

	for i := index; i <= n; i = i + 1 {
		fmt.Println(i)
		fmt.Println("arr3 ", arr)
		arr := append(arr, i)
		fmt.Println("result4 ", result)
		result = dp(i+1, n, arr, k, result)
		fmt.Println("result2 ", result)
		arr = arr[:len(arr)-1]
		fmt.Println("arr ", arr)
		fmt.Println("result3 ", result)
	}
	return result
}

func main() {
	fmt.Println("final ", combine(5, 4))

	//failed test  (5,4)
	//Output 	[[1,2,3,5],[1,2,3,5],[1,2,4,5],[1,3,4,5],[2,3,4,5]]
	//Expected 	[[1,2,3,4],[1,2,3,5],[1,2,4,5],[1,3,4,5],[2,3,4,5]]
	// reason  create array  there is a tricky

	// array
	var a = [5]int{1, 2, 3, 4, 5}
	b := a
	b[4] = 100
	fmt.Println(a, b)

	// slice
	var s = []int{1, 2, 3, 4, 5}
	t := s
	t[4] = 100
	fmt.Println(s, t)

	// 这里的问题主要是 如果用make 创建 array 如果length 默认给0 那么其实是创建slice， 如果是给一个固定值，那么是创建array
	// slice 和 array 的主要区别是，  slice 如果我去掉一个，最后的值，在添加一个值 在result 里面的arr 会通过reference 的关系，把 1，2，3，4 改成1，2，3，5
	// 所以这里要用slice  但是在最后往result 里面添加的时候， 要用一个copy 方法，把arr 值放到一个新的array 里面去，而这个array 要通过make 加上 一个非0 length 的方式创建
}
