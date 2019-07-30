/*
 * @lc app=leetcode id=91 lang=golang
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.32%)
 * Total Accepted:    272.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 *
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 *
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 *
 * Example 1:
 *
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 *
 * Example 2:
 *
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 *
 */
package main

/*
 * notice
 * important
 * relative
 * category
 * green
 * yellow
 * red
 * orange
 * blue
 * brown
 *
 * url
 * leetcode
 *
 * 分析
 * */

func main() {

}

func numDecodings(s string) int {
	return 0
}

// ol -> original length
func createChildren(originLength int, current []string, l int) ([][]string, bool) {
	if originLength-l*2 < 2 {
		return nil, false
	}
	var children [][]string
	for i, s := range current {
		if i+1 < len(current) && len(string(current[i])) == 1 && len(string(current[i+1])) == 1 {
			c := current[0:i]
			append(c, string(current[i])+string(current[i+1]))
			if (i+2 < len(current) {
				append(c, string(current[i+2])
			}
			append(children, c)
		}
	}

}
