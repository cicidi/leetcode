package company.Karta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindRectAngle {
    public static void main(String[] argv) {
        // Tex's test cases here
        int[][] image1 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        int[][] image2 = {
                {0},
        };

        int[][] image3 = {
                {1},
        };

        int[][] image4 = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
        };

        FindRectAngle solution = new FindRectAngle();
        List<Integer[]> results = solution.findRectangle(image1);
        for (Integer[] result : results) {
            System.out.println(Arrays.toString(result));
        }

    }

    public List<Integer[]> findRectangle(int[][] matrix) {

        if (matrix.length == 0) {
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] startPoint = new int[2];
//     boolean stop = false;
//     for (int i = 0; i< row; i++){
//       if (stop){
//         break;
//       }
//       for (int j = 0; j< col; j ++){
//         if (matrix[i][j] == 0){
//           startPoint[0] =i ;
//           startPoint[1] =j ;
//           stop = true;
//           break;
//         }
//       }
//     }

//      boolean stop = false;
        List<Integer[]> points = this.findPoints(matrix, row, col);
        List<Integer[]> results = getResults(points, row, col, matrix);
        //     System.out.println(startRow);
//     System.out.println(startCol);
        return results;
    }

    public List<Integer[]> getResults(List<Integer[]> points, int row, int col, int[][] matrix) {
        List<Integer[]> results = new ArrayList<>();
        for (Integer[] startPoint : points) {
            int startRow = startPoint[0];
            int startCol = startPoint[1];
            int endRow = 0;
            int endCol = 0;
//      for (int i = startPoint[0]; i< row; i++){
//       for (int j = startPoint[1]; j< col; j ++){
//           if (matrix[i][j]!=0&&j+1=col){
//             endCol = j;
//           }
//       }

//     }
            while (startRow < row) {
//       System.out.println("row "+ startRow);
                int val = matrix[startRow][startPoint[1]];

                if (val != 0) {
//         startRow--;
                    break;
                }
                startRow++;
            }

            while (startCol < col) {
//       System.out.println("col "+ startCol);
                int val = matrix[startPoint[0]][startCol];

                if (val != 0) {
//         startCol--;
                    break;
                }
                startCol++;
            }
            results.add(new Integer[]{startPoint[0], startPoint[1], startRow - startPoint[0], startCol - startPoint[1]});
        }

        return results;
    }

    public List<Integer[]> findPoints(int[][] matrix, int row, int col) {

        List<Integer[]> results = new ArrayList<>();
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == 0 && j == 0) {
                    if (matrix[i][j] == 0) {
                        results.add(new Integer[]{i, j});
                        System.out.println("0,0 " + i + " " + j);
                    }
                    continue;
                }
                if (i == 0) {
                    if (matrix[i][j - 1] == 1 && matrix[i][j] == 0) {
                        results.add(new Integer[]{i, j});
                        System.out.println("0,?" + i + " " + j);
                    }
                    continue;
                }
                if (j == 0) {
                    if (matrix[i - 1][j] == 1 && matrix[i][j] == 0) {
                        results.add(new Integer[]{i, j});
                        System.out.println("?,0" + i + " " + j);
                    }
                    continue;
                }
                if (matrix[i][j - 1] == 1 && matrix[i - 1][j] == 1) {
                    if (matrix[i][j] == 0) {
                        System.out.println("upleft: i , j " + i + " " + j + " " + matrix[i - 1][j - 1]);
                        results.add(new Integer[]{i, j});
                        System.out.println("?,?" + i + " " + j);
                    }
                    continue;
                }
            }
        }

        return results;
    }
}

/*

Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0.

The image you get is known to have potentially many distinct rectangles of 0s on a background of 1s. Write a function that takes in the image and returns the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.

image1 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [0, 1, 1, 0, 0, 0, 1],
  [1, 0, 1, 0, 0, 0, 1],
  [1, 0, 1, 1, 1, 1, 1],
  [1, 0, 1, 0, 0, 1, 1],
  [1, 1, 1, 0, 0, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

Sample output variations (only one is necessary):

findRectangles(image1) =>
  // (using top-left and bottom-right):
  [
    [[0,0],[0,0]],
    [[2,0],[2,0]],
    [[2,3],[3,5]],
    [[3,1],[5,1]],
    [[5,3],[6,4]],
    [[7,6],[7,6]],
  ]
  // (using top-left and width/height):
  [
    [[0,0],[1,1]],
    [[2,0],[1,1]],
    [[2,3],[3,2]],
    [[3,1],[1,3]],
    [[5,3],[2,2]],
    [[7,6],[1,1]],
  ]

Other test cases:

image2 = [
  [0],
]

findRectangles(image2) =>
  // (using top-left and bottom-right):
  [
    [[0,0],[0,0]],
  ]

  // (using top-left and width/height):
  [
    [[0,0],[1,1]],
  ]

image3 = [
  [1],
]

findRectangles(image3) => []

image4 = [
  [1, 1, 1, 1, 1],
  [1, 0, 0, 0, 1],
  [1, 0, 0, 0, 1],
  [1, 0, 0, 0, 1],
  [1, 1, 1, 1, 1],
]

findRectangles(image4) =>
  // (using top-left and bottom-right or top-left and width/height):
  [
    [[1,1],[3,3]],
  ]

n: number of rows in the input image
m: number of columns in the input image
 */
