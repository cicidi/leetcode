package product;

/**
 * @author cicidi on 5/27/19
 * Lintcode 1310
 * url https://www.lintcode.com/problem/product-of-array-except-self/description
 */


/**
 *            2     ->    3    ->     4     ->     5
 *            |     \    |     \      |      \     |\
 *            1         (1*2)      (1*2*3)      (1*2*3*4)
 *                        \            \            \
 *         1*5*4*3      <1*5*4        <1*5         <*1
 *            /           /            /            /
 *       (1*1*5*3*4)  (1*2*1*4*5)  (1*2*3*1*5)  (1*1*2*3*4)
 */

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}