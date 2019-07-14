package algorithm.subset;

import java.util.Arrays;

/**
 * @author cicidi on 5/26/19
 * Lintcode 836. Partition to K Equal Sum Subsets
 * url https://www.lintcode.com/problem/partition-to-k-equal-sum-subsets/description
 */
public class PartitionToKEqualSumSubsets {
    /**
     * @param nums: a list of integer
     * @param k:    an integer
     * @return: return a boolean, denote whether the array can be divided into k non-empty subsets whose sums are all equal
     */

    //important 大概记录一下note 这道题不会做，只能背
    // 先保证能够分，
    // 之后从最后一个数字开始， 算sum
    // 当index 遍历到-1  recursion 停止
    // 如果当前的partition true 就停止
    // 如果当前partition false 后悔算法，currentSubSum[i] -= selected;
    public boolean partitiontoEqualSumSubsets(int[] nums, int k) {
        // write your code here

        int length = nums.length;
        int sum = sum(nums);

        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);  // sort 的好处是先把大的数都处理掉了，

        return partition(nums, new int[k], length - 1, sum / k);
    }

    public boolean partition(int[] nums, int[] currentSubSum,
                             int indexOfSelected, int target) {

        if (indexOfSelected < 0) {
            return true;
        }
        int selected = nums[indexOfSelected];
        for (int i = 0; i < currentSubSum.length; i++) {
            if (currentSubSum[i] + selected <= target) {
                currentSubSum[i] += selected;
                if (partition(nums, currentSubSum, indexOfSelected - 1, target)) {
                    return true;
                } else {
                    currentSubSum[i] -= selected;
                }
            }
        }
        return false;
    }

    public int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
