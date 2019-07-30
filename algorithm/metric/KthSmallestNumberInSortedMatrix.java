package algorithm.metric;

import java.util.PriorityQueue;

/**
 * @author cicidi on 5/26/19
 * Lintcode 401. Kth Smallest Number in Sorted Matrix
 * url https://www.lintcode.com/problem/kth-smallest-number-in-sorted-matrix/my-submissions
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input:
 * [
 * [1 ,5 ,7],
 * [3 ,7 ,8],
 * [4 ,8 ,9],
 * ]
 * k = 4
 * Output: 5
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2],
 * [3, 4]
 * ]
 * k = 3
 * Output: 3
 * Challenge
 * O*(klogn*) time, n is the maximum of the width and height of the matrix.
 */

/*
1 .has to use bfs in the quesiton
2. 首先从最小的开始
3。 然后往右，往下走， 并把两个数放到priority queue 里面，排完续 扔出来
* */
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

        Cell(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }
    }

}
