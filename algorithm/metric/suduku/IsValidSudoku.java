package metric.suduku;

import java.util.Arrays;

/**
 * @author cicidi on 2019-06-17
 * Lintcode
 * url
 */
public class IsValidSudoku {
    public static class Solution {
        public boolean isValidSudoku(char[][] board) {

            //important 只有一个 boolean array here
            //important 但是每次都重新fill false 一边 这样就可以是减少内存使用
            boolean[] visited = new boolean[9];

            // row
            for (int i = 0; i < 9; i++) {
                Arrays.fill(visited, false); // important Arrays.fill() method
                for (int j = 0; j < 9; j++) {
                    if (!process(visited, board[i][j]))
                        return false;
                }
            }

            //col
            for (int i = 0; i < 9; i++) {
                Arrays.fill(visited, false);
                for (int j = 0; j < 9; j++) {
                    if (!process(visited, board[j][i]))
                        return false;
                }
            }

            // sub matrix
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    Arrays.fill(visited, false);
                    for (int k = 0; k < 9; k++) {
                        if (!process(visited, board[i + k / 3][j + k % 3]))// important  这个地方把9哥格子刚好走完
                            return false;
                    }
                }
            }
            return true;

        }

        private boolean process(boolean[] visited, char digit) {
            if (digit == '.') {
                return true;
            }

            int num = digit - '0';

            // if visited 那么就给false 了
            if (num < 1 || num > 9 || visited[num - 1]) {
                return false;
            }

            visited[num - 1] = true;
            return true;
        }
    }
}
