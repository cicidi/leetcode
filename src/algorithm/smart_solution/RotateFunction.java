package algorithm.smart_solution;

/**
 * @author cicidi on 5/27/19
 * Lintcode 1260. Rotate Function
 * url https://www.lintcode.com/problem/rotate-function/description
 * Description
 * 中文
 * English
 * Given an array of integers A and let n to be its length.
 * <p>
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 * <p>
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * <p>
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * <p>
 * n is guaranteed to be less than 10^5.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Example1
 * <p>
 * Input:
 * [4, 3, 2, 6]
 * Output: 26
 * Explanation:
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * <p>
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * Example2
 * <p>
 * Input:
 * [-2,0,1]
 * Output: 2
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        // Write your code here
        int sum = 0;
        int F1 = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            F1 += i * A[i];
        }
        int max = F1;
        for (int i = 1; i < A.length; i++) {
            F1 = F1 + sum - A[A.length - i] * A.length;
            max = Math.max(F1, max);
        }
        return max;
    }
}
