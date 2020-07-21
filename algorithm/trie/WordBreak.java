package trie;/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (36.75%)
 * Total Accepted:    422.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 * Note:
 *
 *
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 *
 *
 * Example 2:
 *
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> wordDict = Arrays.asList(new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"});
        System.out.println(wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return search(s, 0, wordDict);
    }

    public boolean search(String s, int start, List<String> wordDict) {
        for (String word : wordDict) {
            if (start + word.length() > s.length()) {
                continue;
            }
            String tmp = s.substring(start, start + word.length());
            if (word.equals(tmp)) {
                if (start + word.length() == s.length()) {
                    return true;
                }
                if (search(s, start + word.length(), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

}

class TrieNode {
    public String word;
    public Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
}

class Trie {
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                node.word = word;
            }
            if (node.children.get(arr[i]) != null) {
                node.children.put(arr[i], new TrieNode());
            }
            node = node.children.get(arr[i]);
        }
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.children.get(word.charAt(i));
            if (node == null) {
                return false;
            }
        }
        return word.equals(node.word);
    }
}
