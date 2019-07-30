package binary_search;
/*
 * tag
 * lintcode
 * url
 * leetcode 34. Find First and Last Position of Element in Sorted Array
 * url https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

//important 这道题答案有问题
public class FindFirstAndLastPositionOfElementinSortedArray {

    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * If the target is not found in the array, return [-1, -1].
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return this.search(0, nums.length - 1, nums, target, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public int[] search(int start, int end, int[] nums, int target, int max, int min) {

        int mid = (start + end) / 2;
        if (start < mid) {
            int[] a = search(start, mid, nums, target, max, min);
            int[] b = search(mid, end, nums, target, max, min);
            min = a[0];
            max = b[1];
        }
        if (nums[start] == target) {
            max = Math.max(start, max);
            min = Math.min(min, start);
        }
        if (nums[mid] == target) {
            max = Math.max(mid, max);
            min = Math.min(min, mid);
        }
        if (nums[end] == target) {
            max = Math.max(end, max);
            min = Math.min(min, end);
        }

        int[] result = {min, max};
        return result;
    }
}
