package metric;

/**
 * @author cicidi on 5/26/19
 */

/*
  * tag
  * lintcode 162. Set Matrix Zeroes
  * https://www.lintcode.com/problem/set-matrix-zeroes/description
  *
  Description
中文
English
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Have you met this question in a real interview?
Example
Example 1:

Input:[[1,2],[0,3]]
Output:[[0,2],[0,0]]
Example 2:

Input:[[1,2,3],[4,0,6],[7,8,9]]
Output:[[1,0,3],[0,0,0],[7,0,9]]
  */
public class SetMatrixZeroes {
    /**
     * @param matrix: A of lists of integers
     * @return: nothing
     */

    //important 我自己写的这个方法用了m*n 的space 这样不好
    //notice 答案里给的方法是， 先检测用第一行和第一例做标签， 如果某个cell 有0 ，那么另他的row 和col 的对应的第一个都设置成0
    //notice 然后我们在根据第一行，或者第一列有没有0 把所有的cell 遍历
    //important 在这之前需要做一步是因为第一行和第一列被认为添加0 了，所以需要先判断他们之前有没有0， 如果之前有0，需要在这之后把
    //important 行列都变成0
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        // write your code here
        int rowSize = matrix.length;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < rowSize; i++) {
            maxLength = Math.max(maxLength, matrix[i].length);
        }
        int[][] hasZero = new int[rowSize][maxLength];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    hasZero[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (hasZero[i][j] == 1) {
                    System.out.printf("i: %d j: %d \n", i, j);
                    for (int col = 0; col < matrix[i].length; col++) {
                        matrix[i][col] = 0;
                    }
                    for (int row = 0; row < rowSize; row++) {
                        matrix[row][j] = 0;
                    }
                }
            }
        }
    }
}
