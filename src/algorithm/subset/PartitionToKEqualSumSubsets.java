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
    public boolean partitiontoEqualSumSubsets(int[] nums, int k) {
        // write your code here

        int length = nums.length;
        int sum = sum(nums);

        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);

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
