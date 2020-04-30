package array;

/*
 * important
 * notice
 * green
 * url
 * leetcode
 *
 *
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 * 分析
 * */

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        int[] input = new int[]{
                2, 2, 2
        };
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.searchRange(input, 2)));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int l = 0, r = nums.length - 1, m = 0;
            int[] result = new int[]{-1, -1}; // notice 起始 给result一个只 { -1, -1}
            while (l + 1 < r) {
                m = l + (r - l) / 2;
                if (target == nums[m]) {
                    r = m;
                }
                if (target < nums[m]) {
                    r = m;
                }
                if (target > nums[m]) {
                    l = m;
                }
            }
            if (nums[r] == target) {  // important  这个地方和一般的 2分发最后一步不太一样，这里要先check 右边，再check左边
                result[0] = r;
            }
            if (nums[l] == target) {
                result[0] = l;
            }
            l = 0;                  // important 这里要reset l, r 的值
            r = nums.length - 1;
            while (l + 1 < r) {
                m = l + (r - l) / 2;
                if (target == nums[m]) {
                    l = m;
                }
                if (target < nums[m]) {
                    r = m;
                }
                if (target > nums[m]) {
                    l = m;
                }

            }

            if (nums[l] == target) {    // important  这个地方和一般的 2分发最后一步不太一样，这里要先check 左边，再check 右边
                result[1] = l;
            }
            if (nums[r] == target) {
                result[1] = r;
            }
            return result;
        }
    }
// =====================================================================
    public int[] searchRangeSolution2(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findLeft(nums, target);
        result[1] = findRight(nums, target);
        return result;
    }

    //    5, 7,7,8,8,10
    //    8 8 10 11 12
    public int findLeft(int[] nums, int target){
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                 right = mid - 1;
            }else{ // nums[mid] > target
                right = mid - 1;
            }
            if (nums[mid] == target){
                  index = mid;
            }
        }

        return index;
    }
    //    7,7,8,8,10
    //    8 8 10 11 12
    public int findRight(int[] nums, int target){
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                 left = mid + 1;
            }else{ // nums[mid] > target
                right = mid - 1;
            }
            if (nums[mid] == target){
                  index = mid;
            }
        }

        return index;
    }
}
