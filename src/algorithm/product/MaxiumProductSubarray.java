package algorithm.product;
/*
  * tag
  * lintcode
  * leetcode 152. Maximum Product Subarray
  * url https://leetcode.com/problems/maximum-product-subarray/
  */
public class MaxiumProductSubarray {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */

    //note 其实就是不断 的成 然后判断 正负
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        min[0] = max[0] = nums[0];
        // result 最少是个 num 【0】
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 一开始min[i] 都是nums【】
            min[i] = max[i] = nums[i];
            // 根据num[i] 的大小来决定max 和min  另外因为是interger 所以只会
            // product 越来越大，然后呢 去掉 负值就可以了：
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }
}
