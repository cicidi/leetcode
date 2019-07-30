package algorithm.palindrome;

//Given a string,your task is to count how many palindromic substrings in this string.
//
//        The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
//
//        Example 1:
//
//        Input:"abc"
//        Output:3
//        Explanation:Three palindromic strings:"a","b","c".
//
//
//        Example 2:
//
//        Input:"aaa"
//        Output:6
//        Explanation:Six palindromic strings:"a","a","a","aa","aa","aaa".
// important 没看懂
public class FindTotalCountOfAllPalindrome {
    public class Solution {
        /**
         * @param str: s string
         * @return: return an integer, denote the number of the palindromic substrings
         */
        public int countPalindromicSubstrings(String str) {
            // write your code here
            int n = str.length();
            int ans = 0;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j <= i; ++j) {
                    dp[j][i] = ((str.charAt(j) == str.charAt(i)) && (i - j <= 2 || dp[j + 1][i - 1] == 1)) ? 1 : 0;
                    ans += dp[j][i];
                }
            }
            return ans;
        }
    }
}
