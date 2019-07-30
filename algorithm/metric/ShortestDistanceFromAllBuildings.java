package metric;

/*
 * important
 * notice
 * green
 * url
 * leetcode
 *
 * 分析
 *
 * Description
中文
English
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Have you met this question in a real interview?
Example
Example 1

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output: 7
Explanation:
In this example, there are three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
Example 2

Input: [[1,0],[0,0]]
Output: 1
In this example, there is one buildings at (0,0).
1 - 0
|   |
0 - 0
The point (1,0) or (0,1) is an ideal empty land to build a house, as the total travel distance of 1 is minim

* Related problems
* lintcode 912 BestMeetingPoint  WallsAndGates / BuildPostOffice II
 *
 *note
 * 1 The idea of solve this problem is to start from all building, and go 4 directions. if arrive edge or block or visited , then do not move forward at this direction.
Use a distance metric to cumulate distance when move in the metric. When finish the distance metric should contains distance between the point at that position with all canReached building.

When to finish
	-> Once all all building route done.
How to find shortest path
	-> if the point in metric can reached by all building. find the smallest value;

1 prepare  ,
	rows cols,
	check null
	distance[][] ->global
	canReach[][] ->global
		vistited[][] is create for each building travel -> building travel level
2 start travel from all building
3 get lowest distance

 * * */


import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1}, {0, 1, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 1}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {0, 1, 1, 1, 1, 0}
        };
        Solution s = new Solution();
        System.out.println(s.shortestDistance(input));
    }

    static class Solution {
        int[] rowDir = {0, 0, 1, -1};
        int[] colDir = {1, -1, 0, 0};

        public int shortestDistance(int[][] grid) {
            // write your code here

            if (grid == null || grid.length == 0) return -1;

            int rows = grid.length;
            int cols = grid[0].length;

            int[][] dist = new int[rows][cols];
            // notice 每一个点在不同的 起点出发的时候，有可能会被reach 到， 最多reach 次数应该是building 总数
            int[][] canReach = new int[rows][cols];
            int totalBuilding = 0;

            // for loop metric
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        totalBuilding++;
                        bfs(grid, i, j, canReach, dist, rows, cols);
                    }
                }
            }
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 0 && dist[i][j] < result && canReach[i][j] == totalBuilding) {
                        result = dist[i][j];
                    }
                }
            }
            if (result == Integer.MAX_VALUE) {
                return -1;
            }
            return result;
        }

        void bfs(int[][] grid, int row, int col, int[][] canReach, int[][] dist, int rows, int cols) {
            boolean[][] visited = new boolean[rows][cols];
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{row, col});
            int distance = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = q.poll();
                    canReach[cur[0]][cur[1]]++;
                    dist[cur[0]][cur[1]] += distance;
                    for (int dir = 0; dir < 4; dir++) {
                        int rr = cur[0] + rowDir[dir];
                        int cc = cur[1] + colDir[dir];
                        if (!isValid(rr, cc, visited, grid, rows, cols)) {
                            continue;
                        }
                        visited[rr][cc] = true;
                        q.offer(new int[]{rr, cc});
                    }
                }
                distance++;
            }
        }

        boolean isValid(int rr, int cc, boolean[][] visited, int[][] grid, int rows, int cols) {
            return rr >= 0 && rr < rows && cc >= 0 && cc < cols && !visited[rr][cc] && grid[rr][cc] == 0;

        }
    }
}
