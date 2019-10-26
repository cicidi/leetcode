package product;

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

    //notice 其实就是不断 的乘法 然后判断 正负
    public int maxProduct(int[] nums) {
        // 这里为什么使用一个array 而不是用 一个值呢？
        // 因为这里需要计算当current value 和previous product 的 乘积
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        min[0] = max[0] = nums[0];
        // notice 这个地方我忘记了， 因为有可能max 是个负数，然后这个又是一个
        //  integer array 那么nums可以是最大的
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // notice 一开始min[i] max[i] 都是nums[i] 因为前面有可能给个0 啥的 导致 0*max[i]or min[i] 都是0了
            min[i] = max[i] = nums[i];
            // 根据num[i] 的大小来决定max 和min  另外因为是integer 所以只会
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
