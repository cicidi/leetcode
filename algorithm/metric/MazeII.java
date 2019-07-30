package algorithm.metric;

import java.util.LinkedList;
import java.util.Queue;

public class MazeII { //important 这道题的关键在碰壁才变向

    //notice  这里还有一个死循环的为题，也要cover 了
    // [
    // [0,0,1,0,0],
    // [0,0,0,0,0],
    // [0,0,1,0,0],
    // [0,0,1,1,1],
    // [0,0,0,0,0]]

    /**
     * @param maze:        the maze
     * @param start:       the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here

        int rowLength = maze.length;
        int colLength = maze[0].length;
        int[][] min = new int[rowLength][colLength];
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                min[row][col] = Integer.MAX_VALUE;  //notice 一开始把所有点都设置成最大
            }
        }
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(start[0], start[1], 0));  //notice 除了出发点，剩下的全部应该是撞墙点
        int[] dir = {-1, 0, 1, 0, -1};  //notice 学会这个变向方式
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            if (pos.dis >= min[pos.row][pos.col]) {  //notice 这个地方要写大于等于 反正走过的别再走了 ，另外走过的近的路也不走现在这条了
                continue;
            }
            min[pos.row][pos.col] = pos.dis; //notice 如果没有continue , 这条路看来最近
            for (int i = 0; i < 4; i++) {
                int row = pos.row;
                int col = pos.col;
                int dis = pos.dis;

                // important 用while loop 一个方向走到头
                while (row >= 0 && row < rowLength && col >= 0 && col < colLength && maze[row][col] == 0) {
                    row += dir[i];
                    col += dir[i + 1];
                    dis += 1;
                }
                // important 变向失败以后返回
                row -= dir[i];
                col -= dir[i + 1];
                dis -= 1;
                //notice 这个把刚才撞墙的点全部加了到queue 里面的点
                // red  总结 matrix 题， 只把专项的点加到queue 里面去
                queue.add(new Position(row, col, dis));
            }

        }
        return min[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : min[destination[0]][destination[1]];
    }
}

class Position {
    public int row;
    public int col;
    public int dis;

    public Position(int row, int col, int dis) {
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}