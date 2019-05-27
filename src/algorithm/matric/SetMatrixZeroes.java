package algorithm.matric;

/**
 * @author cicidi on 5/26/19
 */

/*
  * tag
  * lintcode 162. Set Matrix Zeroes
  * https://www.lintcode.com/problem/set-matrix-zeroes/description
  */
public class SetMatrixZeroes {
    /**
     * @param matrix: A of lists of integers
     * @return: nothing
     */
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
