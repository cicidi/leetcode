/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/description/
 *
 * algorithms
 * Medium (41.89%)
 * Total Accepted:    286.9K
 * Total Submissions: 679.7K
 * Testcase Example:  '[1,2,3,1]'
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element
 * and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 *
 * Example 2:
 *
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2,
 * or index number 5 where the peak element is 6.
 *
 *
 * Note:
 *
 * Your solution should be in logarithmic complexity.
 *
 */
package binary_search;

//这个方法不正确，
// java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 1
//  at line 19, Solution.findPeak
//  at line 3, Solution.findPeakElement
//  at line 54, __DriverSolution__.__helper__
//  at line 84, __Driver__.main
public class FindPeekElement {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 1};
        int[] arr = new int[]{1, 2, 1, 3, 5, 6, 4};
        FindPeekElement fp = new FindPeekElement();
        System.out.println(fp.findPeakElement(arr));
    }

    public int findPeakElement(int[] nums) {
        int result = findPeak(nums, 1, nums.length - 1);
        return result;
    }

    public int findPeak(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        if (start == end - 1) {
            if (nums[start] < nums[end]) {
                return end;
            } else {
                return start;
            }
        }
        int mid = start + (end - start) / 2;
        if (nums[mid - 1] <= nums[mid] && nums[mid] >= nums[mid + 1]) {
            return mid;
        } else if (nums[mid - 1] > nums[mid]) {
            return findPeak(nums, start, mid);
        } else {
            return findPeak(nums, mid + 1, end);
        }
    }
}
