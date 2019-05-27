package algorithm.matric;

import java.util.PriorityQueue;

/**
 * @author cicidi on 5/26/19
 * Lintcode 401. Kth Smallest Number in Sorted Matrix
 * url https://www.lintcode.com/problem/kth-smallest-number-in-sorted-matrix/my-submissions
 */
public class KthSmallestNumberInSortedMatrix {
    /**
     * @param matrix: a matrix of integers
     * @param k:      An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix.length == 0 && matrix[0].length == 0) {
            return -1;
        }
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>((x, y) -> x.value - y.value);
        queue.add(new Cell(matrix[0][0], 0, 0));
        int[][] visit = new int[matrix.length][matrix[0].length];
        while (!queue.isEmpty()) {
            Cell cell = queue.remove();
            System.out.printf("cell value %d  \n ", cell.value);
            k--;
            if (k == 0) {
                return cell.value;
            }

            if (cell.row < matrix.length - 1 && visit[cell.row + 1][cell.column] == 0) {
                visit[cell.row + 1][cell.column] = 1;
                queue.add(new Cell(matrix[cell.row + 1][cell.column], cell.row + 1, cell.column));
            }
            if (cell.column < matrix[cell.row].length - 1 && visit[cell.row][cell.column + 1] == 0) {
                visit[cell.row][cell.column + 1] = 1;
                queue.add(new Cell(matrix[cell.row][cell.column + 1], cell.row, cell.column + 1));
            }

        }
        return -1;
    }

    class Cell {
        int value;
        int row;
        int column;

        public Cell(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }
    }

}
