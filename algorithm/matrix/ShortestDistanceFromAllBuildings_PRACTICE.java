package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cicidi on 2019-07-06
 * Lintcode
 * url
 */
public class ShortestDistanceFromAllBuildings_PRACTICE {
    /**
     * @param grid: the 2D grid
     * @return: the shortest distance
     */
    // start from all buildings
    // use bfs move 4 directions
    // if is buildings or edge or visited
    // stop
    // when start from a building , totalbuilding++
    // have a distance [][]  to counter the distance to all buildings
    // have a canReadch[][] to count how many "reach" start from buildings
    // create a new visited[][] when start from a new building.

    // finally if canReach[][] equal to totalbuilding. get the smallest value from distance[][]
    public int shortestDistance(int[][] grid) {

        int[] dirX = new int[]{1, -1, 0, 0};
        int[] dirY = new int[]{0, 0, 1, -1};
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distance = new int[rows][cols];
        int[][] canReach = new int[rows][cols];
        int totalBuilding = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[rows][cols];
                    int dis = 0;
                    totalBuilding += 1;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {  //important  这个for loop 第一次做忘记了，这个非常重要，不然dis算不对
                            int[] current = queue.poll();
                            //notice 这个地方搞了一个null pointer 因为for loop 的k 没有++ 我写成-- 了

                            int x = current[0];
                            int y = current[1];
                            distance[x][y] += dis;  // notice 这里我之前写成 distance[i][j]  and canReach[i][j] 了 , distance 的这句话必须在 move direction 的外面
                            canReach[x][y] += 1;
                            for (int dir = 0; dir < 4; dir++) {
                                int xOffset = dirX[dir];
                                int yOffset = dirY[dir];
                                if (valid(rows, cols, x + xOffset, y + yOffset, visited, grid)) { // 这里要用current[0]+ dirX[dir]  我用了i+dirX[dir]  c


                                    queue.offer(new int[]{x + xOffset, y + yOffset});
                                    visited[x + xOffset][y + yOffset] = true;// visited 的这句话必须在move direction 的里面
                                }
                            }

                        }
                        dis += 1;// 这个要计算在 for loop queue 之外

                    }
                }
            }
        }

        // System.out.printf("totalBuilding %d  \n ",totalBuilding);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReach[i][j] == totalBuilding && grid[i][j] == 0 && distance[i][j] < min) { // 这里必须grid[i][j]==0
                    min = distance[i][j];
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    public boolean valid(int rows, int cols, int x, int y, boolean[][] visited, int[][] grid) {

        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || grid[x][y] != 0) {
            return false;
        } else {
            return true;
        }
    }
}
