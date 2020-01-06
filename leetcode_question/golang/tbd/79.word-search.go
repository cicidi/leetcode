/*
 * @lc app=leetcode id=79 lang=golang
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (32.52%)
 * Total Accepted:    359.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 *
 * Example:
 *
 *
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 */

package main

import "fmt"

func exist(board [][]byte, word string) bool {
	if len(board) == 0 {
		return false
	}
	arr := []byte(word)
	rowSize := len(board)
	colSize := len(board[0])
	for i := 0; i < rowSize; i = i + 1 {
		for j := 0; j < colSize; j = j + 1 {
			if expend(len(board), len(board[0]), i, j, board, 0, arr, word, root) {
				return true
			}
		}
	}

	return false
	//return expend(0, 0, 0, 0, board, 0, word)
	//return false
}

var dir = []int{-1, 0, 1, 0, -1}

func expend(rowSize int, colSize int, row int, col int, board [][]byte, index int, word []byte, wordStr string, trie Trie) bool {
	//	fmt.Println("row ", row, "col ", col)

	if index == len(word) {
		return true
	}
	// if all char has been scanned and still looping
	if outbound(rowSize, colSize, row, col) {
		//		fmt.Println("outbound ", index)
		return false
	}
	//fmt.Println("index ", index)
	trie = trie.trieMap[word[index]]
	//fmt.Println("trie ", trie)
	if trie.word == wordStr {
		fmt.Println("found word", wordStr)
		return true
	}

	if board[row][col] != word[index] {
		//		fmt.Println("not found", index)
		return false
	}
	//fmt.Println("board value , row col", board[row][col], row, col, "current", word[index])

	tmp := board[row][col]
	board[row][col] = 64
	var result = false
	for i := 0; i < 4; i = i + 1 {
		//		fmt.Println("expend", index)
		result = result || expend(rowSize, colSize, row+dir[i], col+dir[i+1], board, index+1, word, wordStr, trie)
	}
	board[row][col] = tmp

	return result
}

func outbound(rowSize int, colSize int, row int, col int) bool {
	//fmt.Println("===============")
	return row < 0 || row >= rowSize || col < 0 || col >= colSize
}

func main() {
	fmt.Println("start")
	var board = [][]byte{
		{"A"[0], "B"[0], "C"[0], "E"[0]},
		{"S"[0], "F"[0], "C"[0], "S"[0]},
		{"A"[0], "D"[0], "E"[0], "E"[0]},
	}
	//var board = []byte{"a"[0], "b"[0], "c"[0], 0xE2, 0x86, 0x92}
	fmt.Println(board)

	insert("ABCCED")
	fmt.Println("result ABCCED", exist(board, "ABCCED"))
	fmt.Println("result SEE", exist(board, "SEE"))
	fmt.Println("result ABCB", exist(board, "ABCB"))
}

var root = newTrie()

type Trie struct {
	trieMap map[byte]Trie
	word    string
}

func newTrie() Trie {
	trie := Trie{}
	trie.trieMap = make(map[byte]Trie)
	return trie
}

func insert(word string) {
	arr := []byte(word)
	current := root
	for i := 0; i < len(arr); i = i + 1 {
		//fmt.Println("index ", i)
		if _, ok := current.trieMap[arr[i]]; !ok {
			tmp := newTrie()
			if i == len(arr)-1 {
				tmp.word = word
			}
			//		fmt.Println("current ", current)
			//		fmt.Println("tmp ", tmp)
			current.trieMap[arr[i]] = tmp
		}
		current, _ = current.trieMap[arr[i]]
	}
}
