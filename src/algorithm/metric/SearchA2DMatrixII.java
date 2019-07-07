package algorithm.metric;

/**
 * @author cicidi on 5/26/19
 */

/*
 * tag
 * lintcode 38. Search a 2D Matrix II
 * https://www.lintcode.com/problem/search-a-2d-matrix-ii/description
 */

public class SearchA2DMatrixII {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */

    //important 本体的关键是从左下角搜索
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            System.out.print("row: ");
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            System.out.print("column: ");
            return 0;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        int occurrence = 0;
        System.out.printf("row %d column %d", matrix.length, matrix[0].length);
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > target) {
                System.out.printf("i: %d j: %d \n", i, j);
                j--;
            } else {
                if (matrix[i][j] < target) {
                    System.out.printf("i: %d j: %d \n", i, j);
                    i++;
                } else {
                    if (matrix[i][j] == target) {
                        System.out.printf("i: %d j: %d \n", i, j);
                        i++;
                        j--;
                        occurrence++;
                    }
                }
            }
        }
        System.out.printf("occ: %d j: %d \n", i, j, occurrence);
        return occurrence;
    }


}
