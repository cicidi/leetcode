/*
 * @lc app=leetcode id=58 lang=golang
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.31%)
 * Total Accepted:    315K
 * Total Submissions: 973.6K
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 *
 * Example:
 *
 *
 * Input: "Hello World"
 * Output: 5
 *
 *
 *

 *analysis
 	0  - >return 0
	check each  char, if space , reset -> true, continue
		have a flag reset only if c is not space and reset , result = 1 other wise keep 0
 	return last result
*/

package main

import "fmt"

func lengthOfLastWord(s string) int {
	var reset = true
	var result = 0
	for _, c := range s {
		if c == ' ' {
			reset = true
			continue
		} else {
			if reset {
				result = 1
				reset = false
			} else {
				result += 1
			}
		}
	}
	return result
}

func main() {
	fmt.Println(lengthOfLastWord("Hello World"))
	fmt.Println(lengthOfLastWord(" Hello World"))
	fmt.Println(lengthOfLastWord("Hello World test "))
}
