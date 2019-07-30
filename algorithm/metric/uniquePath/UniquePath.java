package metric.uniquePath;


// pink note :
// pink 先把横竖全部找一遍，用公式  某个cell 等于他上面的cell 和他左边cell 的路径之和
// pink 对于有障碍的题 也就是unique path  计算横竖的时候吧

public class UniquePath {
    public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            map[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
        }
        }
        return map[m - 1][n - 1];
    }
}