package binary_search;

/*
 * tag
 * lintcode
 * url
 * leetcode 33. Search in Rotated Sorted Array
 * url https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

/* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/
public class SearchInRotatedSortedArray_JZ_Recurrsion {
    public int search(int[] nums, int target) {
        // 也就是说在某个点重新按大小排序了
        // 而且要求复杂度是logn 也就是要1/2 这样的去找

        return search(0, nums.length - 1, nums, target);
    }

    public int search(int start, int end, int[] nums, int target) {
        if (nums.length == 0) return -1;

        if ((nums[start] > target || nums[end] < target) && isOrdered(start, end, nums)) {
            return -1;
        }

        int mid = start + (end - start) / 2; // while loop 的时候才会用 start+1 < end
        if (nums[mid] == target) return mid;
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        int i = -1, j = -1;
        if (start < mid) {  //import 如果recursion 替换二分法，那么就让start < mid  再另一个FindFirstAndLastPositionOfElementinSortedArray 的题里面也用到了
            i = search(start, mid, nums, target);
            j = search(mid, end, nums, target);
        }
        //单纯的用mid <end 不行 这个地方做的不对， 应为mid 可以等于start 但是不能等于end
        //得用start <mid 并且前面要check 左中右，然后还得把两个recursive search 放在if 里面
        // if (mid != end)

        return Math.max(i, j);

    }

    public boolean isOrdered(int start, int end, int[] nums) {
        if (nums[start] > nums[end]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        SearchInRotatedSortedArray_JZ_Recurrsion q33 = new SearchInRotatedSortedArray_JZ_Recurrsion();
        System.out.println(q33.search(nums, target));
    }
}
