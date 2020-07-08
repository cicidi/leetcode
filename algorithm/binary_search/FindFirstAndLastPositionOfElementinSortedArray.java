package binary_search;
/*
 * tag
 * lintcode
 * url
 * leetcode 34. Find First and Last Position of Element in Sorted Array
 * url https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

// important 这道题答案有问题
public class FindFirstAndLastPositionOfElementinSortedArray {

  /**
   * Given an array of integers nums sorted in ascending order, find the starting and ending
   * position of a given target value.
   *
   * <p>Your algorithm's runtime complexity must be in the order of O(log n).
   *
   * <p>If the target is not found in the array, return [-1, -1].
   *
   * <p>Example 1:
   *
   * <p>Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
   *
   * <p>Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
   */
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      return new int[] {-1, -1};
    }
    return this.search(0, nums.length - 1, nums, target, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public int[] search(int start, int end, int[] nums, int target, int max, int min) {

    int mid = (start + end) / 2;
    //        if (start < mid && nums[start] <= target && nums[end] >= target) {
    if (start < mid) {
      int[] a = search(start, mid, nums, target, max, min);
      int[] b = search(mid, end, nums, target, max, min);
      System.out.println("a0 " + a[0]);
      min = Math.min(min, a[0]);
      max = Math.max(max, b[1]);
      System.out.println("start < mid " + "max " + max + " min " + min);
    }
    if (nums[start] == target) {
      max = Math.max(start, max);
      min = Math.min(start, min);
      System.out.println("start = target " + " max " + max + " min " + min);
    }
    if (nums[mid] == target) {
      max = Math.max(max, mid);
      min = Math.min(min, mid);
      System.out.println("mid  = target " + " max " + max + " min " + min);
    }
    if (nums[end] == target) {
      max = Math.max(max, end);
      min = Math.min(min, end);
      System.out.println("end = target " + ": max " + max + " min " + min);
    }

    int[] result = {min, max};
    System.out.println(
        " result " + result[0] + " " + result[1] + " start " + start + " end " + end);
    return result;
  }

  public static void main(String[] args) {
    FindFirstAndLastPositionOfElementinSortedArray f =
        new FindFirstAndLastPositionOfElementinSortedArray();
    int[] arr = new int[] {5, 7, 7, 8, 8, 10};
    //        int[] arr = new int[]{1, 8, 8};
    int[] result = f.searchRange(arr, 8);
    System.out.println(result[0] + " " + result[1]);
  }
}

/*
 [5,7,7,8,8,10]


*/
