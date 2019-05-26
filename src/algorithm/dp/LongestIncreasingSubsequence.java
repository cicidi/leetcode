package algorithm.dp;

/*
  * tag
  * lintcode 76. Longest Increasing Subsequence
  * url https://www.lintcode.com/problem/longest-increasing-subsequence/my-submissions
  * url
  */
public class LongestIncreasingSubsequence {

    public int LongestIncreasingSubsequence(int[] nums) {
        int[] f = new int[nums.length];
        int max = 0;

        // function
        // if  num[j] < num[i]
        // if f[i] > f [j]+1
        // 对于每个数字，枚举前面所有小于自己的数字 j，Dp[i] = max{Dp[j]} + 1   这个1 是指num [i]
        //  then f [i] = f [j]+1

        // 对于数据里面的每一个数进行遍历
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;   // 每一个元素本身就是1
            // j 一直只能在i的前面
            for (int j = 0; j < i; j++) {
                if (f[i] > f[j] + 1) {
                    f[i] = f[j] + 1;
                }

            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }
}
