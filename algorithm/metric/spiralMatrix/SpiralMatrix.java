package metric.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cicidi on 5/26/19
 */
/*
 * tag
 * lintcode 374. Spiral Matrix
 * https://www.lintcode.com/problem/spiral-matrix/description
 */

/*
* Description
中文
English
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Have you met this question in a real interview?
Example
Example 1:

Input:	[[ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2

Input:	[[ 6,4,1 ], [ 7,8,9 ]]
Output: [6,4,1,9,8,7]*/



public class SpiralMatrix {
    /**
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    // write your code here
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int row = 0;
        int col = 0;

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int m = rowLength;
        int n = colLength;
        List<Integer> list = new ArrayList<Integer>();
        while (row < rowLength && col < colLength) {
            if (colLength - col == 1) {// important 这道题的这个条件，也就是两个列之间如果只差1行，那么就不是一个环，要么上下来一遍，
                // green spiralMMatrix 1 的方法好一点
                upToDown(matrix, col, row, rowLength, list);
                break;
            }
            if (rowLength - row == 1) {//important （接前面）要么左右来一遍
                leftToRight(matrix, row, col, colLength, list);
                break;
            }
            leftToRight(matrix, row, col, colLength - 1, list);
            upToDown(matrix, colLength - 1, row, rowLength - 1, list);
            rightToLeft(matrix, rowLength - 1, colLength - 1, col, list);
            downToUp(matrix, col, rowLength - 1, row, list);
            row++;
            col++;
            rowLength -= 1;
            colLength -= 1;

        }
        return list;
    }

    public static void leftToRight(int[][] matrix, int row, int start, int end, List<Integer> list) {
        for (; start < end; start++) { // 移动的时候，这个start  ，start 和end 的关系， start 的加减 需要多注意
            list.add(matrix[row][start]);
        }

    }

    public static void upToDown(int[][] matrix, int col, int start, int end, List<Integer> list) {
        for (; start < end; start++) { // ?
            list.add(matrix[start][col]);
        }
    }

    public static void rightToLeft(int[][] matrix, int row, int start, int end, List<Integer> list) {
        for (; start > end; start--) { // ?
            list.add(matrix[row][start]);
        }

    }

    public static void downToUp(int[][] matrix, int col, int start, int end, List<Integer> list) {
        for (; start > end; start--) { // ?
            list.add(matrix[start][col]);
        }
    }
}
