package metric;

/**
 * @author cicidi on 5/26/19
 */

/*
  * tag
  * lintcode 161. Rotate Image
  * https://www.lintcode.com/problem/alien-dictionary/description
  */
public class RotateImage {
    /**
     * @param matrix: a lists of integers
     * @return: nothing
     */
    public void rotate(int[][] matrix) {
        // write your code here

        int length = matrix.length;
        yFold(matrix, length);
        xFold(matrix, length);
    }

    public void yFold(int[][] matrix, int length) {
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length / 2; col++) { //notice 对折 length/2
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[row][length - 1 - col];
                matrix[row][length - 1 - col] = tmp;
            }
        }
    }

    public void xFold(int[][] matrix, int length) {
        for (int row = 0; row < length; row++) {
            for (int col = 0; col + row < length - 1; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[length - 1 - col][length - 1 - row];
                matrix[length - 1 - col][length - 1 - row] = tmp;
            }
        }
    }

}
