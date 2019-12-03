/*
 * @lc app=leetcode id=839 lang=golang
 *
 * [839] Similar String Groups
 *
 * https://leetcode.com/problems/similar-string-groups/description/
 *
 * algorithms
 * Hard (35.74%)
 * Total Accepted:    13.4K
 * Total Submissions: 36.6K
 * Testcase Example:  '["tars","rats","arts","star"]'
 *
 * Two strings X and Y are similar if we can swap two letters (in different
 * positions) of X, so that it equals Y.
 * 
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2),
 * and "rats" and "arts" are similar, but "star" is not similar to "tars",
 * "rats", or "arts".
 * 
 * Together, these form two connected groups by similarity: {"tars", "rats",
 * "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group
 * even though they are not similar.  Formally, each group is such that a word
 * is in the group if and only if it is similar to at least one other word in
 * the group.
 * 
 * We are given a list A of strings.  Every string in A is an anagram of every
 * other string in A.  How many groups are there?
 * 
 * 
 * Example 1:
 * Input: A = ["tars","rats","arts","star"]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= A.length <= 2000
 * 1 <= A[i].length <= 1000
 * A.length * A[i].length <= 20000
 * All words in A consist of lowercase letters only.
 * All words in A have the same length and are anagrams of each other.
 * The judging time limit has been increased for this question.
 * 
 * 
 */
func numSimilarGroups(A []string) int {
    
}
