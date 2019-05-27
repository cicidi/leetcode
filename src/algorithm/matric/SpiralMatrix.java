package algorithm.matric;

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
            if (colLength - col == 1) {
                upToDown(matrix, col, row, rowLength, list);
                break;
            }
            if (rowLength - row == 1) {
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
        // System.out.printf("row %d \n",row);
        // System.out.printf("start %d \n",start);
        // System.out.printf("end %d \n",end);
        for (; start < end; start++) { // ?
            list.add(matrix[row][start]);
            if (matrix[row][start] == 8) {
            }
        }

    }

    public static void upToDown(int[][] matrix, int col, int start, int end, List<Integer> list) {
        for (; start < end; start++) { // ?
            list.add(matrix[start][col]);
            if (matrix[start][col] == 8) {
            }
        }
    }

    public static void rightToLeft(int[][] matrix, int row, int start, int end, List<Integer> list) {
        for (; start > end; start--) { // ?
            list.add(matrix[row][start]);
            if (matrix[row][start] == 8) {
            }
        }

    }

    public static void downToUp(int[][] matrix, int col, int start, int end, List<Integer> list) {
        for (; start > end; start--) { // ?
            list.add(matrix[start][col]);
            if (matrix[start][col] == 8) {
            }
        }
    }
}
