package algorithm.matric;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cicidi on 5/27/19
 * Lintcode
 * url
 */
//important 看leetcode trie 的 方法
public class WordSearchII {
    class Solution {
        public List<String> findWords(char[][] board, String[] words) {

            // write your code here
            List<String> result = new ArrayList<String>();
            if (words == null) {
                return result;
            }
            for (String word : words) {
                if (exist(board, word)) {
                    result.add(word);
                }
            }
            return result;
        }

        public boolean exist(char[][] board, String word) {
            // write your code here

            if (board == null || board.length == 0) {
                return false;
            }

            int rowLength = board.length;
            int colLength = board[0].length;
            boolean exist = false;
            for (int row = 0; row < rowLength; row++) {
                for (int col = 0; col < colLength; col++) {
                    exist = dfs(board, row, col, 0, word);
                    if (exist)
                        return exist;
                }
            }
            return false;

        }

        private boolean dfs(char[][] board, int row, int col, int index, String word) {
            //notice 0< row,col< length 经常忘 0<  还有index  不过这些都可以在test 里面测出来
            if (index == word.length() - 1) {
                return true;
            }
            if (row < 0 || col < 0 || row == board.length || col == board[0].length || index == word.length()) {
                return false;
            }
            if (board[row][col] == word.charAt(index)) {

                char c = board[row][col];
                board[row][col] = '0';
                boolean exist = dfs(board, row + 1, col, index + 1, word) ||
                        dfs(board, row, col + 1, index + 1, word) ||
                        dfs(board, row - 1, col, index + 1, word) ||
                        dfs(board, row, col - 1, index + 1, word);
                board[row][col] = c;
                return exist;
            }
            return false;
        }
    }
}