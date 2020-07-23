package matrix;

/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 *
 * https://leetcode.com/problems/dungeon-game/description/
 *
 * algorithms
 * Hard (28.10%)
 * Total Accepted:    75.1K
 * Total Submissions: 264K
 * Testcase Example:  '[[-2,-3,3],[-5,-10,1],[10,30,-5]]'
 *
 * table.dungeon, .dungeon th, .dungeon td {
 * ⁠ border:3px solid black;
 * }
 *
 * ⁠.dungeon th, .dungeon td {
 * ⁠   text-align: center;
 * ⁠   height: 70px;
 * ⁠   width: 70px;
 * }
 *
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 *
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health
 * (negative integers) upon entering these rooms; other rooms are either empty
 * (0's) or contain magic orbs that increase the knight's health (positive
 * integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 *
 *
 *
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN ->
 * DOWN.
 *
 *
 *
 *
 * -2 (K)
 * -3
 * 3
 *
 *
 * -5
 * -10
 * 1
 *
 *
 * 10
 * 30
 * -5 (P)
 *
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight
 * enters and the bottom-right room where the princess is imprisoned.
 *
 *
 */
public class DungeonGame {

    public static void main(String[] args) {
        int[][] d = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        DungeonGame dg = new DungeonGame();
        System.out.println(dg.calculateMinimumHP(d));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        return run(dungeon, 0, 0, 1, 1);
    }

    public int run(int[][] d, int m, int n, int curHp, int minHp) {
        if (curHp + d[m][n] < 1) {
            minHp += 1 - curHp - d[m][n];
            curHp = 1;
        } else {
            curHp += d[m][n];
        }
        if (m < d.length - 1 && n < d[0].length - 1) {
            return Math.min(run(d, m + 1, n, curHp, minHp), run(d, m, n + 1, curHp, minHp));
        } else if (m < d.length - 1) {
            return run(d, m + 1, n, curHp, minHp);
        } else if (n < d[0].length - 1) {
            return run(d, m, n + 1, curHp, minHp);
        } else {
            return minHp;
        }
    }
}
